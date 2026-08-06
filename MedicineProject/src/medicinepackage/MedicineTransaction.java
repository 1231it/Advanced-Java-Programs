package medicinepackage;
import java.sql.*;
public class MedicineTransaction {
    Connection con;
    public void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/pharmacydb","root",  "svecw@123");
            System.out.println("Connection Established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateMedicinePrice(int medicineid, int price) {
        try {
            String query = "UPDATE medicine SET price=? WHERE medicineid=?";
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, price);
            ps.setInt(2, medicineid);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                con.commit();
                System.out.println("Medicine Price Updated Successfully");
            } else {
                con.rollback();
                System.out.println("Transaction Rollback");
            }
            ps.close();
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
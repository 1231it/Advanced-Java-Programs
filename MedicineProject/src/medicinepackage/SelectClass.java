package medicinepackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class SelectClass {
    Connection con;
    PreparedStatement pstmt;
    public void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/pharmacydb","root", "svecw@123");
            System.out.println("Connection Established");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void selectMedicine() {
        try {
            String query = "SELECT * FROM medicine";
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Medicine ID\tMedicine Name\tExpiry Date\tPrice");
            while (rs.next()) {
            	 System.out.println(
                         rs.getInt("medicineid") + "\t\t"+ rs.getString("medicinename") + "\t\t" + rs.getString("expirydate")+"\t\t" + rs.getDouble("price"));
             }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    
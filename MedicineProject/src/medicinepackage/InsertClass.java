package medicinepackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertClass {
    Connection con;
    PreparedStatement pstmt;
    public void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "svecw@123");
            System.out.println("Connection Established");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertMedicine() {
        int medicineid = 1257;
        String medicinename = "Paracetamol";
        String expirydate = "2027-12-31";
        double price = 50.00;
        try {
            String query = "INSERT INTO medicine(medicineid, medicinename, expirydate, price) VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, medicineid);
            pstmt.setString(2, medicinename);
            pstmt.setString(3, expirydate);
            pstmt.setDouble(4, price);
            int rows = pstmt.executeUpdate();
            System.out.println("Rows Inserted = " + rows);
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

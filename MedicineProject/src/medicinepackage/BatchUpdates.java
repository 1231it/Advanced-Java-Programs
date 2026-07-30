package medicinepackage;

import java.sql.*;
import java.util.ArrayList;
public class BatchUpdates {
    Connection con;
    PreparedStatement pstmt;
    public void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb","root","svecw@123");
            System.out.println("Connection Established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void batchInsert() {
        ArrayList<String> medicines = new ArrayList<>();
        medicines.add("4011,Crocin,2028-12-31,120");
        medicines.add("4012,Azithromycin,2029-05-10,250");
        medicines.add("4013,Cetrizine,2027-08-15,80");
        try {
            String query = "INSERT INTO medicine(medicineid,medicinename,expirydate,price) VALUES(?,?,?,?)";
            pstmt = con.prepareStatement(query);
            for (String medicine : medicines) {
                String[] columns = medicine.split(",");
                pstmt.setInt(1, Integer.parseInt(columns[0]));
                pstmt.setString(2, columns[1]);
                pstmt.setString(3, columns[2]);
                pstmt.setInt(4, Integer.parseInt(columns[3]));
                pstmt.addBatch();
            }
            int[] result = pstmt.executeBatch();
            System.out.println("Records Inserted = " + result.length);
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void batchUpdate() {
        ArrayList<String> medicines = new ArrayList<>();
        medicines.add("101,60");
        medicines.add("1231,70");
        medicines.add("1232,220");
        try {
            String query = "UPDATE medicine SET price=? WHERE medicineid=?";
            pstmt = con.prepareStatement(query);
            for (String medicine : medicines) {
                String[] columns = medicine.split(",");
                pstmt.setInt(1, Integer.parseInt(columns[1]));
                pstmt.setInt(2, Integer.parseInt(columns[0]));
                pstmt.addBatch();
            }
            int[] result = pstmt.executeBatch();
            System.out.println("Records Updated = " + result.length);
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void displayMedicines() {
        try {
            String query = "SELECT * FROM medicine";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("\nMedicine Details");
            System.out.println("----------------------------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("medicineid") + "  " +rs.getString("medicinename") + "  " +rs.getString("expirydate") + "  " +  rs.getInt("price"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
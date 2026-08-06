package medicinepackage;

import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetClass {

    Connection con;
    CachedRowSet crs;

    public CachedRowSetClass() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pharmacydb",
                    "root",
                    "svecw@123");

            con.setAutoCommit(false);

            System.out.println("Connection Established");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void cachedRowSetDemo() {

        try {

            crs = RowSetProvider.newFactory().createCachedRowSet();

            crs.setUrl("jdbc:mysql://localhost:3306/pharmacydb");
            crs.setUsername("root");
            crs.setPassword("svecw@123");

            crs.setCommand("SELECT * FROM medicine");

            crs.execute();

            System.out.println("\nMedicine Details\n");

            while (crs.next()) {

                System.out.println("Medicine ID   : " + crs.getInt("medicineid"));
                System.out.println("Medicine Name : " + crs.getString("medicinename"));
                System.out.println("Expiry Date   : " + crs.getString("expirydate"));
                System.out.println("Price         : " + crs.getInt("price"));
                System.out.println("-----------------------------");

            }

            if (crs.absolute(2)) {

                System.out.println("\nSecond Row");

                System.out.println("Medicine ID   : " + crs.getInt("medicineid"));
                System.out.println("Medicine Name : " + crs.getString("medicinename"));
                System.out.println("Expiry Date   : " + crs.getString("expirydate"));
                System.out.println("Price         : " + crs.getInt("price"));

                // Update Second Row
                crs.updateInt("price", 500);
                crs.updateRow();

                System.out.println("\nSecond Row Updated");

            }

            // Insert New Row
            crs.moveToInsertRow();

            crs.updateInt("medicineid", 7001);
            crs.updateString("medicinename", "Crocin");
            crs.updateString("expirydate", "2030-12-31");
            crs.updateInt("price", 120);

            crs.insertRow();

            crs.moveToCurrentRow();

            crs.acceptChanges(con);

            con.commit();

            System.out.println("\nRecord Updated and Inserted Successfully");

            crs.close();
            con.close();

        } catch (Exception e) {

            try {

                con.rollback();

            } catch (Exception ex) {

                System.out.println(ex);

            }

            System.out.println(e);

        }

    }

}
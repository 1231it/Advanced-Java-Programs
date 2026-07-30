package medicinepackage;
import java.sql.*;
public class MedicineOperations
{
    Connection con;
    CallableStatement cst;
    ResultSet rs;
    public MedicineOperations()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb","root","svecw@123");
            System.out.println("Connection Established");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
  
    public void getMedicineDetails()
    {
        try
        {
            cst = con.prepareCall("{call get_medicine_details(?,?)}");
            cst.setInt(1,101);
            cst.registerOutParameter(2,Types.VARCHAR);
            cst.execute();
            System.out.println("Procedure Medicine Name : " + cst.getString(2));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    } 
    public void getMedicineFunction()
    {
        try
        {
            cst = con.prepareCall("{? = call get_medicinename_from_medicine(?)}");
            cst.registerOutParameter(1,Types.VARCHAR);
            cst.setInt(2,101);
            cst.execute();
            System.out.println("Function Medicine Name : " + cst.getString(1));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
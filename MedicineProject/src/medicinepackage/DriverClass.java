
//package medicinepackage;
//public  class DriverClass{
//public static void main(String[] args) {
//    UpdateClass obj = new UpdateClass();
//SelectClass obj = new SelectClass();
//    InsertClass obj = new InsertClass();
//    obj.createConnection();
//    obj.insertMedicine();
//    obj.selectMedicine();
//  obj.updation();
//}
//}
package medicinepackage;
public class DriverClass {
    public static void main(String[] args) {
        MedicineOperations obj = new MedicineOperations();
        obj.getMedicineDetails();
        obj.getMedicineFunction();
    }
}
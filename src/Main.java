import java.util.*;

abstract class Vehicle {
    public int vehicleNo;
    private String VehicleType;
    public int capacity;
    Vehicle(int vehicleNo, String VehicleType)
    {
        this.vehicleNo = vehicleNo;
        this.VehicleType = VehicleType;

    }




}

class Truck extends Vehicle{
    Truck(int vehicleNo, String VehicleType, int capacity) {
        super(vehicleNo, VehicleType);
        this.capacity = capacity;
    }
}
class VehicleController{
    List<Vehicle> vehicleList;
    VehicleController()
    {
        this.vehicleList=new ArrayList<>();
    }

    public void AddVehicles(Vehicle v) {
        vehicleList.add(v);
    }

    public void RemoveVehicles(Vehicle v)
    {
        vehicleList.remove(v);
    }

}

 class Pallete{
    int palleteid;
    public Pallete(int palleteid)
    {
        this.palleteid=palleteid;
    }
 }

class Employee{

    int EmployeeId;
    String EmployeeName;

    Employee(int employeeId, String employeeName)
    {
        this.EmployeeId=employeeId;
        this.EmployeeName = employeeName;


    }
}

class AddPalletToTheTruck{
    Employee e;
    HashMap<Integer, ArrayList<Integer>> VehicleIDVsPalletStored;

    AddPalletToTheTruck(Employee e)
    {
        this.e=e;
        this.VehicleIDVsPalletStored = new HashMap<>();
    }

    public void EmployeeAddPalletToTruck(Vehicle v, Pallete p)
    {
        if (v.capacity == 0) {
            System.out.println("Truck is full");
            return;
        }
        if (VehicleIDVsPalletStored.get(v.vehicleNo) == null) {
            VehicleIDVsPalletStored.put(v.vehicleNo, new ArrayList<>());
        }
        VehicleIDVsPalletStored.get(v.vehicleNo).add(p.palleteid);
        v.capacity--; // Decrease capacity when adding a pallet
        System.out.println(" Employee "+ e.EmployeeName+ " added "+ " pallete "+ p.palleteid + " to the Vehicle "+ v.vehicleNo+" successfully! ");

    }

    public void EmployeeRemovePalletToTruck(Vehicle v, Pallete p)
    {
        if(VehicleIDVsPalletStored.size()==0 || VehicleIDVsPalletStored.get(v)==null){
            System.out.println("No such pallet in no vehicle");
        }else{
            VehicleIDVsPalletStored.get(v.vehicleNo).remove(p.palleteid);
            v.capacity++;
        }

    }


}
public class Main {
    public static void main(String[] args) {

        VehicleController v = new VehicleController();
        Vehicle vehicle = new Truck(1001,"PlayTruck", 3);
        System.out.println(vehicle.capacity);
        v.AddVehicles(vehicle);
        Pallete p1 = new Pallete(12);
        Pallete p2 = new Pallete(23);
        Pallete p3 = new Pallete(10);
        Pallete p4 = new Pallete(11);
        Employee e = new Employee(100, "anna");
        AddPalletToTheTruck addWorkRemoveWorkByEmployee = new AddPalletToTheTruck(e);
        addWorkRemoveWorkByEmployee.EmployeeAddPalletToTruck(vehicle, p1);
        addWorkRemoveWorkByEmployee.EmployeeAddPalletToTruck(vehicle, p2);
        addWorkRemoveWorkByEmployee.EmployeeAddPalletToTruck(vehicle, p3);
        addWorkRemoveWorkByEmployee.EmployeeAddPalletToTruck(vehicle, p4);




    }



}
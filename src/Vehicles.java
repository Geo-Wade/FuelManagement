import java.util.*;

public class Vehicles {
    private static HashSet<VehicleRecord> vehicles;

    private Vehicles(){}

    public static HashSet<VehicleRecord> getVehicles(){
        createIfNull();
        return vehicles;
    }
    public static boolean add(VehicleRecord vehicle) {
        createIfNull();
        if(vehicle.getRecordField().values().stream().noneMatch(Optional::isEmpty)){
            vehicles.add(vehicle);
            return true;
        }
        return false;
    }
    private static void createIfNull(){
        if(vehicles == null){
            vehicles = new HashSet<>();
        }
    }
}

import java.util.*;

public class Vehicles {
    private final static HashSet<VehicleRecord> vehicles = new HashSet<>();

    private Vehicles(){}

    public static HashSet<VehicleRecord> getVehicles(){
        return vehicles;
    }
    public static boolean add(VehicleRecord vehicle) {
        if(!isDuplicate(vehicle)){
            vehicles.add(vehicle);
            return true;
        }
        return false;
    }
    public static boolean isDuplicate(VehicleRecord vehicle){
        return vehicles.stream()
                .map(VehicleRecord::getVehicleID)
                .anyMatch(id -> id.equals(vehicle.getVehicleID()));
    }
}

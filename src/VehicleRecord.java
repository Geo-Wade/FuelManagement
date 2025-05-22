import java.util.*;

public class VehicleRecord extends Record{
    private String vehicleID;
    private int vehicleYear;
    private int vehicleOdometer;
    private String vehicleMake;
    private String vehicleModel;

    final static String VEHICLE_ID_TOKEN = "Vehicle ID";
    final static String VEHICLE_YEAR_TOKEN = "Vehicle Year";
    final static String VEHICLE_MAKE_TOKEN = "Vehicle Make";
    final static String VEHICLE_MODEL_TOKEN = "Vehicle Model";
    final static String VEHICLE_ODOMETER_TOKEN = "Vehicle Odometer";

    @Override
    void assignRecord(String key, String field) {
        switch (key){
            case VEHICLE_ID_TOKEN -> {
                vehicleID = field;
            }
            case VEHICLE_YEAR_TOKEN -> {
                vehicleYear = Integer.parseInt(field);
            }
            case VEHICLE_MAKE_TOKEN -> {
                vehicleMake = field;
            }
            case VEHICLE_MODEL_TOKEN -> {
                vehicleModel = field;
            }
            case VEHICLE_ODOMETER_TOKEN -> {
                vehicleOdometer = Integer.parseInt(field);
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<String> getFieldTokens(){
        return Arrays.asList(
                VEHICLE_ID_TOKEN,
                VEHICLE_YEAR_TOKEN,
                VEHICLE_MAKE_TOKEN,
                VEHICLE_MODEL_TOKEN,
                VEHICLE_ODOMETER_TOKEN
        );
    }

    public String getVehicleID()
    {
        return vehicleID;
    }

    public long getVehicleYear()
    {
        return vehicleYear;
    }

    public String getVehicleMake()
    {
        return vehicleMake;
    }

    public String getVehicleModel()
    {
        return vehicleModel;
    }
    @Override
    public String toString()
    {
        return "Vehicle ID: " + getVehicleID()
                + "\n"
                + "Vehicle Year: " + getVehicleYear()
                + "\n"
                + "Vehicle Make: " + getVehicleMake()
                + "\n"
                + "Vehicle Model: " + getVehicleModel()
                + "\n";

    }
    private static boolean isInt(String string)
    {
        try{
            Integer.parseInt(string);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }
    private static boolean isLong(String string)
    {
        try{
            Long.parseLong(string);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }
}

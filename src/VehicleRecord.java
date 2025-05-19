import java.util.*;

public class VehicleRecord extends Record{
    private String vehicleID;
    private int vehicleYear;
    private Long vehicleOdometer;
    private String vehicleMake;
    private String vehicleModel;
    private

    final static String VEHICLE_ID_TOKEN = "Vehicle ID";
    final static String VEHICLE_YEAR_TOKEN = "Vehicle Year";
    final static String VEHICLE_MAKE_TOKEN = "Vehicle Make";
    final static String VEHICLE_MODEL_TOKEN = "Vehicle Model";
    final static String VEHICLE_ODOMETER_TOKEN = "Vehicle Odometer";


    public VehicleRecord()
    {
        recordFields = new LinkedHashMap<>();
        recordFields.put(VEHICLE_ID_TOKEN, Optional.empty());
        recordFields.put(VEHICLE_YEAR_TOKEN,Optional.empty());
        recordFields.put(VEHICLE_MAKE_TOKEN,Optional.empty());
        recordFields.put(VEHICLE_MODEL_TOKEN,Optional.empty());
        recordFields.put(VEHICLE_ODOMETER_TOKEN,Optional.empty());
    };

    public Map<String, Optional<String>> initRecord (){
        return recordFields;
    }
    @Override
    boolean assignRecord() {
        for(String key : recordFields.keySet())
        {
            switch (key){
                case VEHICLE_ID_TOKEN:
                    vehicleID = recordFields.get(key).orElse("Not Data Recorded");
                    break;
                case VEHICLE_YEAR_TOKEN:
                {
                   if(isInt(recordFields.get(key).orElse("Not an int"))){
                    vehicleYear = Integer.parseInt(recordFields.get(key).orElse("No Data Recorded"));
                    break;
                }
                }
                case VEHICLE_MAKE_TOKEN:
                    vehicleMake = recordFields.get(key).orElse("No Data Recorded");
                    break;
                case VEHICLE_MODEL_TOKEN:
                    vehicleModel = recordFields.get(key).orElse("No Data Recorded");
                case VEHICLE_ODOMETER_TOKEN:
                    if(isLong(recordFields.get(key).orElse("No Data Recorded"))) {
                        vehicleOdometer = Long.parseLong(recordFields.get(key).orElse("No Data Recorded"));
                    }
                default:
                    System.out.println("Invalid Data Provided TO Record: " + key);
                    break;
            }
        }
        return recordFields.values().stream().filter(Optional::isEmpty).toList().isEmpty();
    }

    public Boolean setNewOdometer()
    {
        return false;
    }
    public String getVehicleID()
    {
        return vehicleID;
    }

    public long getVehicleYear()
    {
        return vehicleYear;
    }

    public long getVehicleOdometer()
    {
        return vehicleOdometer;
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

        //considering returning the previous operator who used this vehicle
    }
    private static boolean isInt(String string)
    {
        try{
            int x = Integer.parseInt(string);
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
            long x = Long.parseLong(string);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }
};

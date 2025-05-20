import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class TankRecord extends Record {
    private String tankID;
    private int tankNumber;
    private int tankCapacity;
    private int fuelVolume;
    final static String TANK_ID_TOKEN = "Tank ID";
    final static String TANK_NUMBER_TOKEN = "Tank Number";
    final static String TANK_CAPACITY_TOKEN = "Tank Capacity";
    final static String FUEL_VOLUME_TOKEN = "Price";

    public TankRecord() {
        recordFields = new LinkedHashMap<>();
        recordFields.put(TANK_ID_TOKEN, Optional.empty());
        recordFields.put(TANK_NUMBER_TOKEN, Optional.empty());
        recordFields.put(TANK_CAPACITY_TOKEN, Optional.empty());
        recordFields.put(FUEL_VOLUME_TOKEN, Optional.empty());
    }

    public Map<String, Optional<String>> initRecord() {
        return recordFields;
    }

    @Override
    boolean assignRecord() {
        for (String key : recordFields.keySet()) {
            switch (key) {
                case TANK_ID_TOKEN:
                    tankID = recordFields.get(key).orElse("No Data Recorded");
                    break;
                case TANK_NUMBER_TOKEN: {
                    if (isInt(recordFields.get(key).orElse("No Data Recorded"))) {
                        tankNumber = Integer.parseInt(recordFields.get(key).orElse("No Data Recorded"));
                    }
                    break;
                }
                case TANK_CAPACITY_TOKEN: {
                    if (isInt(recordFields.get(key).orElse("No Data Recorded"))) {
                        tankCapacity = Integer.parseInt(recordFields.get(key).orElse("No Data Recorded"));
                    }
                    break;
                }
                case FUEL_VOLUME_TOKEN: {
                    if (isInt(recordFields.get(key).orElse("No Data Recorded"))) {
                        fuelVolume = Integer.parseInt(recordFields.get(key).orElse("No Data Recorded"));
                    }
                }
                default:
                    System.out.println("Invalid Data Provided To Record: " + key);
                    break;
            }
        }
        return recordFields.values().stream().filter(Optional::isEmpty).toList().isEmpty();
    }

    public String getTankID() {
        return tankID;
    }

    public int getTankNumber() {
        return tankNumber;
    }

    public float getTankCapacity() {
        return tankCapacity;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    @Override
    public String toString() {
        return "Operator ID: " + getTankID()
                + "\n"
                + "Operator First Name: " + getTankNumber()
                + "\n"
                + "Operator Last Name: " + getTankCapacity()
                + "\n"
                + "Operator Last Name: " + getFuelVolume();
    }

    private static boolean isInt(String string) {
        try {
            float x = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isFloat(String string) {
        try {
            float x = Float.parseFloat(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}

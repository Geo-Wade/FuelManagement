import java.util.*;

public class TankRecord extends Record {
    private String tankID;
    private int tankNumber;
    private int tankCapacity;
    private int fuelVolume;
    final static String TANK_ID_TOKEN = "Tank ID";
    final static String TANK_NUMBER_TOKEN = "Tank Number";
    final static String TANK_CAPACITY_TOKEN = "Tank Capacity";
    final static String FUEL_VOLUME_TOKEN = "Price";


    @Override
    void assignRecord(String key, String field) {
        switch (key) {
            case TANK_ID_TOKEN -> {
                tankID = field;
            }
            case TANK_NUMBER_TOKEN -> {
                tankNumber = Integer.parseInt(field);
            }
            case TANK_CAPACITY_TOKEN -> {
                tankCapacity = Integer.parseInt(field);
            }
            case FUEL_VOLUME_TOKEN -> {
                fuelVolume = Integer.parseInt(field);
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<String> getFieldTokens() {
        return Arrays.asList(
                TANK_ID_TOKEN,
                TANK_NUMBER_TOKEN,
                TANK_CAPACITY_TOKEN,
                FUEL_VOLUME_TOKEN
                );
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
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isFloat(String string) {
        try {
            Float.parseFloat(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}

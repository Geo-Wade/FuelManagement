public class EquipmentRecord {
    private final String ID;
    private int year;
    private String make;
    private String model;
    private int odometer;

    EquipmentRecord(String ID, int year, String make, String model, int odometer){
        this.ID = ID;
        this.year = year;
        this.make = make;
        this.model = model;
        this.odometer = odometer;
        writeToFile();
    }

    private void writeToFile() {
        EquipmentWriter equipmentWriter = new EquipmentWriter();
        equipmentWriter.writeToFile(this);
    }

    public String getID() {
        return ID;
    }

    public int getYear() {
        return year;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getOdometer(){
        return odometer;
    }

    public EquipmentRecord setYear(int year){
        this.year = year;
        return this;
    }

    public EquipmentRecord setMake(String make){
        this.make = make;
        return this;
    }

    public EquipmentRecord setModel(String model){
        this.model = model;
        return this;
    }

    public EquipmentRecord setOdometer(int odometer){
        this.odometer = odometer;
        return this;
    }

}

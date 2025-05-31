public class EquipmentRecordCreator extends RecordCreator{
    @Override
    void createRecord(ConsoleIO IO) {
        promptForFields(IO);
    }

    @Override
    void promptForFields(ConsoleIO IO) {
         String ID = IO.getStringInput("Please Enter Equipment ID");
         int year = IO.getIntInput("Please enter the vehicle year");
         String make = IO.getStringInput("Please enter equipment make");
         String model = IO.getStringInput("Please enter equipment model");
         int odometer = IO.getIntInput("Please enter equipment starting odometer");
         new EquipmentRecord(ID, year, make, model, odometer);
    }
}

public class OperatorRecordCreator extends RecordCreator {
    @Override
    void createRecord(ConsoleIO IO) {
        promptForFields(IO);
    }

    @Override
    void promptForFields(ConsoleIO IO) {
        String ID = IO.getStringInput("Please enter operator ID");
        String firstName = IO.getStringInput("Please enter operator first name");
        String lastName = IO.getStringInput("Please enter operator last name");
        OperatorRecord operatorRecord = new OperatorRecord(ID, firstName, lastName);
        operatorRecord.writeToFile();
    }
}

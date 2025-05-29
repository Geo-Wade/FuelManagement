public class OperatorRecord {
    private final String ID;
    private String firstName;
    private String lastName;
    OperatorRecord(String ID, String firstName, String lastName){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public OperatorRecord setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public OperatorRecord setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public String getID(){
        return ID;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void writeToFile(){
        OperatorWriter.writeToFile(this);
    }
}

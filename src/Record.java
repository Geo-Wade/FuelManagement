
import java.util.*;

abstract class Record {

    abstract void assignRecord(String key, String field);

    public abstract List<String> getFieldTokens();

    static void recordCreator(UserAssignedRecord recordAssignment, RecordType recordType){
        Record record;
        switch (recordType)
        {
            case EQUIPMENT -> {
                record = new VehicleRecord();
                record.getFieldTokens().forEach(x -> {
                    record.assignRecord(x, recordAssignment.AssignRecordFields(x));
                });
                if(!Vehicles.add((VehicleRecord)record)) {
                    recordFailedError();
                }
            }
            case OPERATOR -> {
                record = new OperatorRecord();
                record.getFieldTokens().forEach(x -> {
                    record.assignRecord(x, recordAssignment.AssignRecordFields(x));
                });
                if(!Operators.add((OperatorRecord)record)) {
                    recordFailedError();
                }
            }
            case PRODUCT -> {
                record = new ProductRecord();
                record.getFieldTokens().forEach(x -> {
                    record.assignRecord(x, recordAssignment.AssignRecordFields(x));
                });
                if(!Products.add((ProductRecord)record)) {
                    recordFailedError();
                }
            }
            case TANK -> {
                record = new TankRecord();
                record.getFieldTokens().forEach(x -> {
                    record.assignRecord(x, recordAssignment.AssignRecordFields(x));
                });
                if(!Tanks.add((TankRecord)record)) {
                    recordFailedError();
                }
            }
            case FUELING_POSITION -> {
                //TODO - implement fueling positions class
                /*record = new FuelingPosition();
                recordAssignment.AssignRecordFields(record.getRecordField());
                if (!FuelingPositions.add((FuelingPositionRecord) record)) {
                    recordFailedError();
                }*/
            }
            default -> System.out.println("Invalid Record Type: " + recordType);

        }
    }
    private static void recordFailedError(){
        System.out.println("Failed to create record");
    }
}

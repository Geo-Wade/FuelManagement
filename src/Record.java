import com.sun.source.tree.Tree;

import java.util.*;

abstract class Record {
    protected LinkedHashMap<String, Optional<String>> recordFields;

    abstract Map<String, Optional<String>> initRecord();

    abstract boolean assignRecord();

    final Map<String, Optional<String>> getRecordField() {
        return recordFields;
    }

    static void recordCreator(UserAssignedRecord recordAssignment, RecordType recordType){
        Record record;
        switch (recordType)
        {
            case EQUIPMENT -> {
                record = new VehicleRecord();
                recordAssignment.AssignRecordFields(record.getRecordField());
                if(!Vehicles.add((VehicleRecord)record)) {
                    recordFailedError();
                }
            }
            case OPERATOR -> {
                record = new OperatorRecord();
                recordAssignment.AssignRecordFields(record.getRecordField());
                if(!Operators.add((OperatorRecord)record)) {
                    recordFailedError();
                }
            }
            case PRODUCT -> {
                record = new ProductRecord();
                recordAssignment.AssignRecordFields(record.getRecordField());
                if (!Products.add((ProductRecord) record)) {
                    recordFailedError();
                }
            }
            case TANK -> {
                record = new TankRecord();
                recordAssignment.AssignRecordFields(record.getRecordField());
                if (!Tanks.add((TankRecord) record)) {
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

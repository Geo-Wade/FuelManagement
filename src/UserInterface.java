import java.util.*;

public class UserInterface {
    //Implements Home Prompt
    //Static option to for other classes to print correction prompts
    Scanner scanner;

    UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void firstPrompt() {

        boolean valid = true;
        while (valid) {
            System.out.println("""
                    What Action Would you like to perform
                    1 - Edit Record
                    2 - Begin Fueling - Not Implemented
                    3 - reset - Kills Program""");
            switch (MenuHandler.handleSelection(scanner.nextLine())) {
                case MenuSelectionEnum.FIRST_OPTION_SELECTED -> homePromptEditRecordSelected();
                case MenuSelectionEnum.SECOND_OPTION_SELECTED ->
                        System.out.println("Begin Fueling has not been implemented");
                case MenuSelectionEnum.THIRD_OPTION_SELECTED -> valid = false;
                default -> invalidSelection();
            }
        }
    }

    public void homePromptEditRecordSelected() {
        boolean keepPresenting = true;
        while (keepPresenting) {
            System.out.println("""
                    Which would you like to edit?
                    1 - Equipment
                    2 - Operator
                    3 - Product
                    4 - Tank
                    5 - Fueling Position - Not Implemented
                    6 - Exit - Not Implemented 
                    """);
            switch (MenuHandler.handleSelection(scanner.nextLine())) {
                case MenuSelectionEnum.FIRST_OPTION_SELECTED -> editRecordPromptEquipmentSelected(RecordType.EQUIPMENT);
                case MenuSelectionEnum.SECOND_OPTION_SELECTED -> editRecordPromptEquipmentSelected(RecordType.OPERATOR);
                case MenuSelectionEnum.THIRD_OPTION_SELECTED -> editRecordPromptEquipmentSelected(RecordType.PRODUCT);
                case MenuSelectionEnum.FOURTH_OPTION_SELECTED -> editRecordPromptEquipmentSelected(RecordType.TANK);
                case MenuSelectionEnum.FIFTH_OPTION_SELECTED ->
                        System.out.println("Fueling Position Selection has not been handled yet");
                case MenuSelectionEnum.SIXTH_OPTION_SELECTED -> keepPresenting = false;
                default -> invalidSelection();
            }
        }
    }

    public void editRecordPromptEquipmentSelected(RecordType recordType) {
        boolean keepPresenting = true;
        while (keepPresenting) {
            System.out.println("""
                    What would you like to do to the record?
                    1 - Add
                    2 - Edit - Not Implemented
                    3 - Exit""");
            switch (MenuHandler.handleSelection(scanner.nextLine())) {
                case FIRST_OPTION_SELECTED -> {
                    addSelectedRecord(recordType);
                }
                case SECOND_OPTION_SELECTED -> {
                    System.out.println(("Edit has not been handled yet"));
                }
                case THIRD_OPTION_SELECTED -> {
                    keepPresenting = false;
                }
                default -> invalidSelection();
            }
        }
    }

    public void addSelectedRecord(RecordType recordType) {
        UserAssignedRecord RecordAssignments = x -> {
            for (Map.Entry<String, Optional<String>> entry : x.entrySet()) {
                System.out.print("Enter a value for " + entry.getKey() + ": ");
                entry.setValue(Optional.ofNullable(scanner.nextLine()));
            }
        };
        Record record;
        switch (recordType) {
            case RecordType.EQUIPMENT:
                record = new VehicleRecord();
                RecordAssignments.AssignRecordFields(record.getRecordField());
                if (!Vehicles.add((VehicleRecord) record)) {
                    System.out.println("Record Not Saved!");
                }
                break;
            case RecordType.OPERATOR:
                record = new OperatorRecord();
                RecordAssignments.AssignRecordFields(record.getRecordField());
                if (!Operators.add((OperatorRecord) record)) {
                    System.out.println("Record Not Saved!");
                }
                break;
            case RecordType.PRODUCT:
                record = new ProductRecord();
                RecordAssignments.AssignRecordFields(record.getRecordField());
                if (!Products.add((ProductRecord) record)) {
                    System.out.println("Record Not Saved!");
                }
                break;
            case RecordType.TANK:
                record = new TankRecord();
                RecordAssignments.AssignRecordFields(record.getRecordField());
                if (!Tanks.add((TankRecord)record)){

                }
                break;
            default:
                System.out.println("Invalid Record Type: " + recordType);
        }
    }

    public void invalidSelection() {
        System.out.println("Please select a valid option from the menu");
    }
}

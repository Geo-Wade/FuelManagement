
public class UserInterface {
    public void entryPrompt() {

        boolean valid = true;
        while (valid) {
            MenuOutputHandler.entryPromptOutput();
            switch (MenuInputHandler.getMenuSelection()) {
                case MenuSelectionEnum.FIRST_OPTION_SELECTED -> selectRecord();
                case MenuSelectionEnum.SECOND_OPTION_SELECTED ->
                        System.out.println("Begin Fueling has not been implemented");
                case MenuSelectionEnum.THIRD_OPTION_SELECTED -> {
                    MenuInputHandler.inputClose();
                    valid = false;
                }
                default -> MenuOutputHandler.invalidSelection();
            }
        }
    }
    public void selectRecord() {
        boolean keepPresenting = true;
        while (keepPresenting) {
            MenuOutputHandler.selectRecordOutput();
            switch (MenuInputHandler.getMenuSelection()) {
                case MenuSelectionEnum.FIRST_OPTION_SELECTED -> selectRecordAction(RecordType.EQUIPMENT);
                case MenuSelectionEnum.SECOND_OPTION_SELECTED -> selectRecordAction(RecordType.OPERATOR);
                case MenuSelectionEnum.THIRD_OPTION_SELECTED -> selectRecordAction(RecordType.PRODUCT);
                case MenuSelectionEnum.FOURTH_OPTION_SELECTED -> selectRecordAction(RecordType.TANK);
                case MenuSelectionEnum.FIFTH_OPTION_SELECTED ->
                        System.out.println("Fueling Position Selection has not been handled yet");
                case MenuSelectionEnum.SIXTH_OPTION_SELECTED -> keepPresenting = false;
                default -> MenuOutputHandler.invalidSelection();
            }
        }
    }

    public void selectRecordAction(RecordType recordType) {
        boolean keepPresenting = true;
        while (keepPresenting) {
            MenuOutputHandler.SelectRecordActionOutput();
            switch (MenuInputHandler.getMenuSelection()) {
                case FIRST_OPTION_SELECTED -> {
                    UserAssignedRecord recordAssignments = x -> {
                        MenuOutputHandler.promptForField(x);
                        return MenuInputHandler.getInputString();
                    };
                    Record.recordCreator(recordAssignments, recordType);
                }
                case SECOND_OPTION_SELECTED -> {
                    System.out.println(("Edit has not been handled yet"));
                }
                case THIRD_OPTION_SELECTED -> {
                    keepPresenting = false;
                }
                default -> MenuOutputHandler.invalidSelection();
            }
        }
    }
}

import java.util.Optional;

public class AddRecordCommand implements ICommand {
    public void execute(ConsoleIO consoleIO){
        Optional<RecordCreator> recordCreator = Optional.empty();
        while(recordCreator.isEmpty()){
            recordCreator = recordCreatorSelector(consoleIO.getIntInput("""
                    Please make a selection
                    1) Add Operator\t2) Add Equipement"""));
        }
        recordCreator.orElseThrow().createRecord(consoleIO);
    }
    private Optional<RecordCreator> recordCreatorSelector(int selection)
    {
        switch (selection){
            case 1 -> {
                return Optional.of(new OperatorRecordCreator());
            }
            case 2 -> {
                return Optional.of(new EquipmentRecordCreator());
            }
            default -> {
                return Optional.empty();
            }
        }
    }
}

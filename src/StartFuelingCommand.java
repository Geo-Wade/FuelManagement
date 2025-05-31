import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StartFuelingCommand implements ICommand {
    public void execute(ConsoleIO consoleIO) {
        if(FuelingManager.getFuelingManager().fuelingPositions.stream().noneMatch(Predicate.not(FuelingPosition::isFueling))){
            System.out.println("No Available Hoses");
            return;
        }
        String eqID = getEqID(consoleIO);
        String opID = getOpID(consoleIO);
        if (isAuthorized(eqID, opID)) {
                int selection = (consoleIO.getIntInput(buildHosePromptList())) - 1;
                String hoseID = FuelingManager.getFuelingManager()
                        .getHoses()
                        .stream().filter(position -> position.getHoseNumber() == selection)
                        .map(FuelingPosition::getHoseID)
                        .findFirst()
                        .orElse(null);
                if(hoseID != null) {
                    FuelingTransaction fuelingTransaction = new FuelingTransaction(hoseID, eqID, opID);
                    FuelingManager.getFuelingManager().startFuelingTransaction(fuelingTransaction);
                }
                else{
                    System.out.println(("Selected Hose is not available"));
                }
        }
    }

    private boolean isAuthorized(String equipID, String opID) {
        FuelingAuthorizor fuelingAuthorizor = new FuelingAuthorizor();
        return (fuelingAuthorizor.authorizeEquipment(equipID) && fuelingAuthorizor.authorizeOperator(opID));
    }

    private String buildHosePromptList() {
        List<FuelingPosition> fuelingPositions = FuelingManager.getFuelingManager().fuelingPositions;
        StringBuilder stringBuilder = new StringBuilder("Please select a hose\n");
        int perLine = 0;
        for (int count = 0; count <= fuelingPositions.size() - 1; count++) {
            if(!fuelingPositions.get(count).isFueling()) {
                stringBuilder.append(fuelingPositions.get(count).getHoseNumber() + 1)
                        .append(") ")
                        .append(fuelingPositions.get(count).getHoseID())
                        .append("\t");
                perLine++;
            }
            if (perLine >= 4) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private String getEqID(ConsoleIO consoleIO) {
        return consoleIO.getStringInput("Please Enter Equipment ID");
    }

    private String getOpID(ConsoleIO consoleIO) {
        return consoleIO.getStringInput("Please Enter Operator ID");
    }
}

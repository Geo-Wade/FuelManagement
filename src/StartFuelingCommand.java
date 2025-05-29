import java.util.List;

public class StartFuelingCommand implements ICommand {
    public void execute(ConsoleIO consoleIO) {
        String eqID = geteqID(consoleIO);
        String opID = getopID(consoleIO);
        if (isAuthorized(eqID, opID)) {
            int selection = (consoleIO.getIntInput(buildHosePromptList())) - 1;
            String HoseID = FuelingManager.getFuelingManager()
                    .getHoses()
                    .stream()
                    .map(FuelingPosition::getHoseID)
                    .toList()
                    .get(selection);
            FuelingTransaction fuelingTransaction = new FuelingTransaction(HoseID, eqID, opID);
            FuelingManager.getFuelingManager().startFuelingTransaction(fuelingTransaction);
        }
    }

    private boolean isAuthorized(String equipID, String opID) {
        FuelingAuthorizor fuelingAuthorizor = new FuelingAuthorizor();
        return (fuelingAuthorizor.authorizeEquipment(equipID) && fuelingAuthorizor.authorizeOperator(opID));
    }

    private String buildHosePromptList() {
        List<FuelingPosition> fuelingPositions = FuelingManager.getFuelingManager().fuelingPositions;
        StringBuilder stringBuilder = new StringBuilder();
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

    private String geteqID(ConsoleIO consoleIO) {
        return consoleIO.getStringInput("Please Enter Equipment ID");
    }

    private String getopID(ConsoleIO consoleIO) {
        return consoleIO.getStringInput("Please Enter Operator ID");
    }
}

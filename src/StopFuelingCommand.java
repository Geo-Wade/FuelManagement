import java.util.List;
import java.util.NoSuchElementException;

public class StopFuelingCommand implements ICommand{
    public void execute(ConsoleIO consoleIO) {
        if(FuelingManager.getFuelingManager().fuelingPositions.stream().noneMatch(FuelingPosition::isFueling)) {
            System.out.println("No Hoses Fueling");
            return;
        }
        try {
            int hoseSelection = consoleIO.getIntInput(buildHosePromptList());
            FuelingManager.getFuelingManager()
                    .stopFuelingTransaction(FuelingTransaction.getOpenTransactionByHose(FuelingManager.getFuelingManager()
                            .fuelingPositions.stream()
                            .map(FuelingPosition::getHoseID)
                            .toList().get(hoseSelection - 1)));
        } catch (NoSuchElementException ex) {
            System.out.println("hose does not appear to be fueling at this time");
        }
    }

    private String buildHosePromptList() {
        List<FuelingPosition> fuelingPositions = FuelingManager.getFuelingManager().fuelingPositions;
        StringBuilder stringBuilder = new StringBuilder();
        int perLine = 0;
        for (int count = 0; count <= fuelingPositions.size() - 1; count++) {
            if(fuelingPositions.get(count).isFueling()) {
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
}

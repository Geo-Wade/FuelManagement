import java.util.ArrayList;
import java.util.List;

public class FuelingManager {
    private static FuelingManager fuelingManager;
    List<FuelingPosition> fuelingPositions = new ArrayList<>();
    private FuelingManager(){}
    public void startFuelingTransaction(FuelingTransaction fuelingTransaction) {
        fuelingPositions.stream()
                .filter(x -> x.getHoseID().equalsIgnoreCase(fuelingTransaction.getHoseID()))
                .filter(x -> !x.isFueling())
                .findFirst()
                .orElseThrow()
                .start();
    }

    public void stopFuelingTransaction(FuelingTransaction fuelingTransaction) {
        if(fuelingTransaction != null) {
            double quantity = fuelingPositions.stream()
                    .filter(x -> x.getHoseID().equalsIgnoreCase(fuelingTransaction.getHoseID()))
                    .filter(FuelingPosition::isFueling)
                    .findFirst()
                    .orElseThrow()
                    .stop();
            fuelingTransaction.setQuantity(quantity);
            fuelingTransaction.close();
        } else {
            System.out.println("Select Hose is not currently fueling");
        }


    }

    public List<FuelingPosition> getHoses(){
        return fuelingPositions;
    }
    public void addFuelingPosition(FuelingPosition fuelingPosition) {
        fuelingPosition.setHoseNumber(fuelingPositions.size());
        fuelingPositions.add(fuelingPosition);
    }
    public static FuelingManager getFuelingManager(){
        if(fuelingManager == null){
            fuelingManager = new FuelingManager();
        }
        return fuelingManager;
    }
}

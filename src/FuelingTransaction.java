import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class FuelingTransaction {
    private final static AtomicInteger transactionNumber = new AtomicInteger(TransactionSearch.getLastTransactionNumber());
    private final String operatorID;
    private final String equipmentID;
    private final String hoseID;
    private double quantity;
    private LocalDateTime dateTime;

    private static final Set<FuelingTransaction> openTransactions = new HashSet<>();

    FuelingTransaction(String hoseID, String equipmentID, String operatorID) {
        this.hoseID = hoseID;
        this.equipmentID = equipmentID;
        this.operatorID = operatorID;
        openTransactions.add(this);
    }


    public FuelingTransaction setQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getHoseID() {
        return hoseID;
    }

    public double getQuantity() {
        return quantity;
    }

    AtomicInteger getTransactionNumber() {
        return transactionNumber;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public String getEquipmentID(){
        return equipmentID;
    }

    public void close() {
        transactionNumber.incrementAndGet();
        this.dateTime = LocalDateTime.now();
        openTransactions.remove(this);
        TransactionWriter.writeTransaction(this);
    }

    public static FuelingTransaction getOpenTransactionByHose(String hoseID){
        return openTransactions.stream()
                .filter(x->x.getHoseID().equalsIgnoreCase(hoseID))
                .findAny()
                .orElseThrow();
    }
}

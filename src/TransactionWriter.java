import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TransactionWriter {
    private static final File file = new File("Tranactions.xls");

    public static void writeTransaction(FuelingTransaction fuelingTransaction) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            Scanner scanner = new Scanner(file);
            if (!scanner.hasNext()) {
                fileWriter.write(getHeader());
            }
            fileWriter.append(getTransactionString(fuelingTransaction));
            fileWriter.close();
        } catch (IOException io) {
            System.out.println("IO Exception");
            throw new RuntimeException();
        }
    }

    public static String getTransactionString(FuelingTransaction fuelingTransaction) {
                return "\n" +
                fuelingTransaction.getTransactionNumber() +
                ", " +
                fuelingTransaction.getHoseID() +
                ", " +
                fuelingTransaction.getDateTime().getMonth().name() +
                ", " +
                fuelingTransaction.getDateTime().getDayOfMonth() +
                " " +
                fuelingTransaction.getDateTime().getYear() +
                ", " +
                fuelingTransaction.getDateTime().getHour() +
                ":" +
                fuelingTransaction.getDateTime().getMinute() +
                ":" +
                fuelingTransaction.getDateTime().getSecond() +
                ", " +
                fuelingTransaction.getOperatorID() +
                ", " +
                fuelingTransaction.getEquipmentID() +
                ", " +
                fuelingTransaction.getQuantity();
    }

    private static String getHeader() {
        return "Transaction Number,Date,Time,Operator ID,Equipment ID,Quantity";
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TransactionWriter {
    private static final File file = new File("Transactions.xls");
    //extract to contstants class

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
                "\t" +
                fuelingTransaction.getHoseID() +
                "\t" +
                fuelingTransaction.getDateTime().getMonth().name() +
                "," +
                fuelingTransaction.getDateTime().getDayOfMonth() +
                " " +
                fuelingTransaction.getDateTime().getYear() +
                "\t" +
                fuelingTransaction.getDateTime().getHour() +
                ":" +
                fuelingTransaction.getDateTime().getMinute() +
                ":" +
                fuelingTransaction.getDateTime().getSecond() +
                "\t" +
                fuelingTransaction.getOperatorID() +
                "\t" +
                fuelingTransaction.getEquipmentID() +
                "\t" +
                fuelingTransaction.getQuantity();
    }

    private static String getHeader() {
        return "Transaction Number\tHoseID\tDate\tTime\tOperator ID\tEquipment ID\tQuantity";
    }
}

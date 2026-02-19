import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OperatorWriter {
    static File file = new File("Operators.xls");

    public static void writeToFile(OperatorRecord operatorRecord) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            writeHeaderIfNone(fileWriter);
            if(OperatorRecordSearch.searchRecord("Operator ID", operatorRecord.getID())){
                System.out.println("Operator ID has already been used");
                return;
            }
            fileWriter.append(getOperatorString(operatorRecord));
            fileWriter.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File Doesn't Exist");
        } catch (IOException ex) {
            System.out.println("Cannot Write to file");
        }
    }

    private static void writeHeaderIfNone(FileWriter fileWriter) {
        try {
            Scanner scanner = new Scanner(file);
            if (!scanner.hasNext()) {
                fileWriter.write("Operator ID,First Name,Last Name");
            }
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getOperatorString(OperatorRecord operatorRecord){
        return ("\n" +
                operatorRecord.getID() +
                "," +
                operatorRecord.getFirstName() +
                "," +
                operatorRecord.getLastName());
    }
}

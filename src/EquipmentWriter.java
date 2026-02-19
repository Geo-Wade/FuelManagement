import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EquipmentWriter {
    static File file = new File("Equipment.xls");

    void writeToFile(EquipmentRecord equipmentRecord) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            writeHeaderIfNone(fileWriter);
            fileWriter.append(getEquipmentString(equipmentRecord));
            if(isIDReused(equipmentRecord.getID()))
            {
                return;
            }
            fileWriter.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File Doesn't Exist");
        } catch (IOException ex) {
            System.out.println("Cannot Write to file");
        }
    }

    private void writeHeaderIfNone(FileWriter fileWriter) {
        try {
            Scanner scanner = new Scanner(file);
            if (!scanner.hasNext()) {
                fileWriter.write("Equipment ID,Year,Make,Model,Odometer");
            }
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getEquipmentString(EquipmentRecord equipmentRecord) {
        return ("\n" +
                equipmentRecord.getID() +
                "," +
                equipmentRecord.getYear() +
                "," +
                equipmentRecord.getMake() +
                "," +
                equipmentRecord.getModel() +
                "," +
                equipmentRecord.getOdometer());
    }

    private boolean isIDReused(String ID) {
        if (EquipmentRecordSearch.searchRecord("Equipment ID", ID)) {
            System.out.println("ID has already been used");
            return true;
        }
        return false;
    }
}

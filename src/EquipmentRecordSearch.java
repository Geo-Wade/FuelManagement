import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EquipmentRecordSearch {
    private static final File file = new File("Equipment.xls");
    private static Scanner scanner;

    public static boolean searchRecord(String column,  String value){
        try {
            file.createNewFile();
            scanner = new Scanner(file);

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found " + file);
            throw new RuntimeException(e);
        }catch (IOException ex){
            System.out.println("Could not create " + file + "in" + "EquipmentRecordSearch");
        }
        int index =  findIndexOfColumn(column);
        if(index >= 0) {
            return includesRecord(value, index);
        }
        else{
            return false;
        }
    }

    private static int findIndexOfColumn(String column){
        if(scanner.hasNext()) {
            return Arrays.stream(scanner.nextLine().splitWithDelimiters(",", 0))
                    .map(String::toUpperCase)
                    .toList()
                    .indexOf(column.toUpperCase());
        }
        return -1;
    }

    private static boolean includesRecord(String value, int index){
        while(scanner.hasNext()){
            List<String> values = Arrays.asList(scanner.nextLine().splitWithDelimiters(",", 0));
            if(values.get(index).equalsIgnoreCase(value)){
                return true;
            }
        }
        return false;
    }
}

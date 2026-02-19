import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TransactionSearch {
    private static final File file = new File("Transactions.xls");
    public static int getLastTransactionNumber(){
        try {
            file.createNewFile();
            Scanner scanner = new Scanner(file);
            if(!scanner.hasNext()){
                return 0;
            }
            List<String> line = new ArrayList<>();
            while(scanner.hasNext()){
                line = Arrays.asList(scanner.nextLine().splitWithDelimiters("\t",0));
            }
            return asInt(line.getFirst());
        }catch (IOException ex){
            System.out.println("Could not open " + file + " in Transaction Search");
            throw new RuntimeException();
        }
    }

    private static int asInt(String s){
        try{
            return Integer.parseInt(s.trim());
        }catch (NumberFormatException ex){
            System.out.println("Non-integer found in transaction number column of " + file);
            throw new RuntimeException();
        }
    }
}

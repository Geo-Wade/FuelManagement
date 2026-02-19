import java.util.Optional;
import java.util.Scanner;

public class ConsoleIO {
    Scanner scanner = new Scanner(System.in);

    public String getStringInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    public int getIntInput(String prompt) {
        Optional<Integer> inpOptional = Optional.empty();
        while(inpOptional.isEmpty()) {
            System.out.println(prompt);
            inpOptional = getInt(scanner.nextLine().trim());
        }
        return inpOptional.orElseThrow();
    }

    private Optional<Integer> getInt(String input){
        try{
            return Optional.of(Integer.parseInt(input));
        }catch (NumberFormatException ne){
            return Optional.empty();
        }
    }
}

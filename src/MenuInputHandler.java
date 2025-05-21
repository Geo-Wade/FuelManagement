import java.util.Scanner;

public class MenuInputHandler {

    static Scanner scanner = new Scanner(System.in);
    public static String inputHandler() {
        return scanner.nextLine();
    }

    public static MenuSelectionEnum getMenuSelection() {
        String input = inputHandler();
        if (isInt(input)) {
            int iSelection = Integer.parseInt(input);
            return switch (iSelection) {
                case 1 -> MenuSelectionEnum.FIRST_OPTION_SELECTED;
                case 2 -> MenuSelectionEnum.SECOND_OPTION_SELECTED;
                case 3 -> MenuSelectionEnum.THIRD_OPTION_SELECTED;
                case 4 -> MenuSelectionEnum.FOURTH_OPTION_SELECTED;
                case 5 -> MenuSelectionEnum.FIFTH_OPTION_SELECTED;
                case 6 -> MenuSelectionEnum.SIXTH_OPTION_SELECTED;
                default -> MenuSelectionEnum.INVALID_SELECTION;
            };
        }
        return MenuSelectionEnum.INVALID_SELECTION;
    }


    public static String getInputString(){
        return inputHandler();
    }

    private static boolean isInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    static void inputClose(){
        scanner.close();
    }
}


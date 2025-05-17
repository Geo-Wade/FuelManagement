public class MenuHandler {

    public static MenuSelectionEnum handleSelection(String selection) {
        if (isInt(selection)) {
            int iSelection = Integer.parseInt(selection);
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

    public static boolean userSelectExit(String string, String escapeResponse) {
        return (!string.equals(escapeResponse));
    }

    private static boolean isInt(String string) {
        try {
            int x = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}


public class MenuOutputHandler {
    public static void entryPromptOutput(){
        System.out.println("""
                    What Action Would you like to perform
                    1 - Edit Record
                    2 - Begin Fueling - Not Implemented
                    3 - reset - Kills Program""");
    }
    public static void selectRecordOutput(){
        System.out.println("""
                    Which would you like to edit?
                    1 - Equipment
                    2 - Operator
                    3 - Product
                    4 - Tank
                    5 - Fueling Position - Not Implemented
                    6 - Exit
                    """);
    }
     public static void SelectRecordActionOutput(){
         System.out.println("""
                    What would you like to do to the record?
                    1 - Add
                    2 - Edit - Not Implemented
                    3 - Exit""");
     }

    public static void invalidSelection() {
        System.out.println("Please select a valid option from the menu");
    }

    public static void promptForField(String key){
        System.out.println("Please Enter a value for: " + key);
    }

}

public class FuelingAuthorizor {
    public boolean authorizeEquipment(ConsoleIO IO) {
        return authorizeOperator(IO.getStringInput("Please Enter Equipment ID"));
    }

    public boolean authorizeEquipment(String ID) {
        return EquipmentRecordSearch.searchRecord("Equipment ID", ID);
    }

    public boolean authorizeOperator(ConsoleIO IO) {
        return authorizeOperator(IO.getStringInput("Please Enter Equipment ID"));
    }

    public boolean authorizeOperator(String ID) {
        return OperatorRecordSearch.searchRecord("Operator ID", ID);
    }
}

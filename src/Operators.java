import java.util.HashSet;
import java.util.Optional;

public class Operators {
    private static HashSet<OperatorRecord> operators;

    private Operators(){}

    public static HashSet<OperatorRecord> getVehicles(){
        createIfNull();
        return operators;
    }
    public static boolean add(OperatorRecord operator) {
        createIfNull();
        if(operator.getRecordField().values().stream().noneMatch(Optional::isEmpty)){
            operators.add(operator);
            return true;
        }
        return false;
    }
    private static void createIfNull(){
        if(operators == null){
            operators = new HashSet<>();
        }
    }
}

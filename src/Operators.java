import java.util.HashSet;

public class Operators {
    private final static HashSet<OperatorRecord> operators = new HashSet<>();

    private Operators(){}

    public static HashSet<OperatorRecord> getOperators(){
        return operators;
    }
    public static boolean add(OperatorRecord operator) {
        if(!isDuplicate(operator)){
            operators.add(operator);
        }
        return true;
    }
    private static boolean isDuplicate(OperatorRecord operator){
        return operators.stream()
                .map(OperatorRecord::getOperatorID)
                .anyMatch(id -> id.equals(operator.getOperatorID()));
    }
}

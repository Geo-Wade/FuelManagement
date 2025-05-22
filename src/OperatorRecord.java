import java.util.Arrays;
import java.util.List;

public class OperatorRecord extends Record {
    private String operatorID;
    private String operatorFirstName;
    private String operatorLastName;
    final static String OPERATOR_ID_TOKEN = "Operator ID";
    final static String OPERATOR_FIRST_NAME_TOKEN = "Operator First Name";
    final static String OPERATOR_LAST_NAME_TOKEN = "Operator Last Name";

    @Override
    void assignRecord(String key, String field) {
        switch (key) {
            case OPERATOR_ID_TOKEN -> {
                operatorID = field;
            }
            case OPERATOR_FIRST_NAME_TOKEN -> {
                operatorFirstName = field;
            }
            case OPERATOR_LAST_NAME_TOKEN -> {
                operatorLastName = field;
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<String> getFieldTokens(){
        return Arrays.asList(
                OPERATOR_ID_TOKEN,
                OPERATOR_FIRST_NAME_TOKEN,
                OPERATOR_LAST_NAME_TOKEN
        );
    }

    public String getOperatorID() {
        return operatorID;
    }

    public String getOperatorFirstName() {
        return operatorFirstName;
    }

    public String getOperatorLastName() {
        return operatorLastName;
    }

    @Override
    public String toString() {
        return "Operator ID: " + getOperatorID()
                + "\n"
                + "Operator First Name: " + getOperatorFirstName()
                + "\n"
                + "Operator Last Name: " + getOperatorLastName()
                + "\n";
    }
}


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class OperatorRecord extends Record {
    private String operatorID;
    private String operatorFirstName;
    private String operatorLastName;
    final static String OPERATOR_ID_TOKEN = "Operator ID";
    final static String OPERATOR_FIRST_NAME_TOKEN = "Operator First Name";
    final static String OPERATOR_LAST_NAME_TOKEN = "Operator Last Name";

    public static long odomRestrictedDistance;

    public OperatorRecord() {
        recordFields = new LinkedHashMap<>();
        recordFields.put(OPERATOR_ID_TOKEN, Optional.empty());
        recordFields.put(OPERATOR_FIRST_NAME_TOKEN, Optional.empty());
        recordFields.put(OPERATOR_LAST_NAME_TOKEN, Optional.empty());
    }

    public Map<String, Optional<String>> initRecord() {
        return recordFields;
    }

    @Override
    boolean assignRecord() {
        for (String key : recordFields.keySet()) {
            switch (key) {
                case OPERATOR_ID_TOKEN:
                    operatorID = recordFields.get(key).orElse("No Data Recorded");
                    break;
                case OPERATOR_FIRST_NAME_TOKEN: {
                    operatorFirstName = recordFields.get(key).orElse("No Data Recorded");
                    break;
                }
                case OPERATOR_LAST_NAME_TOKEN: {
                    operatorLastName = recordFields.get(key).orElse("No Data Recorded");
                    break;
                }
                default:
                    System.out.println("Invalid Data Provided To Record: " + key);
                    break;
            }
        }
        return recordFields.values().stream().filter(Optional::isEmpty).toList().isEmpty();
    }

    public Boolean setNewOdometer() {
        return false;
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
};


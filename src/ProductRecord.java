import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class ProductRecord extends Record {
    private String productID;
    private int reorderLimit;
    private float price;
    final static String PRODUCT_ID_TOKEN = "Product ID";
    final static String REORDER_LIMIT_TOKEN = "Reorder Limit";
    final static String PRICE_TOKEN = "Price";

    public ProductRecord() {
        recordFields = new LinkedHashMap<>();
        recordFields.put(PRODUCT_ID_TOKEN, Optional.empty());
        recordFields.put(REORDER_LIMIT_TOKEN, Optional.empty());
        recordFields.put(PRICE_TOKEN, Optional.empty());
    }

    public Map<String, Optional<String>> initRecord() {
        return recordFields;
    }

    @Override
    boolean assignRecord() {
        for (String key : recordFields.keySet()) {
            switch (key) {
                case PRODUCT_ID_TOKEN:
                    productID = recordFields.get(key).orElse("No Data Recorded");
                    break;
                case REORDER_LIMIT_TOKEN: {
                    if(isInt(recordFields.get(key).orElse("Not an int"))) {
                        reorderLimit = Integer.parseInt(recordFields.get(key).orElse("No Data Recorded"));
                    }
                    break;
                }
                case PRICE_TOKEN: {
                    if(isFloat(recordFields.get(key).orElse("not a float"))) {
                        price = Float.parseFloat(recordFields.get(key).orElse("No Data Recorded"));
                    }
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

    public String getProductID() {
        return productID;
    }

    public int getReorderLimit() {
        return reorderLimit;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Operator ID: " + getProductID()
                + "\n"
                + "Operator First Name: " + getReorderLimit()
                + "\n"
                + "Operator Last Name: " + getPrice()
                + "\n";
    }
    private static boolean isInt(String string){
        try{
            float x = Integer.parseInt(string);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    private static boolean isFloat(String string){
        try{
            float x = Float.parseFloat(string);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}

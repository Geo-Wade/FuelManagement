import java.util.*;

public class ProductRecord extends Record {
    private String productID;
    private int reorderLimit;
    private float price;
    final static String PRODUCT_ID_TOKEN = "Product ID";
    final static String REORDER_LIMIT_TOKEN = "Reorder Limit";
    final static String PRICE_TOKEN = "Price";

    @Override
    void assignRecord(String key, String field) {
        switch (key){
            case PRODUCT_ID_TOKEN -> {
                productID = field;
            }
            case REORDER_LIMIT_TOKEN -> {
                reorderLimit = Integer.parseInt(field);
            }
            case PRICE_TOKEN -> {
                price = Float.parseFloat(field);
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<String> getFieldTokens(){
        return Arrays.asList(
                PRODUCT_ID_TOKEN,
                REORDER_LIMIT_TOKEN,
                PRICE_TOKEN
        );
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
            Integer.parseInt(string);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    private static boolean isFloat(String string){
        try{
            Float.parseFloat(string);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}

import java.util.HashSet;

public class Products {
    private final static HashSet<ProductRecord> products = new HashSet<>();

    private Products(){}

    public static HashSet<ProductRecord> getProducts(){
        return products;
    }
    public static boolean add(ProductRecord product) {
        if(!isDuplicate(product)){
            products.add(product);
            return true;
        }
        return false;
    }
    public static boolean isDuplicate(ProductRecord product){
        return products.stream()
                .map(ProductRecord::getProductID)
                .anyMatch(id ->id.equals(product.getProductID()));
    }
}

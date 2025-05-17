import java.util.HashSet;
import java.util.Optional;

public class Products {
    private static HashSet<ProductRecord> products;

    private Products(){}

    public static HashSet<ProductRecord> getVehicles(){
        createIfNull();
        return products;
    }
    public static boolean add(ProductRecord product) {
        createIfNull();
        if(product.getRecordField().values().stream().noneMatch(Optional::isEmpty)){
            products.add(product);
            return true;
        }
        return false;
    }
    private static void createIfNull(){
        if(products == null){
            products = new HashSet<>();
        }
    }
}

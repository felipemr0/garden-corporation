package data;

import code.Helper;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAO<Product> {

    private ArrayList<Product> productList = new ArrayList<>();;
    
    public ProductDAO() {
        productList = Helper.readObj(Product.ENTITY_PATH, productList);
    }
    
    @Override
    public void add(Product product) {
        productList.add(product);
        Helper.saveObj(Product.ENTITY_PATH, productList);
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }    
}

package data;

import code.Helper;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO implements DAO<Sale> {
    
    private ArrayList<Sale> saleList = new ArrayList<>();;
    
    public SaleDAO() {
        saleList = Helper.readObj(Sale.ENTITY_PATH, saleList);
    }
    
    @Override
    public void add(Sale customer) {
        saleList.add(customer);
        Helper.saveObj(Sale.ENTITY_PATH, saleList);
    }

    @Override
    public List<Sale> getAll() {
        return saleList;
    }
    
}

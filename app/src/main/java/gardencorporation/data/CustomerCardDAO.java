package data;

import code.Helper;
import java.util.ArrayList;
import java.util.List;

public class CustomerCardDAO implements DAO<CustomerCard> {
    
    private ArrayList<CustomerCard> customerCardList = new ArrayList<>();
    
    public CustomerCardDAO() {
        customerCardList = Helper.readObj(CustomerCard.ENTITY_PATH, customerCardList);
    }

    @Override
    public void add(CustomerCard customerCard) {
        customerCardList.add(customerCard);
        Helper.saveObj(CustomerCard.ENTITY_PATH, customerCardList);
    }

    @Override
    public List<CustomerCard> getAll() {
        return customerCardList;
    }
    
}

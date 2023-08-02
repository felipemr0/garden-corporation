package org.gardencorporation;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAO<Customer> {
    
    private ArrayList<Customer> customerList = new ArrayList<>();;
    
    public CustomerDAO() {
        customerList = Helper.readObj(Customer.ENTITY_PATH, customerList);
    }
    
    @Override
    public void add(Customer customer) {
        customerList.add(customer);
        Helper.saveObj(Customer.ENTITY_PATH, customerList);
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }
    
}

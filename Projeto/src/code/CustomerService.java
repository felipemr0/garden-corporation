package code;

import data.Customer;
import data.CustomerCard;
import data.CustomerCardDAO;
import data.CustomerDAO;

public class CustomerService {
    
    private final CustomerDAO customerDAO;
    private final CustomerCardDAO customerCardDAO;

    public CustomerService() {
        customerDAO = new CustomerDAO();
        customerCardDAO = new CustomerCardDAO();
    }

    public void addCustomer(Customer customer, boolean addCard) {
        customerDAO.add(customer);
        if (addCard) {
            customerCardDAO.add(new CustomerCard(customer));
        }
    }

}

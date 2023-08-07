package org.gardencorporation;

import org.gardencorporation.entities.Customer;
import org.gardencorporation.entities.CustomerCard;

public class CustomerService {

    private final DAO customerDAO;

    public CustomerService() {
        customerDAO = new DAO<Customer>();
    }

    public void addCustomer(String name, String phoneNumber, boolean addCard) {
        Customer customer = new Customer(name, phoneNumber);
        customerDAO.create(customer);
        if (addCard) {
            customerDAO.create(new CustomerCard(customer));
        }
    }

    public void addPointsFromOfferCheck(double value, CustomerCard customerCard) {
        customerCard.addPoints(SaleService.pointsCalculation(value));
        customerDAO.update(customerCard);
    }
}

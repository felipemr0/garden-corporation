package data;

import data.Customer;
import java.io.Serializable;
import java.util.Random;

public class CustomerCard implements Serializable {

    private int points;
    private final int ID;
    private Customer customer;

    public static final String ENTITY_PATH = "customerCard.obj";

    public CustomerCard(Customer _customer) {
        customer = _customer;
        points = 0;
        ID = new Random().nextInt(1000);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addPoints(int _points) {
        points += _points;
    }

    public void removePoints(int _points) {
        points = (points - _points <= 0) ? 0 : points - _points;
    }

    public int getPoints() {
        return points;
    }

    public int getID() {
        return ID;
    }
    
    @Override
    public String toString() {
        return customer.getName() + " : " + customer.getPhoneNumber();
    }
}

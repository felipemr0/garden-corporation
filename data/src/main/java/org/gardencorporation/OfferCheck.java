package org.gardencorporation;

import java.io.Serializable;
import java.util.Random;

public class OfferCheck implements Serializable {

    private int ID;
    private final double initialValue;
    private double currentValue;
    private CustomerCard customerOwner;
    private Customer customer;

    public static final String ENTITY_PATH = "offerCheck.obj";

    public OfferCheck(CustomerCard _customerOwner, Customer _customer, double _value) {
        ID = new Random().nextInt(1000);
        initialValue = _value;
        currentValue = _value;
        customerOwner = _customerOwner;
        customer = _customer;
    }

    public CustomerCard getOwner() {
        return customerOwner;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getID() {
        return ID;
    }

    public double getValue() {
        return currentValue;
    }

    public void setValue(double _currentValue) {
        currentValue = _currentValue;
    }

    public double getInitialValue() {
        return initialValue;
    }
    
    @Override
    public String toString() {
        return "From: " + customerOwner + " ; Value : " + currentValue;
    }
}

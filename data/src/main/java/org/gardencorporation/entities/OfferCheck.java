package org.gardencorporation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.sql.Date;

@Entity
public class OfferCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private CustomerCard owner;
    @ManyToOne
    private Customer customer;
    private double initialValue;
    private double currentValue;
    private Date createdAt;

    public OfferCheck() {

    }

    public OfferCheck(CustomerCard _customerOwner, Customer _customer, double _value) {
        initialValue = _value;
        currentValue = _value;
        owner = _customerOwner;
        customer = _customer;
        createdAt = new Date(System.currentTimeMillis());
    }

    public CustomerCard getOwner() {
        return owner;
    }

    public Customer getCustomer() {
        return customer;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}

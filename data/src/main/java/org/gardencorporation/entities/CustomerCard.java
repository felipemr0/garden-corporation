package org.gardencorporation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class CustomerCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Customer customer;
    private int points;
    private Date createdAt;

    public CustomerCard() {
        points = 0;
    }

    public CustomerCard(Customer customer) {
        this.customer = customer;
        points = 0;
        createdAt = new Date(System.currentTimeMillis());
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public void setPoints(int points) {
        this.points = points;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return customer.getName();
    }
}

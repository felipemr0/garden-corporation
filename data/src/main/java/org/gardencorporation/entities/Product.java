package org.gardencorporation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private double price;
    private int stock;
    private Date createdAt;

    public Product() {

    }

    public Product(String _name, double _price) {
        name = _name;
        price = _price;
        stock = 0;
        createdAt = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double _price) {
        price = _price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int _stock) {
        stock = _stock;
    }

    public void addStock(int _stock) {
        stock += _stock;
    }

    public void removeStock(int _stock) {
        stock = (stock - _stock >= 0) ? stock - _stock : 0;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}

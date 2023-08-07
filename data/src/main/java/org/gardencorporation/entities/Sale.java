package org.gardencorporation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.sql.Date;
import java.util.Set;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    @OneToMany(mappedBy = "sale")
    private Set<ProductSale> productSet;
    @ManyToOne
    private Customer customer;
    private Date createdAt;

    public Sale() {

    }

    public Sale(Customer _customer) {
        customer = _customer;
    }

    public Set<ProductSale> getProductSet() {
        return productSet;
    }

    public void addToProductSet(Product product, int quantity) {
        productSet.add(new ProductSale(product, this, quantity));
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
}

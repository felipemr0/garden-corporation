package org.gardencorporation.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class ProductSale {

    @EmbeddedId
    ProductSaleKey id;
    @ManyToOne
    @MapsId("id")
    Product product;
    @ManyToOne
    @MapsId("id")
    Sale sale;
    int quantity;

    public ProductSale() {

    }

    public ProductSale(Product product, Sale sale, int quantity) {
        this.product = product;
        this.sale = sale;
        this.quantity = quantity;
    }

    // standard constructors, getters, and setters
    public ProductSaleKey getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

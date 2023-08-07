package org.gardencorporation.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class ProductSaleKey implements Serializable {

    int saleId;
    int productId;

    public ProductSaleKey() {

    }

    public ProductSaleKey(int saleId, int productId) {
        this.saleId = saleId;
        this.productId = productId;
    }

    // standard constructors, getters, and setters
    // hashcode and equals implementation
    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.saleId;
        hash = 23 * hash + this.productId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductSaleKey other = (ProductSaleKey) obj;
        if (this.saleId != other.saleId) {
            return false;
        }
        return this.productId == other.productId;
    }

}

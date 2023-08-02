package org.gardencorporation;

import java.io.Serializable;

public class Sale implements Serializable {

    private static double valueToDiscount = 0.25;
    private static double maxValueDiscounted = 4;
    
    private int quantity;
    private double totalAmountToPay;
    private final Product product;
    private Customer customer;

    public static final String ENTITY_PATH = "sale.obj";

    public Sale(Product _product, int _quantity) {
        quantity = _quantity;
        totalAmountToPay = _product.getPrice() * _quantity;
        product = _product;
    }

    public Sale(Customer _customer, Product _product, int _quantity, double _totalAmountToPay) {
        quantity = _quantity;
        totalAmountToPay = _totalAmountToPay;
        product = _product;

        customer = _customer;
    }

    public Product getProduct() {
        return product;
    }

    public double getMaxValue() {
        return maxValueDiscounted;
    }

    public double getAmount() {
        return this.totalAmountToPay;
    }

    public void setAmount(double value) {
        this.totalAmountToPay = value;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int _quantity) {
        quantity = _quantity;
    }

    public static int pointsCalculation(double value) {
        int pts = 0;
        boolean b = true;
        if (value > 10) {
            while (b) {
                value = value - 10;
                if (value > 0 || value == 0) {
                    ++pts;
                } else {
                    b = false;
                }
            }
        }
        return pts;
    }
    
    public static double getDiscountedValue(double amount, int points) {
        for (int i = 1; i <= points ;i++) {
            if (amount == maxValueDiscounted) {
                break;
            }
            amount = amount - valueToDiscount;
        }
        
        return amount;
    }
}

package data;

import java.io.Serializable;
import java.util.Random;

public class Product implements Serializable {

    private final int ID;
    private String name;
    private double price;
    private int stock;

    public static final String ENTITY_PATH = "product.obj";

    public Product(String _name, double _price) {
        name = _name;
        price = _price;
        ID = new Random().nextInt(1000);
        stock = 0;
    }

    public int getID() {
        return ID;
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
    
    @Override
    public String toString() {
        return name + " - " + price + "€";
    }
}

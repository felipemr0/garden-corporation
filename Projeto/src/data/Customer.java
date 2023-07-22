package data;

import java.io.Serializable;
import java.util.Random;

public class Customer implements Serializable {

    private final int ID;
    private String name;
    private String phoneNumber;

    public static final String ENTITY_PATH = "customer.obj";

    public Customer(String _name, String _phoneNumber) {
        name = _name;
        ID = new Random().nextInt(1000);
        phoneNumber = _phoneNumber;
    }

    public int getID() {
        return ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String _phoneNumber) {
        phoneNumber = _phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }
    
    @Override
    public String toString() {
        return name + " : " + phoneNumber;
    }
    
}

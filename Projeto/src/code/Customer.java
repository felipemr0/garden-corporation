package code;

public class Customer implements java.io.Serializable {

    private String name;
    private String number;
    private String phoneNumber;
    private double expenses;

    public Customer(String name, String number, String phoneNumber) {
        this.name = name;
        this.number = number;
        this.phoneNumber = phoneNumber;
        this.expenses = 0;
    }

    public void setExpenses(double expenses) {
        this.expenses = this.expenses + expenses;
    }

    public double getExpenses() {
        return expenses;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getCustomerName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

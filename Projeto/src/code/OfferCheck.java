package code;

public class OfferCheck implements java.io.Serializable {

    private String id;
    private double value;
    private String customerNumber;
    private String name;
    private String customerNumber2;
    private String ownerNumber;
    private String buyerNumber;
    private String ownerName;
    private double expenses;

    public OfferCheck(Customer customer, Customer customer2, Customer customerOwner, String id, double value) {
        this.id = id;
        this.value = value;
        this.customerNumber = customer.getNumber();
        this.customerNumber2 = customer2.getNumber();
        this.ownerNumber = customerOwner.getNumber();
        this.buyerNumber = customer.getCustomerName();
        this.ownerName = customer2.getCustomerName();
        this.expenses = customer.getExpenses();
    }

    public double getExpenses() {
        return this.expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses + this.expenses;
    }

    public String getBuyerNumber() {
        return buyerNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public void setCustomerNumber2(String customerNumber2) {
        this.customerNumber2 = customerNumber2;
    }

    public String getCustomerNumber2() {
        return customerNumber2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(double value) {
        this.value = value;
    }

}

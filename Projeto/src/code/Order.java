package code;

public class Order implements java.io.Serializable {

    private String name;
    private String number;
    private String idProd;
    private String information;
    private int quantity;
    private Customer customer;
    private Product product;
    private boolean reserved;
    private String productName;
    private double amount;
    private double expenses;

    public Order(Customer customer, Product product, int quantity) {
        this.name = customer.getCustomerName();
        this.number = customer.getNumber();
        this.idProd = product.getIdProd();
        this.information = "";
        this.quantity = quantity;
        this.reserved = product.getReserved();
        this.productName = product.getProductName();
        this.amount = product.getPrice() * this.quantity;
    }

    public void setQuant(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getQuant() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getIdProd() {
        return idProd;
    }

    public String getInformation() {
        return information;
    }
}

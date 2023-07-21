package code;

public class Sale implements java.io.Serializable {

    private String name;
    private String number;
    private String idProd;
    private int quantity;
    private Product product;
    private Customer customer;
    private double price;
    private boolean reserved;
    private CustomerCard customerCard;
    private int points;
    private String cardNumber;
    private double valueToDiscount;
    private double totalAmountToPay;
    private double maxValueDiscounted;
    private String productName;
    private double expenses;
    private String checkId;
    private double checkValue;

    public Sale(Customer customer, Product product, int quantity) {
        this.name = customer.getCustomerName();
        this.number = customer.getNumber();
        this.idProd = product.getIdProd();
        this.quantity = quantity;
        this.price = product.getPrice();
        this.reserved = product.getReserved();
        this.totalAmountToPay = product.getPrice() * quantity;
        this.productName = product.getProductName();
        this.expenses = customer.getExpenses();
    }

    public Sale(Product product, int quantity) {
        this.idProd = product.getIdProd();
        this.quantity = quantity;
        this.price = product.getPrice();
        this.reserved = product.getReserved();
        this.totalAmountToPay = product.getPrice() * quantity;
        this.productName = product.getProductName();
    }

    public Sale(CustomerCard customerCard, Product product, int quantity) {
        this.name = customerCard.getNom();
        this.number = customerCard.getNum();
        this.idProd = product.getIdProd();
        this.price = product.getPrice();
        this.reserved = product.getReserved();
        this.quantity = quantity;
        this.points = customerCard.getPoints();
        this.cardNumber = customerCard.getCardNumber();
        this.valueToDiscount = 1;
        this.totalAmountToPay = product.getPrice() * this.quantity;
        this.maxValueDiscounted = 10;
        this.productName = product.getProductName();
        this.expenses = customerCard.getExpenses();
    }

    public Sale(OfferCheck check, Product product, int quantity) {
        this.idProd = product.getIdProd();
        this.checkId = check.getId();
        this.productName = product.getProductName();
        this.number = check.getOwnerNumber();
        this.quantity = quantity;
        this.reserved = product.getReserved();
        this.price = product.getPrice();
        this.checkValue = check.getValue();
    }

    public String getCheckId() {
        return checkId;
    }

    public double getCheckValue() {
        return this.checkValue;
    }

    public boolean isReserved() {
        return this.reserved;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses + this.expenses;
    }

    public double getExpenses() {
        return this.expenses;
    }

    public String getProductName() {
        return this.productName;
    }

    public double getMaxValue() {
        return this.maxValueDiscounted;
    }

    public void setMaxValue(double newValue) {
        this.maxValueDiscounted = newValue;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    public double getAmount() {
        return this.totalAmountToPay;
    }

    public void setAmount(double value) {
        this.totalAmountToPay = value;
    }

    public String getName() {
        return name;
    }

    public void setCustomerName(String nome) {
        this.name = nome;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setValueToDiscount(double val) {
        this.valueToDiscount = val;
    }

    public double getValueToDiscount() {
        return this.valueToDiscount;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public int getPoints() {
        return this.points;
    }

    public int pointsCalculation(double value) {
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

    public void setPoints(int p) {
        this.points = p;
    }
}

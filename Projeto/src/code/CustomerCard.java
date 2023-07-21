package code;

public class CustomerCard implements java.io.Serializable {

    private int points;
    private String cardNumber;
    private String name;
    private String number;
    private double expenses;

    public CustomerCard(Customer customer, String cardNumber) {
        this.name = customer.getCustomerName();
        this.number = customer.getNumber();
        this.points = 0;
        this.cardNumber = cardNumber;
        this.expenses = customer.getExpenses();
    }

    public double getExpenses() {
        return this.expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = this.expenses + expenses;
    }

    public void setPoints(int p) {
        this.points = p;
    }

    public int getPoints() {
        return this.points;
    }

    public String getNum() {
        return this.number;
    }

    public String getNom() {
        return this.name;
    }

    public String getCardNumber() {
        return this.cardNumber;
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

    public boolean checkCard(String number) {
        boolean b = false;
        if (this.cardNumber.equals(number)) {
            b = true;
        }
        return b;
    }
}

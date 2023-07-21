package code;

public class Product implements java.io.Serializable {

    private String pName;
    private double price;
    private String idProd;
    private int prodQuantity;
    private boolean reserved;

    public Product(String pName, double price, String idprod) {
        this.reserved = false;
        this.pName = pName;
        this.price = price;
        this.idProd = idprod;
        this.prodQuantity = 0;
    }

    public boolean getReserved() {
        return this.reserved;
    }

    public void setReserved(boolean r) {
        this.reserved = r;
    }

    public int getQuant() {
        return this.prodQuantity;
    }

    public String getProductName() {
        return pName;
    }

    public double getPrice() {
        return price;
    }

    public String getIdProd() {
        return idProd;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuant(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    @Override
    public String toString() {
        return "Product{" + "pName=" + pName + ", price=" + price + ", idProd=" + idProd + ", prodQuantity=" + prodQuantity + ", reserved=" + reserved + '}';
    }

}

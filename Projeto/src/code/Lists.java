package code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Lists implements java.io.Serializable {

    public ArrayList<Product> productList;
    public ArrayList<Sale> saleList;
    public ArrayList<Order> orderList;
    public ArrayList<CustomerCard> cardList;
    public ArrayList<Customer> customerList;
    public ArrayList<OfferCheck> offerCheckList;

    public Lists() {
        offerCheckList = new ArrayList<>();
        customerList = new ArrayList<>();
        productList = new ArrayList<>();
        saleList = new ArrayList<>();
        orderList = new ArrayList<>();
        cardList = new ArrayList<>();
    }

    public void regCheck(OfferCheck offerCheck) {
        for (OfferCheck c : offerCheckList) {
            if (c.getId().equals(offerCheck.getId())) {
                offerCheckList.add(offerCheck);
            } else {

            }
        }
        offerCheckList.add(offerCheck);
    }

    public void regCustomer(Customer customer) {
        if (checkCustomerId(customer.getNumber())) {
            for (Customer cliente : customerList) {
                if (cliente.getNumber().equals(customer.getNumber())) {

                }
            }
        } else {
            customerList.add(customer);
        }
    }

    public void regSaleCheck(Sale sale) {
        if (!(sale.getCheckId().isEmpty())) {
            if (checkStockForProd(sale.getIdProd(), sale.getQuantity())) {
                if (!(sale.isReserved())) {
                    for (OfferCheck cheque : offerCheckList) {
                        if (sale.getCheckId().equals(cheque.getId())) {
                            if (sale.getCheckValue() >= sale.getPrice()) {
                                saleList.add(sale);
                                removeQuant(sale.getQuantity(), sale.getIdProd());
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean checkCustomerId(String id) {
        boolean b = false;
        for (Customer cliente : customerList) {
            if (cliente.getNumber().equals(id)) {
                b = true;
            }
        }
        return b;
    }

    public boolean checkCardId(String id) {
        boolean b = false;
        for (CustomerCard cc : cardList) {
            if (cc.getCardNumber().equals(id)) {
                b = true;
            }
        }
        return b;
    }

    public void regCard(CustomerCard customerCard) {
        if (checkCardId(customerCard.getCardNumber())) {
            for (CustomerCard dd : cardList) {
                if (dd.getCardNumber().equals(customerCard.getCardNumber())) {

                }
            }
        } else {
            cardList.add(customerCard);
        }
    }

    /**
     * This method registers a sale, only registers if the product exists,
     * quantity of stock available and not reserved. If sale by card, increment
     * points and updates stock. If the object sale doesn't receive cardNumber,
     * register it
     */
    public void regSale(Sale sale) {
        if (checkId(sale.getIdProd()) && checkStockForProd(sale.getIdProd(), sale.getQuantity())) {
            if (!(isReserved(sale.getIdProd()))) {
                try {
                    if (!(sale.getCardNumber().isEmpty())) {
                        double preco = sale.getPrice();
                        double montante = preco * sale.getQuantity();
                        int pontosganhos = sale.pointsCalculation(montante);
                        for (CustomerCard c : cardList) {
                            String ncard = c.getCardNumber();
                            if (ncard.equals(sale.getCardNumber())) {
                                c.setPoints(pontosganhos + c.getPoints());
                                saleList.add(sale);
                                removeQuant(sale.getQuantity(), sale.getIdProd());
                            }
                        }
                    } else {
                        saleList.add(sale);
                        removeQuant(sale.getQuantity(), sale.getIdProd());
                    }
                } catch (Exception e) {
                    saleList.add(sale);
                    removeQuant(sale.getQuantity(), sale.getIdProd());
                }
            }
        }
    }

    public void regSaleWithDiscount(Sale sale) {
        if (checkId(sale.getIdProd()) && checkStockForProd(sale.getIdProd(), sale.getQuantity())) {
            if (sale.getPoints() > 0) {
                if (!(isReserved(sale.getIdProd()))) {
                    if (!(sale.getCardNumber().isEmpty())) {
                        String number = sale.getCardNumber();
                        for (CustomerCard c : cardList) {
                            if (number.equals(c.getCardNumber())) {
                                double novovalor = (newPriceCalculation(sale.getValueToDiscount(), sale.getPrice(), sale.getPoints(), sale.getMaxValue()));
                                c.setPoints(c.getPoints() - pointsToDiscount);
                                sale.setAmount(novovalor * sale.getQuantity());
                                int pontosganhos = sale.pointsCalculation(novovalor * sale.getQuantity());
                                c.setPoints(pontosganhos + c.getPoints());
                                saleList.add(sale);
                                removeQuant(sale.getQuantity(), sale.getIdProd());
                            }
                        }
                    }
                }
            }
        }
    }

    public void regSaleWithCheck(Sale sale) {
        if (checkId(sale.getIdProd()) && checkStockForProd(sale.getIdProd(), sale.getQuantity())) {
            if (!(isReserved(sale.getIdProd()))) {

            }
        }
    }

    int pointsToDiscount;

    /**
     * This method allows to calculate a new value in which it will represent
     * the new discounted value by the points
     */
    public double newPriceCalculation(double valueToDiscount, double price, int points, double maxValue) {
        pointsToDiscount = 0;
        boolean flag = false;
        if (price <= maxValue) {
            flag = true;
        }
        while (!flag) {
            price = price - valueToDiscount;
            ++pointsToDiscount;
            --points;
            if (price == maxValue) {
                flag = true;
            }
            if (points == 0) {
                flag = true;
            }
        }
        return price;
    }

    public boolean checkId(String idprod) {
        boolean b = false;
        for (Product c : productList) {
            if (c.getIdProd().equals(idprod)) {
                b = true;
            }
        }
        return b;
    }

    public boolean checkStockForProd(String id, int quantity) {
        boolean b = false;
        for (Product c : productList) {
            String i = c.getIdProd();
            if (id.equals(i)) {
                int qq = c.getQuant();
                if (qq > quantity || qq == quantity) {
                    b = true;
                }
            }
        }
        return b;
    }

    public void regProd(Product x) {
        updateQuantity_lenc(x.getIdProd());
        if (checkId(x.getIdProd()) == true) {
            for (Product c : productList) {
                if (x.getIdProd().equals(c.getIdProd())) {

                }
            }
        } else {
            productList.add(x);
        }
    }

    public void regQuantity(String id, int quantity) {
        updateQuantity_lenc(id);
        for (Product c : productList) {
            if (id.equals(c.getIdProd())) {
                if (!(c.getReserved())) {
                    c.setQuant((quantity + c.getQuant()) - order);
                    updateQuantity_lenc(id);
                } else {

                    order = order - quantity;
                    updateQuantity_lenc(id);
                }
            }
        }
    }

    public void updateQuantity_lenc(String id) {
        for (Product c : productList) {
            if (id.equals(c.getIdProd())) {
                boolean f = checkStockForProd(c.getIdProd(), c.getQuant());
                if (f == true) {
                    for (Order d : orderList) {
                        String idProd = d.getIdProd();
                        if (idProd.equals(c.getIdProd())) {
                            d.setInformation("Available");
                            c.setReserved(false);
                        } else {
                            d.setQuant(order);
                            d.setInformation("Unavailable");
                            c.setReserved(true);
                        }
                    }
                }
            }
        }
    }

    int quantity;

    public int getQuantity(String id) {
        for (Product c : productList) {
            if (id.equals(c.getIdProd())) {
                quantity = c.getQuant();
            }
        }
        return quantity;
    }

    public void removeQuant(int quantity, String idprod) {
        for (Product c : productList) {
            String id = c.getIdProd();
            if (id.equals(idprod)) {
                int i = c.getQuant();
                int ii = i - quantity;
                if (ii > 0 || i == 0) {
                    c.setQuant(ii);
                } else {
                    ii = 0;
                    c.setQuant(ii);
                }
            }
        }
    }

    int order;

    public void regOrder(Order x) {
        if (checkId(x.getIdProd())) {
            if (checkStockForProd(x.getIdProd(), x.getQuant())) {
                orderList.add(x);
                x.setInformation("Available");
                removeQuant(x.getQuant(), x.getIdProd());
            } else {
                order = x.getQuant() - getQuantity(x.getIdProd());
                setReserved(x.getIdProd());
                x.setInformation("Unavailable");
                orderList.add(x);
                removeQuant(x.getQuant(), x.getIdProd());
            }
        }
    }

    public boolean isReserved(String id) {
        boolean b = false;
        for (Product p : productList) {
            String idprod = p.getIdProd();
            if (idprod.equals(id)) {
                b = p.getReserved();
            }
        }
        return b;
    }

    public void setReserved(String id) {
        for (Product p : productList) {
            String idprod = p.getIdProd();
            if (idprod.equals(id)) {
                p.setReserved(true);
            }
        }
    }

    public ArrayList<Order> getOrderList() {
        return this.orderList;
    }

    public ArrayList<Sale> getSaleList() {
        return this.saleList;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public ArrayList<Customer> getCustomerList() {
        return this.customerList;
    }

    public ArrayList<CustomerCard> getCardList() {
        return this.cardList;
    }

    public ArrayList<OfferCheck> getOfferCheckList() {
        return this.offerCheckList;
    }

    public void saveData(String fich) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public System loadData(System system) throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.obj"));
            system = (System) ois.readObject();
            ois.close();
        } catch (IOException e) {
        } catch (ClassNotFoundException ec) {
        };

        return system;
    }
}

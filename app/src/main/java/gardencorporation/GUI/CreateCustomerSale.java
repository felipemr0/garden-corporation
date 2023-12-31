package GUI;

import data.Customer;
import data.CustomerCard;
import data.CustomerCardDAO;
import data.CustomerDAO;
import data.OfferCheck;
import data.OfferCheckDAO;
import data.Product;
import data.ProductDAO;
import data.Sale;
import data.SaleDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class CreateCustomerSale extends javax.swing.JFrame {
    
    private List<Customer> customerList;
    private List<CustomerCard> customerCardList;
    private List<Product> productList;
    private List<OfferCheck> offerCheckList;
    private SaleDAO saleDAO;
    private static final String SUCCESS_MSG = "Sale created successfully";
    
    public CreateCustomerSale() {
        super("Sale - Create");
        customerList = new CustomerDAO().getAll();
        customerCardList = new CustomerCardDAO().getAll();
        productList = new ProductDAO().getAll();
        offerCheckList = new OfferCheckDAO().getAll();
        saleDAO = new SaleDAO();
        initComponents();
        load();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        quantityTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        customerJList = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        productJList = new javax.swing.JList<>();
        offerCheckPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        offerCheckJList = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        amountTextField = new javax.swing.JTextField();
        pointsPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        pointsTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pointsRadioBtn = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        totalAmountToPay = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        quantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextFieldActionPerformed(evt);
            }
        });

        jLabel9.setText("Quantity");

        jButton5.setText("Create");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("Leave");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Customer");

        customerJList.setModel(new javax.swing.AbstractListModel<Customer>() {
            public int getSize() { return customerList.size(); }
            public Customer getElementAt(int i) { return customerList.get(i); }
        });
        customerJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        customerJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                customerJListValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(customerJList);

        jLabel11.setText("Product");

        productJList.setModel(new javax.swing.AbstractListModel<Product>() {
            public int getSize() { return productList.size(); }
            public Product getElementAt(int i) { return productList.get(i); }
        });
        productJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productJListValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(productJList);

        jLabel12.setText("OfferCheck");

        offerCheckJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        offerCheckJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                offerCheckJListValueChanged(evt);
            }
        });
        jScrollPane9.setViewportView(offerCheckJList);

        javax.swing.GroupLayout offerCheckPanel2Layout = new javax.swing.GroupLayout(offerCheckPanel2);
        offerCheckPanel2.setLayout(offerCheckPanel2Layout);
        offerCheckPanel2Layout.setHorizontalGroup(
            offerCheckPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, offerCheckPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );
        offerCheckPanel2Layout.setVerticalGroup(
            offerCheckPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, offerCheckPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(offerCheckPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
        );

        jLabel13.setText("Amount");

        amountTextField.setEditable(false);

        jLabel14.setText("Points");

        pointsTextField.setEditable(false);
        pointsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointsTextFieldActionPerformed(evt);
            }
        });

        jLabel15.setText("Use");

        pointsRadioBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pointsRadioBtnItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pointsPanelLayout = new javax.swing.GroupLayout(pointsPanel);
        pointsPanel.setLayout(pointsPanelLayout);
        pointsPanelLayout.setHorizontalGroup(
            pointsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pointsPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pointsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(7, 7, 7)
                .addComponent(pointsRadioBtn)
                .addContainerGap())
        );
        pointsPanelLayout.setVerticalGroup(
            pointsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pointsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pointsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pointsRadioBtn)
                    .addGroup(pointsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(pointsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addContainerGap())
        );

        jLabel16.setText("Amount to pay");

        totalAmountToPay.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(offerCheckPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pointsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(58, 58, 58)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalAmountToPay, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jButton6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5))
                                .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane8))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pointsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalAmountToPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton6)
                                    .addComponent(jButton5)))
                            .addComponent(offerCheckPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_customerJListValueChanged
        // TODO add your handling code here:
        resetCustomerPanel();
        
        for (CustomerCard customerCard: customerCardList) {
            if (customerJList.getSelectedValue().getID() == customerCard.getCustomer().getID()) {
                pointsTextField.setText(String.valueOf(customerCard.getPoints()));
                pointsPanel.setVisible(true);
                break;
            }
        }
        
        List<OfferCheck> filteredList = offerCheckList.stream()
                .filter((offerCheck) -> customerJList.getSelectedValue().getID() == offerCheck.getCustomer().getID())
                .toList();
        
        if(filteredList.size() > 0) {
            offerCheckJList.setModel(new javax.swing.AbstractListModel<OfferCheck>() {
                public int getSize() { return filteredList.size(); }
                public OfferCheck getElementAt(int i) { return filteredList.get(i); }
            });
            
            offerCheckPanel2.setVisible(true);
        }
        resetAmountAndQuantity();
    }//GEN-LAST:event_customerJListValueChanged
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!totalAmountToPay.getText().trim().isEmpty()) {
            Product product = productJList.getSelectedValue();
            int quantity = Integer.parseInt(quantityTextField.getText());
            Customer customer = customerJList.getSelectedValue();
            Sale sale = new Sale(customer, product, quantity, Double.parseDouble(totalAmountToPay.getText()));
            saleDAO.add(sale);
            //TODO recalculate customer points and stock
            JOptionPane.showMessageDialog(rootPane, SUCCESS_MSG);
            setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pointsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pointsTextFieldActionPerformed

    private void quantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTextFieldActionPerformed

    private void productJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productJListValueChanged
        // TODO add your handling code here:
        resetAmountAndQuantity();
    }//GEN-LAST:event_productJListValueChanged

    private void offerCheckJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_offerCheckJListValueChanged
        // TODO add your handling code here:
        refreshAmount();
    }//GEN-LAST:event_offerCheckJListValueChanged

    private void pointsRadioBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pointsRadioBtnItemStateChanged
        // TODO add your handling code here:
        refreshAmount();
    }//GEN-LAST:event_pointsRadioBtnItemStateChanged

    private void load(){
        pointsPanel.setVisible(false);
        offerCheckPanel2.setVisible(false);
        
        quantityTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
              refreshAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
              refreshAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                refreshAmount();
            }
          });
    }
    
    private void refreshAmount() {
        try {
            int quantity = Integer.parseInt(quantityTextField.getText());
            if (productJList.getSelectedValue() != null && quantity > 0) {
                int points = (pointsRadioBtn.isSelected()) ? Integer.parseInt(pointsTextField.getText()) : 0;
                double valueFromCheckOffer = (offerCheckJList.getSelectedValue() != null) ? offerCheckJList.getSelectedValue().getValue() : 0 ;
                Double amount = productJList.getSelectedValue().getPrice() * Integer.parseInt(quantityTextField.getText());
                amountTextField.setText(String.valueOf(amount));

                Double newAmount = Sale.getDiscountedValue(amount, points);
                newAmount = newAmount - valueFromCheckOffer;
                totalAmountToPay.setText(newAmount.toString());
            }
        } catch (NumberFormatException exception) {
        
        }
    }
    
    private void resetCustomerPanel() {
        pointsPanel.setVisible(false);
        offerCheckPanel2.setVisible(false);
        pointsRadioBtn.setSelected(false);
        offerCheckJList.setSelectedValue(null, rootPaneCheckingEnabled);
    }
    
    private void resetAmountAndQuantity() {
        amountTextField.setText("");
        quantityTextField.setText("");
        totalAmountToPay.setText("");
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountTextField;
    private javax.swing.JList<Customer> customerJList;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList<OfferCheck> offerCheckJList;
    private javax.swing.JPanel offerCheckPanel2;
    private javax.swing.JPanel pointsPanel;
    private javax.swing.JRadioButton pointsRadioBtn;
    private javax.swing.JTextField pointsTextField;
    private javax.swing.JList<Product> productJList;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JTextField totalAmountToPay;
    // End of variables declaration//GEN-END:variables
}

package GUI;

import data.OfferCheck;
import data.OfferCheckDAO;
import javax.swing.table.DefaultTableModel;

public class OfferCheckList extends javax.swing.JFrame {
    
    private OfferCheckDAO offerCheckDAO;
    
    public OfferCheckList() {
        offerCheckDAO = new OfferCheckDAO();
        initComponents();
        loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        offerCheckList = new javax.swing.JTable();
        leaveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        offerCheckList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(offerCheckList);

        leaveBtn.setText("Leave");
        leaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 421, Short.MAX_VALUE)
                        .addComponent(leaveBtn)))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(leaveBtn)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_leaveBtnActionPerformed

    public void loadTable() {
        DefaultTableModel model = new javax.swing.table.DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Card Owner");
        model.addColumn("Customer");
        model.addColumn("Initial value");
        model.addColumn("Current value");

        for (OfferCheck offerCheck : offerCheckDAO.getAll()) {
            model.addRow(new Object[]{
                offerCheck.getID(), offerCheck.getOwner().getCustomer().getName(), offerCheck.getCustomer().getName(), offerCheck.getInitialValue() , offerCheck.getValue()
            });
        }
        
        offerCheckList.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton leaveBtn;
    private javax.swing.JTable offerCheckList;
    // End of variables declaration//GEN-END:variables
}

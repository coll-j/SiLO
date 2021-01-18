/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.DeliveryNoteCtrl;

public class DeliveryNotePanel extends javax.swing.JPanel {
	
	private MainPage parent;
	
    public DeliveryNotePanel(MainPage main) {
    	parent = main;
    	initComponents();
    	initCode();
    }

    private void initComponents() {

        SuratJalanPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        searchTF = new javax.swing.JTextField();

        SuratJalanPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Delivery Note List");

//        parent.getDnTable().setTable(parent.getDnCtrl().getDNShort(), parent.getItemTableCol());
        
    }

    private javax.swing.JPanel SuratJalanPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTF;
    
    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	parent.getDnTable().setTable(parent.getDnCtrl().searchDN(searchTF.getText()), parent.getDnTableCol());
    }
    
    private void initCode() {
    	searchBtn.setText("Search");
    	searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	searchBtnActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout SuratJalanPanelLayout = new javax.swing.GroupLayout(SuratJalanPanel);
        SuratJalanPanel.setLayout(SuratJalanPanelLayout);
        SuratJalanPanelLayout.setHorizontalGroup(
            SuratJalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuratJalanPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(SuratJalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SuratJalanPanelLayout.createSequentialGroup()
                        .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBtn))
                    .addGroup(SuratJalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(parent.getDnTable().getScrPane(), javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        SuratJalanPanelLayout.setVerticalGroup(
            SuratJalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuratJalanPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(SuratJalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parent.getDnTable().getScrPane(), javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SuratJalanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SuratJalanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}

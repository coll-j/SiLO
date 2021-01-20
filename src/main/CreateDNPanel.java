package main;

import javax.swing.JOptionPane;

public class CreateDNPanel extends javax.swing.JPanel {

	private MainPage parent;
	
    public CreateDNPanel(MainPage main) {
    	parent = main;
        initComponents();
        initCode();
    }

    private void initComponents() {

        BuatSuratPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        invoiceNumTF = new javax.swing.JTextField();
        dnNumTF = new javax.swing.JTextField();
        invoiceNumLabel = new javax.swing.JLabel();
        dnNumLabel = new javax.swing.JLabel();
        cusNameLabel = new javax.swing.JLabel();
        cusNameTF = new javax.swing.JTextField();
        createBtn = new javax.swing.JButton();
        reqItemLabel = new javax.swing.JLabel();
        reqItemTF = new javax.swing.JTextField();

        BuatSuratPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Delivery Note Form");

        invoiceNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        invoiceNumLabel.setText("Invoice Number :");

        dnNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dnNumLabel.setText("Delivery Note Number :");

        cusNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cusNameLabel.setText("Customer Name :");

        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        reqItemLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        reqItemLabel.setText("Requested Item(s) :");

        
    }

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	if( dnNumTF.getText().isEmpty() ||
			cusNameTF.getText().isEmpty() ||
			reqItemTF.getText().isEmpty() ||
			invoiceNumTF.getText().isEmpty()
			) {
    		JOptionPane.showOptionDialog(this, 
    				"Please fill the empty field",
	                "Empty Field", 
	                JOptionPane.PLAIN_MESSAGE,
	                   JOptionPane.ERROR_MESSAGE,
	                   null,
	                   null,
	                   "OK");
    	}    	
    	else {    		
    		int jawab = JOptionPane.showOptionDialog(this, 
    				"Are you sure you want to create Delivery Note ?", 
    				"Confirmation Message", 
    				JOptionPane.WARNING_MESSAGE, 
    				JOptionPane.QUESTION_MESSAGE, null, null, null);
    		
    		if (jawab == JOptionPane.OK_OPTION) {
    			parent.createDN(dnNumTF.getText(),
    					cusNameTF.getText(),
    					reqItemTF.getText(),
    					invoiceNumTF.getText()
    					);
    			parent.showNewDNPopUp(dnNumTF.getText());
    			
    			dnNumTF.setText("");
    			cusNameTF.setText("");
    			reqItemTF.setText("");
    			invoiceNumTF.setText("");  
    		}
    	}
    }
    
    private javax.swing.JPanel BuatSuratPanel;
    private javax.swing.JButton createBtn;
    private javax.swing.JLabel cusNameLabel;
    private javax.swing.JTextField cusNameTF;
    private javax.swing.JLabel dnNumLabel;
    private javax.swing.JTextField dnNumTF;
    private javax.swing.JLabel invoiceNumLabel;
    private javax.swing.JTextField invoiceNumTF;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel reqItemLabel;
    private javax.swing.JTextField reqItemTF;
    
    private void initCode() {
    	javax.swing.GroupLayout BuatSuratPanelLayout = new javax.swing.GroupLayout(BuatSuratPanel);
        BuatSuratPanel.setLayout(BuatSuratPanelLayout);
        BuatSuratPanelLayout.setHorizontalGroup(
            BuatSuratPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuatSuratPanelLayout.createSequentialGroup()
                .addGroup(BuatSuratPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BuatSuratPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2))
                    .addGroup(BuatSuratPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BuatSuratPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createBtn)
                            .addGroup(BuatSuratPanelLayout.createSequentialGroup()
                                .addGroup(BuatSuratPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BuatSuratPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dnNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(invoiceNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cusNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(BuatSuratPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoiceNumTF, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dnNumTF, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cusNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reqItemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(BuatSuratPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(reqItemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        BuatSuratPanelLayout.setVerticalGroup(
            BuatSuratPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuatSuratPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(54, 54, 54)
                .addGroup(BuatSuratPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceNumTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceNumLabel))
                .addGap(18, 18, 18)
                .addGroup(BuatSuratPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dnNumTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dnNumLabel))
                .addGap(18, 18, 18)
                .addGroup(BuatSuratPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cusNameLabel)
                    .addComponent(cusNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BuatSuratPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reqItemLabel)
                    .addComponent(reqItemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(createBtn)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BuatSuratPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BuatSuratPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}

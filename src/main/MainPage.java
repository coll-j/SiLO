/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.*;
import database.DbHandler;

public class MainPage extends JFrame {
	
	private static Vector<String> itemTableCol,
								  dnTableCol,
								  invoiceTableCol;

    private static DbHandler db;
    
	private static ItemCtrl itemCtrl;
	private static DeliveryNoteCtrl dnCtrl;
	private static InvoiceCtrl invoiceCtrl;
	
	private static CreateDNCtrl createDNCtrl;
    
    private static ItemPanel itemPanel;
    private static InvoicePanel invoicePanel;
    private static CreateDNPanel createDNPanel;
    private static DeliveryNotePanel deliveryNotePanel;
    
    private static Table itemTable;
    private static Table invoiceTable;
    private static Table deliveryNoteTable;
    
    private static PopUp addItemPopUp;
    private static AddItemPanel addItemPanel;
    private static PopUp editItemPopUp;
    private static EditItemPanel editItemPanel;
    private static PopUp viewInvoicePopUp;
    private static ViewInvoicePanel viewInvoicePanel;
    private static PopUp viewDNPopUp;
    private static ViewDNPanel viewDNPanel;
    private static PopUp newDNPopUp;
    private static NewDNPanel newDNPanel;
    private static PopUp sendEmailPopUp;
    private static SendEmailPanel sendEmailPanel;
    
    public MainPage() {
    	initTableCol();
        initComponents();
        initCode();
    }
        
    public void paintPanel(JPanel panel){
        clear();
    	MainPanel.add(panel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }
    
    public void clear() {
    	MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
    }
    
    public void setItemTable( String keyword) {
    	itemTable.setTable(itemCtrl.searchItems(keyword), itemTableCol );
    }
    
    public void setItemTable() {
    	itemTable.setTable(itemCtrl.getItems(), itemTableCol );
    }
    
    public void setInvoiceTable( String keyword) {
    	invoiceTable.setTable(invoiceCtrl.searchInvoices(keyword), invoiceTableCol );
    }
    
    public void setInvoiceTable() {
    	invoiceTable.setTable(invoiceCtrl.getInvoices(), invoiceTableCol );    	
    }
    
    public void setDNTable( String keyword) {
    	deliveryNoteTable.setTable(dnCtrl.searchDelivNotes(keyword), dnTableCol );    	    	
    }
    
    public void setDNTable() {
    	deliveryNoteTable.setTable(dnCtrl.getDelivNotes(), dnTableCol );
    }
    
    public JScrollPane getItemTableScrPane() {
    	return itemTable.getScrPane();
    }
    
    public JScrollPane getInvoiceTableScrPane() {
    	return invoiceTable.getScrPane();
    }    

    public JScrollPane getDNTableScrPane() {
    	return deliveryNoteTable.getScrPane();
    }
    
    
    public void createItem( String id, String barcode, String title, String description, String manufacturer, String url, String stocks) {
    	itemCtrl.addItem(id, barcode, title, description, manufacturer, url, stocks);
    }
    
    public String[] getItem(String id) {
    	return itemCtrl.getItem(id);
    }

    public void editItem(String id, String barcode, String title, String description, String manufacturer, String url, String stocks) {
    	itemCtrl.editItem(id, barcode, title, description, manufacturer, url, stocks);
    }
    
    public void createDN(String deliveryNoteNumber, String customerName, String requestedItem, String invoiceNumber) {
    	createDNCtrl.createDN(deliveryNoteNumber, customerName, requestedItem, invoiceNumber);
    }
    
    public String[] getDelivNote(String id) {
    	return dnCtrl.getDelivNote(id);
    }
    
    public void editStatusDN(String id, String status) {
    	dnCtrl.editStatusDN(id, status);
    }
    
    public void completeDN(String id, String sign) {
    	dnCtrl.completeDN(id, sign);
    }
    
    public String[] getInvoice(String id) {
    	return invoiceCtrl.getInvoice(id);
    }
    
    public void editStatusInvoice(String id) {
    	invoiceCtrl.editStatusInvoice(id);
    }
    
    public void completeInvoice(String id) {
    	invoiceCtrl.completeInvoice(id);
    }
    

    public void showAddItemPopUp() {
    	addItemPopUp.showPopUp(addItemPanel);
    }
    
    public void hideAddItemPopUp() {
    	addItemPopUp.hidePopUp();
    }
    
    public void showEditItemPopUp(String id) {
    	editItemPanel.fill(id);
    	editItemPopUp.showPopUp(editItemPanel);
    }
    
    public void hideEditItemPopUp() {
    	editItemPopUp.hidePopUp();
    }
    
    public void showInvoicePopUp(String id) {
    	viewInvoicePanel.fill(id);
    	viewInvoicePopUp.showPopUp(viewInvoicePanel);
    }
    
    public void hideInvoicePopUp() {
    	viewInvoicePopUp.hidePopUp();
    }
    
    public void showViewDNPopUp(String id) {
    	viewDNPanel.fill(id);
    	viewDNPopUp.showPopUp(viewDNPanel);
    }
    
    public void hideViewDNPopUp() {
    	viewDNPopUp.hidePopUp();
    }
    
    public void showNewDNPopUp(String id) {
    	newDNPanel.fill(id);
    	newDNPopUp.showPopUp(newDNPanel);
    }
    
    public void hideNewDNPopUp() {
    	newDNPopUp.hidePopUp();
    }
    
    public void showSendEmailPopUp(String id) {
    	sendEmailPanel.fill(id);
    	sendEmailPopUp.showPopUp(sendEmailPanel);
    }
    
    public void hideSendEmailPopUp() {
    	sendEmailPopUp.hidePopUp();
    }
    
    
    
    private void ItemBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	setItemTable();
        paintPanel(itemPanel);
    }

    private void deliveryNoteBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	setDNTable();
    	paintPanel(deliveryNotePanel);
    }
    
    private void CreateDNBtnActionPerformed(java.awt.event.ActionEvent evt) {        
    	paintPanel(createDNPanel);
    }
    
    private void InvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	setInvoiceTable();
    	paintPanel(invoicePanel);
    }
    
    private void initComponents() {
    	db = new DbHandler();
    	
    	itemCtrl = new ItemCtrl(db);
    	dnCtrl = new DeliveryNoteCtrl(db);
    	invoiceCtrl = new InvoiceCtrl(db);
    	
    	createDNCtrl = new CreateDNCtrl(dnCtrl, invoiceCtrl);
    	        
    	itemTable = new Table(this);
    	invoiceTable = new Table(this);
    	deliveryNoteTable = new Table(this);
        
        itemPanel = new ItemPanel(this);
        createDNPanel = new CreateDNPanel(this);
        invoicePanel = new InvoicePanel(this);
        deliveryNotePanel = new DeliveryNotePanel(this);
        
        addItemPanel = new AddItemPanel(this);
        addItemPopUp = new PopUp(itemPanel);
        
        editItemPanel = new EditItemPanel(this);
    	editItemPopUp = new PopUp(itemPanel);
    	
    	viewInvoicePanel = new ViewInvoicePanel(this);
    	viewInvoicePopUp = new PopUp(invoicePanel);
    	
    	viewDNPanel = new ViewDNPanel(this);
    	viewDNPopUp = new PopUp(deliveryNotePanel);
    	
    	newDNPanel = new NewDNPanel(this);
    	newDNPopUp = new PopUp(createDNPanel);
    	
    	sendEmailPanel = new SendEmailPanel(this);
    	sendEmailPopUp = new PopUp(createDNPanel);
        
    	MenuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ItemBtn = new javax.swing.JButton();
        deliveryNoteBtn = new javax.swing.JButton();
        InvoiceBtn = new javax.swing.JButton();
        CreateDNBtn = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        WelcomePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
    }

	public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("running");
                new MainPage().setVisible(true);
            }
        });
    }
    
    private void initTableCol() {
    	itemTableCol = new Vector<String>();
    	itemTableCol.add("ID");
    	itemTableCol.add("Title");
    	itemTableCol.add("Manufacturer");
    	itemTableCol.add("Stocks");
    	itemTableCol.add("");
    	
    	dnTableCol = new Vector<String>();
    	dnTableCol.add("Invoice Number");
    	dnTableCol.add("Delivery Notes Number");
    	dnTableCol.add("Customer Name");
    	dnTableCol.add("Order Date");
    	dnTableCol.add("Delivery Date");
    	dnTableCol.add("Status");
    	dnTableCol.add("");
    	
    	invoiceTableCol = new Vector<String>();
    	invoiceTableCol.add("Invoice Number");
    	invoiceTableCol.add("PO Number");
    	invoiceTableCol.add("Supplier Name");
    	invoiceTableCol.add("Order Date");
    	invoiceTableCol.add("Delivery Date");
    	invoiceTableCol.add("Status");
    	invoiceTableCol.add("");
    }
    

	private static javax.swing.JButton CreateDNBtn;
    private static javax.swing.JButton InvoiceBtn;
    private static javax.swing.JButton ItemBtn;
    private static javax.swing.JPanel MainPanel;
    private static javax.swing.JPanel MenuPanel;
    private static javax.swing.JPanel WelcomePanel;
    private static javax.swing.JButton deliveryNoteBtn;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel10;
	
	private void initCode() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SILO");

        MenuPanel.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistem Informasi Logistik");

        ItemBtn.setText("Item");
        ItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemBtnActionPerformed(evt);
            }
        });

        deliveryNoteBtn.setText("Delivery Note");
        deliveryNoteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryNoteBtnActionPerformed(evt);
            }
        });

        InvoiceBtn.setText("Invoice");
        InvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvoiceBtnActionPerformed(evt);
            }
        });

        CreateDNBtn.setText("Create Delivery Note");
        CreateDNBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateDNBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deliveryNoteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ItemBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InvoiceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CreateDNBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(ItemBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deliveryNoteBtn)
                .addGap(11, 11, 11)
                .addComponent(InvoiceBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreateDNBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainPanel.setBackground(new java.awt.Color(0, 0, 0));
        MainPanel.setLayout(new java.awt.CardLayout());

        jLabel10.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        jLabel10.setText("Selamat Datang!");

        javax.swing.GroupLayout WelcomePanelLayout = new javax.swing.GroupLayout(WelcomePanel);
        WelcomePanel.setLayout(WelcomePanelLayout);
        WelcomePanelLayout.setHorizontalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanelLayout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(271, 271, 271))
        );
        WelcomePanelLayout.setVerticalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(495, Short.MAX_VALUE))
        );

        MainPanel.add(WelcomePanel, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
	}

}

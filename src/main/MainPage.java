/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.*; 
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.table.DefaultTableModel;

import controller.*;

public class MainPage extends javax.swing.JFrame {
	
    private final String[] ItemTableCol = new String[] { "ID", "Title", "Manufacturer", "Stocks"};
    
	private javax.swing.JButton CreateDNBtn;
    private javax.swing.JButton InvoiceBtn;
    private javax.swing.JButton ItemBtn;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JButton deliveryNoteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;

    private ItemPanel itemPanel;
    private TagihanPanel tagihanPanel;
    private BuatSuratPanel buatSuratPanel;
    private SuratJalanPanel suratJalanPanel;
    private AddItemPanel addItemPanel;
    
    private Table itemTable;
    private ItemCtrl itemCtrl;
    
    private PopUp addItemPopUp;
    
    public MainPage() {
        initComponents();
        
        initCode();
    }
    
    private void initComponents() {
    	itemCtrl = new ItemCtrl();
        
    	itemTable = new Table(this);
        
        itemPanel = new ItemPanel(this);
        tagihanPanel = new TagihanPanel();
        buatSuratPanel = new BuatSuratPanel();
        suratJalanPanel = new SuratJalanPanel();
        
        addItemPanel = new AddItemPanel(this);
        addItemPopUp = new PopUp(itemPanel, this);
        
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
        
    public void paintPanel(JPanel panel){
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(panel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }
    
    private void ItemBtnActionPerformed(java.awt.event.ActionEvent evt) {
        paintPanel(this.itemPanel);
    }

    private void deliveryNoteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        paintPanel(this.suratJalanPanel);
    }

    private void InvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	paintPanel(this.tagihanPanel);
    }

    private void CreateDNBtnActionPerformed(java.awt.event.ActionEvent evt) {        
    	paintPanel(this.buatSuratPanel);
    }
    
    public ItemPanel getItemPanel() {
		return itemPanel;
	}
	
	public void setItemPanel(ItemPanel itemPanel) {
		this.itemPanel = itemPanel;
	}
	
	public AddItemPanel getAddItemPanel() {
		return addItemPanel;
	}

	public void setAddItemPanel(AddItemPanel addItemPanel) {
		this.addItemPanel = addItemPanel;
	}

	public PopUp getAddItemPopUp() {
		return addItemPopUp;
	}

	public String[] getItemTableCol() {
		return ItemTableCol;
	}

	public void setAddItemPopUp(PopUp addItemPopUp) {
		this.addItemPopUp = addItemPopUp;
	}

	public Table getItemTable() {
		return itemTable;
	}

	public void setItemTable(Table itemTable) {
		this.itemTable = itemTable;
	}

	public ItemCtrl getItemCtrl() {
		return itemCtrl;
	}

	public void setItemCtrl(ItemCtrl itemCtrl) {
		this.itemCtrl = itemCtrl;
	}

	public TagihanPanel getTagihanPanel() {
		return tagihanPanel;
	}
	
	public void setTagihanPanel(TagihanPanel tagihanPanel) {
		this.tagihanPanel = tagihanPanel;
	}
	
	public BuatSuratPanel getBuatSuratPanel() {
		return buatSuratPanel;
	}
	
	public void setBuatSuratPanel(BuatSuratPanel buatSuratPanel) {
		this.buatSuratPanel = buatSuratPanel;
	}
	
	public SuratJalanPanel getSuratJalanPanel() {
		return suratJalanPanel;
	}
	
	public void setSuratJalanPanel(SuratJalanPanel suratJalanPanel) {
		this.suratJalanPanel = suratJalanPanel;
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

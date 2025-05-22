package tui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import model.Order;
import model.OrderLine;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ScanOrder2 extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldBarcode;
	private JLabel labelBarcode; 
	private OrderController orderController; 
	private DefaultListModel<String> listModelProduct; 
	private JList<String> productList; 
	private JList<Double> priceList; 
	private JList<String> customerList; 
	private DefaultListModel<String> listModelCustomer; 
	private String orderNumber; 
	private String orderType; 
	private String department; 
	private DefaultListModel<Double> listModelPrice; 
	private Order order; 
	private OrderView orderView; 
	private JTextField customerIdTF;
	


	public static void main(String[] args) {
		try {		
			TryMe data = new TryMe(); 
			data.generateData();
			ScanOrder2 dialog = new ScanOrder2("1312", "12121", "12121");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	

	public ScanOrder2(String orderNumber, String orderType, String department) {
		this.orderNumber=orderNumber; 
    	this.orderType=orderType; 
		this.department=department; 
		
	this.orderController = new OrderController(); 
		listModelProduct = new DefaultListModel<>(); 
		productList = new JList<>(listModelProduct); 
		listModelPrice = new DefaultListModel<>();
		listModelCustomer = new DefaultListModel<>(); 
		customerList = new JList<>(listModelCustomer); 
		priceList = new JList<>(listModelPrice); 
		initGui(); 
		
		orderController.createOrder(orderNumber, orderType, department); 
		
		this.order = orderController.findOrderByOrderNumber(orderNumber); 

		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("closing!"); 
				dispose(); 
			}
		});
		
		setVisible(true); 
		
	}
		
		
		public void initGui() { 
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel = new JPanel();
				contentPanel.add(panel, BorderLayout.NORTH);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
				gbl_panel.rowHeights = new int[]{0, 0, 0};
				gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					
			
				        
					JLabel labelBarcode_1 = new JLabel("Stregkode: ");
					GridBagConstraints gbc_labelBarcode_1 = new GridBagConstraints();
					gbc_labelBarcode_1.anchor = GridBagConstraints.EAST;
					gbc_labelBarcode_1.insets = new Insets(0, 0, 5, 5);
					gbc_labelBarcode_1.gridx = 0;
					gbc_labelBarcode_1.gridy = 0;
					panel.add(labelBarcode_1, gbc_labelBarcode_1);
				}
				{
					{
						textFieldBarcode = new JTextField();
						GridBagConstraints gbc_textFieldBarcode = new GridBagConstraints();
						gbc_textFieldBarcode.insets = new Insets(0, 0, 5, 5);
						gbc_textFieldBarcode.fill = GridBagConstraints.HORIZONTAL;
						gbc_textFieldBarcode.gridx = 1;
						gbc_textFieldBarcode.gridy = 0;
						panel.add(textFieldBarcode, gbc_textFieldBarcode);
						textFieldBarcode.setColumns(10);
					}
				
				}
				JButton scanButton = new JButton("Scan");
				scanButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String barcode = textFieldBarcode.getText(); 
						String productInfo = orderController.getProductInfo(barcode);  
					
						
						
				
						if(productInfo.equals("Produktet ikke at finde ")) {
							JOptionPane.showMessageDialog(ScanOrder2.this, "Produktet ikke at finde", "Error", JOptionPane.ERROR_MESSAGE);
							System.out.println("Produktet ikke at finde");
							
						} else {
							boolean added = orderController.addProductToOrder(orderNumber, barcode, 1); 

							if(added) {
								listModelProduct.addElement(productInfo); 
							
					
								JOptionPane.showMessageDialog(ScanOrder2.this, "Produkt tilføjet til ordre: " + orderNumber, "Succes", JOptionPane.INFORMATION_MESSAGE); 
			
								System.out.println("SUccess");
								
							} else { 
								JOptionPane.showMessageDialog(ScanOrder2.this, "Produkt ikke at finde i systemet ", "Error", JOptionPane.ERROR_MESSAGE); 
							}
				
						}
						textFieldBarcode.setText(""); 
						listModelPrice.clear(); 
						
				
						 listModelPrice.addElement(order.getTotalPrice()); 
				
					}
				});
				
				scanButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
						KeyStroke.getKeyStroke("SPACE"),"scanAction"); 
				scanButton.getActionMap().put("scanAction", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						scanButton.doClick(); 
					}
				});
				GridBagConstraints gbc_scanButton = new GridBagConstraints();
				gbc_scanButton.insets = new Insets(0, 0, 5, 0);
				gbc_scanButton.gridx = 2;
				gbc_scanButton.gridy = 0;
				panel.add(scanButton, gbc_scanButton);
			}
			{
				JPanel panel = new JPanel();
				contentPanel.add(panel, BorderLayout.CENTER);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{168, 258, 0};
				gbl_panel.rowHeights = new int[]{174, 0, 0};
				gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					JPanel panel_1 = new JPanel();
					GridBagConstraints gbc_panel_1 = new GridBagConstraints();
					gbc_panel_1.insets = new Insets(0, 0, 5, 5);
					gbc_panel_1.fill = GridBagConstraints.BOTH;
					gbc_panel_1.gridx = 0;
					gbc_panel_1.gridy = 0;
					panel.add(panel_1, gbc_panel_1);
					GridBagLayout gbl_panel_1 = new GridBagLayout();
					gbl_panel_1.columnWidths = new int[]{0, 0, 0};
					gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
					gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
					gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
					panel_1.setLayout(gbl_panel_1);
					{
						customerIdTF = new JTextField();
						
						
						customerIdTF = new JTextField();
						customerIdTF.setText("Kunde ID: ");
						customerIdTF.setForeground(new Color(153, 153, 153));
						customerIdTF.addFocusListener(new FocusAdapter() {
							@Override
							public void focusGained(FocusEvent e) {
								if(customerIdTF.getText().equals("Kunde ID: ")) {
									customerIdTF.setText(""); 
									customerIdTF.setForeground(Color.BLACK); 
								}
							}
							@Override
							public void focusLost(FocusEvent e) {
								if(customerIdTF.getText().equals("")) {
									customerIdTF.setText("Kunde ID: "); 
									customerIdTF.setForeground(new Color(153, 153, 153)); 
								}
							}
							
						});
						
						
						GridBagConstraints gbc_customerIdTF = new GridBagConstraints();
						gbc_customerIdTF.insets = new Insets(10, 10, 10, 10);
						gbc_customerIdTF.fill = GridBagConstraints.HORIZONTAL;
						gbc_customerIdTF.gridx = 0;
						gbc_customerIdTF.gridy = 5;
						gbc_customerIdTF.gridwidth = 2; 
						gbc_customerIdTF.anchor = GridBagConstraints.CENTER; 
						panel_1.add(customerIdTF, gbc_customerIdTF);
						customerIdTF.setColumns(10);
						
					}
					{
						JButton btnNewButton = new JButton("Tilføj Kunde");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								try {
								
								String customerId = customerIdTF.getText(); 
								
								
								
								if(customerId == null || customerId.trim().isEmpty()) {
									
									return; 
									
								}
								
								String customerInfo = orderController.getCustomerInfo(customerId); 
								
								if(customerInfo.equals("Kunde ikke at finde")) {
									JOptionPane.showMessageDialog(ScanOrder2.this, "Kunden ikke at finde", "Error", JOptionPane.ERROR_MESSAGE);
									System.out.println("Kunden ikke at finde");
									
								} else {
									boolean added = orderController.addCustomerToOrder(orderNumber, customerId); 

									if(added) {
//										listModelProduct.addElement(customerInfo); 

										
		
							
										JOptionPane.showMessageDialog(ScanOrder2.this, "Kunde tilføjet til ordre: " + orderNumber, "Succes", JOptionPane.INFORMATION_MESSAGE); 
				
										System.out.println("SUccess");
										
									} else { 
										JOptionPane.showMessageDialog(ScanOrder2.this, "Kunde ikke at finde i systemet ", "Error", JOptionPane.ERROR_MESSAGE); 
									}
					
								}
								customerIdTF.setText(""); 
							
						
							
								
							}catch(Exception ex){
            System.out.println("fejl"+ex.getMessage());
            ex.printStackTrace();
        }
							}
						});
						
						
						GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
						gbc_btnNewButton.insets = new Insets(10, 10, 10, 10); 
						gbc_btnNewButton.gridx = 0;
						gbc_btnNewButton.gridy = 6;
						gbc_btnNewButton.gridwidth = 2;
						gbc_btnNewButton.anchor = GridBagConstraints.CENTER; 
						panel_1.add(btnNewButton, gbc_btnNewButton);
					}
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					GridBagConstraints gbc_scrollPane = new GridBagConstraints();
					gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
					gbc_scrollPane.anchor = GridBagConstraints.WEST;
					gbc_scrollPane.fill = GridBagConstraints.VERTICAL;
					gbc_scrollPane.gridx = 1;
					gbc_scrollPane.gridy = 0;
					panel.add(scrollPane, gbc_scrollPane);
			
					productList = new JList<>(listModelProduct);
					scrollPane.setViewportView(productList); 
				}
			}
			{
				JPanel southPane = new JPanel();
				getContentPane().add(southPane, BorderLayout.SOUTH);
				GridBagLayout gbl_southPane = new GridBagLayout();
				gbl_southPane.columnWidths = new int[]{0, 0, 0, 0, 45, 0};
				gbl_southPane.rowHeights = new int[]{13, 0};
				gbl_southPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_southPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
				southPane.setLayout(gbl_southPane);
				{
					JLabel lblNewLabel = new JLabel("Samlet Pris: ");
					GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
					gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
					gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
					gbc_lblNewLabel.gridx = 0;
					gbc_lblNewLabel.gridy = 0;
					southPane.add(lblNewLabel, gbc_lblNewLabel);
				}
				{
					priceList = new JList<>(listModelPrice);
					GridBagConstraints gbc_priceList = new GridBagConstraints();
					gbc_priceList.insets = new Insets(0, 0, 0, 5);
					gbc_priceList.fill = GridBagConstraints.BOTH;
					gbc_priceList.gridx = 1;
					gbc_priceList.gridy = 0;
					southPane.add(priceList, gbc_priceList);
				}
				{
					JButton confirmOrder = new JButton("Bekræft Ordre");
					confirmOrder.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
			 
							
							
							Kvittering dialog = new Kvittering(orderNumber, ScanOrder2.this); 
							dialog.setVisible(true);
						}
					});
					
					confirmOrder.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
							KeyStroke.getKeyStroke("ENTER"),"scanAction"); 
					confirmOrder.getActionMap().put("scanAction", new AbstractAction() {
						@Override
						public void actionPerformed(ActionEvent e) {
							confirmOrder.doClick(); 
						}
					});
					
				
					
					
					
					GridBagConstraints gbc_confirmOrder = new GridBagConstraints();
					gbc_confirmOrder.gridx = 4;
					gbc_confirmOrder.gridy = 0;
					southPane.add(confirmOrder, gbc_confirmOrder);
				}
			}
			{
				JPanel panel = new JPanel();
				getContentPane().add(panel, BorderLayout.NORTH);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{195, 45, 0, 0, 0, 0, 0};
				gbl_panel.rowHeights = new int[]{0, 0, 13, 0};
				gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					JLabel pngFile = new JLabel("");
					GridBagConstraints gbc_pngFile = new GridBagConstraints();
					gbc_pngFile.insets = new Insets(0, 0, 5, 5);
					gbc_pngFile.gridx = 0;
					gbc_pngFile.gridy = 1;
					panel.add(pngFile, gbc_pngFile);
					
					ImageIcon imageIcon = new ImageIcon("C:\\Users\\johan\\OneDrive\\Skrivebord\\ProjektS1\\Semester-projekt\\image.png"); 
					Image image = imageIcon.getImage();
					Image modImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); 
					imageIcon = new ImageIcon(modImage); 
					pngFile.setIcon(imageIcon); 
					
					
					gbc_pngFile.anchor = GridBagConstraints.WEST;
					gbc_pngFile.insets = new Insets(0, 0, 5, 5);
					gbc_pngFile.gridx = 0;
					gbc_pngFile.gridy = 0;
					panel.add(pngFile, gbc_pngFile);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Scan Ordre: ");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
					GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
					gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
					gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
					gbc_lblNewLabel_1.gridx = 0;
					gbc_lblNewLabel_1.gridy = 2;
					panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
					
					pack(); 
				}
				
			}
			
			
		
			
		}
		
		
		

		
	

	
	
	

}





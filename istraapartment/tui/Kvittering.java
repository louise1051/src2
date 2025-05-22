package tui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
import model.Product;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Kvittering extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldTotalPrice;
	private JTextField textFieldOrderType;
	private JTextField orderNumberTextField;
	private JTextField textField_5;
	private JList<String> productList; 
	private DefaultListModel<String> productListModel; 
	private OrderController orderController; 
	private Order order; 
	private String orderNumber; 
	private String department; 
	private String orderType; 
	private ScanOrder2 scanOrder; 
	private Product product; 
	private OrderLine orderLine; 
	private JButton afsO; 
	private JDialog scanOrder2; 
	private JDialog kvittering; 
	private JTextField textFieldCustomer;

	public static void main(String[] args) {
		try {
			Kvittering dialog = new Kvittering();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Kvittering(String orderNumber, ScanOrder2 scanOrder) {
		this.orderNumber=orderNumber; 
		this.scanOrder = scanOrder; 
		orderController = new OrderController(); 
		
		
		productListModel = new DefaultListModel<>();
		productList = new JList<>(productListModel); 
		
		
		
		orderController = new OrderController(); 
		
	
		

		
		this.order = orderController.findOrderByOrderNumber(orderNumber); 
		



kvittering = this; 
 
		
	
		
		
		
	

		initGui(); 
}
	

	
	
	
	

	private void initGui() {
		setBounds(100, 100, 300, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{46, 42, 96, 45, 0};
		gbl_contentPanel.rowHeights = new int[]{19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

			
			System.out.println("Order number found! " + orderNumber); 
								
									JLabel lblNewLabel_5 = new JLabel("Ordre nr. : ");
									GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
									gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
									gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
									gbc_lblNewLabel_5.gridx = 1;
									gbc_lblNewLabel_5.gridy = 1;
									contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
								
			
			

		
			orderNumberTextField = new JTextField(orderNumber);
			orderNumberTextField.setEditable(false);
			GridBagConstraints gbc_orderNumberTextField = new GridBagConstraints();
			gbc_orderNumberTextField.insets = new Insets(0, 0, 5, 5);
			gbc_orderNumberTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_orderNumberTextField.gridx = 2;
			gbc_orderNumberTextField.gridy = 1;
			contentPanel.add(orderNumberTextField, gbc_orderNumberTextField);
			orderNumberTextField.setColumns(10);

							
								JLabel lblNewLabel_4 = new JLabel("Ordre Type: ");
								GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
								gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
								gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel_4.gridx = 1;
								gbc_lblNewLabel_4.gridy = 2;
								contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
			
					textFieldOrderType = new JTextField();
					textFieldOrderType.setEditable(false);
					GridBagConstraints gbc_textFieldOrderType = new GridBagConstraints();
					gbc_textFieldOrderType.insets = new Insets(0, 0, 5, 5);
					gbc_textFieldOrderType.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldOrderType.gridx = 2;
					gbc_textFieldOrderType.gridy = 2;
					contentPanel.add(textFieldOrderType, gbc_textFieldOrderType);
					textFieldOrderType.setColumns(10);
					textFieldOrderType.setText(this.order.getOrderType());
			 
		
		
			productList = new JList<>(productListModel);
			GridBagConstraints gbc_productList = new GridBagConstraints();
			gbc_productList.insets = new Insets(0, 0, 5, 5);
			gbc_productList.fill = GridBagConstraints.BOTH;
			gbc_productList.gridx = 1;
			gbc_productList.gridy = 3;
			contentPanel.add(productList, gbc_productList);

			List<String> orderLineDetails = this.order.displayOrder(); 
					for(String orderLine : orderLineDetails) {
						productListModel.addElement(orderLine);

		
			
			

					}
		
			JLabel lblNewLabel_3 = new JLabel("Samlet Pris: ");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 5;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
	
			textFieldTotalPrice = new JTextField();
			textFieldTotalPrice.setEditable(false);
			GridBagConstraints gbc_textFieldTotalPrice = new GridBagConstraints();
			gbc_textFieldTotalPrice.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldTotalPrice.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldTotalPrice.gridx = 2;
			gbc_textFieldTotalPrice.gridy = 5;
			contentPanel.add(textFieldTotalPrice, gbc_textFieldTotalPrice);
			textFieldTotalPrice.setColumns(10);
			double value = this.order.getTotalPrice(); 
			textFieldTotalPrice.setText(String.valueOf(value) + "kr"); 
			
			JLabel lblNewLabel_1 = new JLabel("Kunde: ");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 10;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			textFieldCustomer = new JTextField();
			textFieldCustomer.setEditable(false);
			GridBagConstraints gbc_textFieldCustomer = new GridBagConstraints();
			gbc_textFieldCustomer.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldCustomer.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCustomer.gridx = 2;
			gbc_textFieldCustomer.gridy = 10;
			contentPanel.add(textFieldCustomer, gbc_textFieldCustomer);
			textFieldCustomer.setColumns(10);
		
	
//			make sure to write the null first! otherwise it will crash, since it hasn´t been defined what should happen if customer is null!!!
			String name = "Standard Kunde"; 
			if(this.order.getCustomer() != null) {
				name = this.order.getCustomer().getName(); 
			}
			
			textFieldCustomer.setText(name);
		
			JLabel lblNewLabel_6 = new JLabel("Dato: ");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_6.gridx = 1;
			gbc_lblNewLabel_6.gridy = 11;
			contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
			textField_5 = new JTextField();
			textField_5.setEditable(false);
			GridBagConstraints gbc_textField_5 = new GridBagConstraints();
			gbc_textField_5.insets = new Insets(0, 0, 0, 5);
			gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_5.gridx = 2;
			gbc_textField_5.gridy = 11;
			contentPanel.add(textField_5, gbc_textField_5);
			textField_5.setColumns(10);
		
			LocalDateTime currentDate = LocalDateTime.now();
		
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
			textField_5.setText(currentDate.format(formatter));
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			
			
			
			
			
				afsO = new JButton("Afslut Ordre");
				afsO.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						scanOrder.dispose(); 
					}
				}); 

				
				afsO.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
						KeyStroke.getKeyStroke("ESCAPE"),"closeAction"); 
         		afsO.getActionMap().put("closeAction", new AbstractAction() {
         			@Override
         			public void actionPerformed(ActionEvent e) {
         				dispose(); 
         				scanOrder.dispose(); 
         			}
         		});
					
				
					
				
				
				buttonPane.add(afsO);
				
				

				
	
				JButton btnNewButton = new JButton("Print Kvittering");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("===================="); 
			            System.out.println("Kvittering: "); 
			            System.out.println("Ordre Nummer: " + order.getOrderNumber()); 
			            System.out.println("Afdeling: " + order.getDepartment()); 
			            System.out.println("Dato: " + order.getDate());  
			    		List<String> orderLineDetails = order.displayOrder(); 
			    		String name = "Standard Kunde"; 
						if(order.getCustomer() != null) {
							name = order.getCustomer().getName(); 
						}
						
						System.out.println("Kunde: " +name); 
						for(String orderLine : orderLineDetails) {
							System.out.println(orderLine); 
							
						}


			            System.out.println("***********************"); 
			             System.out.println("Pris: " + order.getTotalPrice()); 
			             System.out.println("====================");
					}
				});
				buttonPane.add(btnNewButton);
				
				btnNewButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
						KeyStroke.getKeyStroke("ENTER"),"scanAction"); 
				btnNewButton.getActionMap().put("scanAction", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btnNewButton.doClick(); 
					}
				});
		
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{195, 45, 0};
			gbl_panel.rowHeights = new int[]{0, 13, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
				
				JLabel pngFile = new JLabel("");
				GridBagConstraints gbc_pngFile = new GridBagConstraints();
				gbc_pngFile.insets = new Insets(0, 0, 5, 5);
				gbc_pngFile.gridx = 0;
				gbc_pngFile.gridy = 0;
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
			
				JLabel lblNewLabel = new JLabel("Kvittering: ");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 1;
				panel.add(lblNewLabel, gbc_lblNewLabel);
				
				
				pack(); 
				
				
				
			}
	
	

}



	
			
		
	
	
package tui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import model.Order;
import model.OrderLine;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import tui.ScanOrder2;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class OrderView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldOrderNr;
	private JButton scanBtn;
	private ScanOrder2 dialog; 
	private JTextField textField_3;
	private JLabel labelOrderNr; 
	private JLabel labelOrderType; 
	private JLabel labelDepartment; 
	private OrderController orderController; 
	private Order order; 
	private JTextField textFieldDate;
	private JLabel labelDate; 
	private LocalDate date;
	private JTextField textField;
	private JTextField findOrderTextField;
	private String orderNumber; 
	private String orderType; 
	private String department; 
	private Timer clockTimer; 
	private JComboBox comboBoxDepartment; 
	private JComboBox comboBoxOrderType; 
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryMe data = new TryMe(); 
					data.generateData(); 
				 OrderView frame = new OrderView();
					frame.setVisible(true);
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}
		});
	}


	public OrderView() {
		
		this.orderController = new OrderController(); 
		initGui(); 
		
		
		
		
	}
	

	
	private String gON() {
	    return String.format("%08d", Math.abs(new java.util.Random().nextLong()) % 100000000L);
	}
	
	
	private Order findOrderByOrderNumber() {
		String orderNumber = findOrderTextField.getText();  
		
	
		
	
	Order o = orderController.findOrderByOrderNumber(orderNumber); 
	
	if(o == null) {
		JOptionPane.showMessageDialog(OrderView.this, "Ordre ikke at finde i systemet", "Error", JOptionPane.ERROR_MESSAGE);
		return null; 
	}
	
	

		
		String orderType = o.getOrderType(); 
		String department = o.getDepartment(); 
		
		
		
		
		ScanOrder2 dialog = new ScanOrder2(orderNumber, orderType, department); 
		dialog.setVisible(true);
		
		
		
		
		 
		
		return o; 
		
		
	}
	

	
	private void createOrder() {
		
		String orderNumber = textFieldOrderNr.getText(); 
		
		String orderType = (String) comboBoxOrderType.getSelectedItem(); 
		String department = (String) comboBoxDepartment.getSelectedItem();
		
		 if (orderNumber.isEmpty() || orderType == null || department == null) {
	         
	            JOptionPane.showMessageDialog(
	                this,
	                "Alle felter skal udfyldes! Udfyld venligst Ordre Nr, Ordre Type og Afdeling.",
	                "Fejl",
	                JOptionPane.ERROR_MESSAGE
	            );
	            return; 
	        }
		

		try {
			order = new OrderController().createOrder(orderNumber, orderType, department);
			JOptionPane.showMessageDialog(OrderView.this, "Ordre er oprettet ", "Succes", JOptionPane.INFORMATION_MESSAGE); 
	
			
	
				ScanOrder2 dialog = new ScanOrder2(orderNumber, orderType, department); 
				dialog.setVisible(true);
				
				textFieldOrderNr.setText(""); 
				textFieldOrderNr.setText(gON()); 
	
			
			
			
		} catch(IllegalArgumentException e) {
			e.printStackTrace(); 
			JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Order kunne ikke oprettes", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	

	
	public void initGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{190, 45, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{13, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel pngFile = new JLabel(""); 
		pngFile.setVerticalTextPosition(SwingConstants.TOP);
		pngFile.setVerticalAlignment(SwingConstants.TOP);
		pngFile.setHorizontalAlignment(SwingConstants.LEFT);
		pngFile.setHorizontalTextPosition(SwingConstants.LEFT);
		
	
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\johan\\OneDrive\\Skrivebord\\ProjektS1\\Semester-projekt\\image.png"); 
		Image image = imageIcon.getImage();
		Image modImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); 
		imageIcon = new ImageIcon(modImage); 
		pngFile.setIcon(imageIcon); 
		
		GridBagConstraints gbc_pngFile = new GridBagConstraints();
		gbc_pngFile.anchor = GridBagConstraints.WEST;
		gbc_pngFile.insets = new Insets(0, 0, 5, 5);
		gbc_pngFile.gridx = 0;
		gbc_pngFile.gridy = 0;
		panel.add(pngFile, gbc_pngFile);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Dato:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
		
		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		clockTimer = new Timer(1000, e -> { 
		LocalDateTime currentDate = LocalDateTime.now(); 		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
		textField.setText(currentDate.format(formatter));
		});
		clockTimer.start(); 
		
		LocalDateTime currentDate = LocalDateTime.now(); 		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
		textField.setText(currentDate.format(formatter));
		
		JLabel lblNewLabel = new JLabel("Opret Ordre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{47, 96, 0, 59, 0, 96, 0, 44, 0, 0, 96, 0, 0, 85, 0};
		gbl_panel_1.rowHeights = new int[]{21, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel labelOrderNr = new JLabel("Ordre Nr: ");
		GridBagConstraints gbc_labelOrderNr = new GridBagConstraints();
		gbc_labelOrderNr.anchor = GridBagConstraints.WEST;
		gbc_labelOrderNr.insets = new Insets(0, 0, 5, 5);
		gbc_labelOrderNr.gridx = 2;
		gbc_labelOrderNr.gridy = 0;
		panel_1.add(labelOrderNr, gbc_labelOrderNr);
		
		textFieldOrderNr = new JTextField();
		textFieldOrderNr.setEditable(false);
		textFieldOrderNr.setText(gON());
		GridBagConstraints gbc_orderNr = new GridBagConstraints();
		gbc_orderNr.anchor = GridBagConstraints.WEST;
		gbc_orderNr.insets = new Insets(0, 0, 5, 5);
		gbc_orderNr.gridx = 3;
		gbc_orderNr.gridy = 0;
		panel_1.add(textFieldOrderNr, gbc_orderNr);
		textFieldOrderNr.setColumns(10);
		
		JLabel labelOrderType = new JLabel("Ordre Type: ");
		GridBagConstraints gbc_labelOrderType = new GridBagConstraints();
		gbc_labelOrderType.anchor = GridBagConstraints.EAST;
		gbc_labelOrderType.insets = new Insets(0, 0, 5, 5);
		gbc_labelOrderType.gridx = 2;
		gbc_labelOrderType.gridy = 1;
		panel_1.add(labelOrderType, gbc_labelOrderType);
		
		comboBoxOrderType = new JComboBox<>();
		comboBoxOrderType.addItem("Lokal-bestilling");
		comboBoxOrderType.addItem("Fjern-bestilling");
		
		GridBagConstraints gbc_comboBoxOrderType = new GridBagConstraints();
		gbc_comboBoxOrderType.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxOrderType.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxOrderType.gridx = 3;
		gbc_comboBoxOrderType.gridy = 1;
		panel_1.add(comboBoxOrderType, gbc_comboBoxOrderType);
		
		JLabel labelDepartment = new JLabel("Afdeling: ");
		GridBagConstraints gbc_labelDepartment = new GridBagConstraints();
		gbc_labelDepartment.anchor = GridBagConstraints.EAST;
		gbc_labelDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_labelDepartment.gridx = 2;
		gbc_labelDepartment.gridy = 2;
		panel_1.add(labelDepartment, gbc_labelDepartment);
		
		JButton scanButton = new JButton("Scan Produkter");
		scanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				createOrder();
				
			}
		});
		
		
		scanButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("ENTER"),"scanAction"); 
		scanButton.getActionMap().put("scanAction", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scanButton.doClick(); 
			}
		});
		
		comboBoxDepartment = new JComboBox<>();
        comboBoxDepartment.setPreferredSize(new Dimension(150, 20));
        comboBoxDepartment.addItem("DIY");
        comboBoxDepartment.addItem("Tømmerhandel");
        

        GridBagConstraints gbc_comboBoxDepartment = new GridBagConstraints();
        gbc_comboBoxDepartment.anchor = GridBagConstraints.WEST;
        gbc_comboBoxDepartment.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxDepartment.gridx = 3;
        gbc_comboBoxDepartment.gridy = 2;
        panel_1.add(comboBoxDepartment, gbc_comboBoxDepartment);
		GridBagConstraints gbc_scanButton = new GridBagConstraints();
		
		gbc_scanButton.insets = new Insets(0, 0, 5, 5);
		gbc_scanButton.gridx = 3;
		gbc_scanButton.gridy = 4;
		panel_1.add(scanButton, gbc_scanButton);
		
		JButton searchButton = new JButton("Søg");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				findOrderByOrderNumber(); 
				
			}
		});
		
		findOrderTextField = new JTextField();
		findOrderTextField.setText("Ordre Nummer: ");
		findOrderTextField.setForeground(new Color(153, 153, 153));
		findOrderTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(findOrderTextField.getText().equals("Ordre Nummer: ")) {
					findOrderTextField.setText(""); 
					findOrderTextField.setForeground(Color.BLACK); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(findOrderTextField.getText().equals("")) {
					findOrderTextField.setText("Ordre Nummer: "); 
					findOrderTextField.setForeground(new Color(153, 153, 153)); 
				}
			}
			
		});
		
		JLabel findOrderLabel = new JLabel("Find eksisterende ordre: ");
		GridBagConstraints gbc_findOrderLabel = new GridBagConstraints();
		gbc_findOrderLabel.anchor = GridBagConstraints.EAST;
		gbc_findOrderLabel.insets = new Insets(0, 0, 5, 5);
		gbc_findOrderLabel.gridx = 6;
		gbc_findOrderLabel.gridy = 4;
		panel_1.add(findOrderLabel, gbc_findOrderLabel);
		findOrderTextField.setCaretColor(new Color(153, 153, 153));
		
		GridBagConstraints gbc_findOrderTextField = new GridBagConstraints();
		gbc_findOrderTextField.insets = new Insets(0, 0, 5, 5);
		gbc_findOrderTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_findOrderTextField.gridx = 7;
		gbc_findOrderTextField.gridy = 4;
		panel_1.add(findOrderTextField, gbc_findOrderTextField);
		findOrderTextField.setColumns(10);
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.insets = new Insets(0, 0, 0, 5);
		gbc_searchButton.gridx = 7;
		gbc_searchButton.gridy = 5;
		panel_1.add(searchButton, gbc_searchButton);	
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setSize(new Dimension(0, 20));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{189, 85, 85, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 21, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
			}
		});
		cancelBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("ESCAPE"),"closeAction"); 
		cancelBtn.getActionMap().put("closeAction", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); 
			}
		});
		GridBagConstraints gbc_cancelBtn = new GridBagConstraints();
		gbc_cancelBtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_cancelBtn.insets = new Insets(0, 0, 0, 5);
		gbc_cancelBtn.gridx = 5;
		gbc_cancelBtn.gridy = 1;
		panel_2.add(cancelBtn, gbc_cancelBtn);
	
		
		pack(); 
	}
	
	
	
	

}





package controller;

import model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import tui.*;

public class OrderController 
{
    private CustomerController customerController; 
    private OrderController orderController; 
    private ArrayList<OrderContainer> orderContainer;
    private OrderContainer orderContainers; 
    private ArrayList<Order> orders; 
    private Order order; 
    private OrderLine orderLine; 
    private ArrayList<OrderLine> orderLines;
    private ProductController productController; 
    private TryMe testData; 
    private Order currentOrder; 
    
    /**
     * OrderController Constructor
     * 
     * Initializes the controller by creating instances of:
     * - CustomerController: For managing customer information.
     * - OrderContainer: For storing and retrieving orders.
     * - ProductController: For managing product information.
     * - ArrayLists for order lines and orders: To store order details.
     * - testData: For testing purposes 
     */
    public OrderController() {
        customerController = new CustomerController(); 
      //  orderContainer = new ArrayList<>();
        productController = new ProductController();
        orderLines = new ArrayList<>(); 
        orders = new ArrayList<>(); 
        testData = new TryMe(); 
        
   }
    
    /**
     * Method createOrder
     * Creates a new Order with the given parameters and adds it to the OrderContainer.

     *
     * @param orderNumber The unique identifier for the order.
     * @param discount The discount applied to the order.
     * @param orderType The type of order.
     * @param department The department that processed the order.
     * @param date The date the order was created.
     * @return The newly created Order object.
     */
    public Order createOrder(String orderNumber, String orderType, 
    String department) {
        OrderContainer ordCon = OrderContainer.getInstance(); 
       Order newOrder = new Order(orderNumber, orderType, department); 
        ordCon.addOrder(newOrder); 
        this.currentOrder = newOrder; 
        System.out.println(" Ordre er oprettet");
        return newOrder; 
        
        
   }

    /**
     * Method confirmOrder
     * Confirms an existing Order by setting its status to true.

     *
     * @param orderNumber The unique identifier of the order to confirm.
     * @return True if the order was found and confirmed, false otherwise.
     */
    public boolean confirmOrder(String orderNumber)  {        
        order = this.findOrderByOrderNumber(orderNumber); 
        
        if(order == null) {
            System.out.println(" Ingen ordre er oprettet"); 
            return false; 
        }
        
        order.setStatus(true); 
        
        System.out.println(" Ordre er afsluttet"); 
        return true; 
   }
     
    /**
     * Method confirmOrderAtReception
     * Confirms the current Order by setting its status to true.
     *
     * @return True if the order was found and confirmed, false otherwise.
     */
    public boolean confirmOrderAtReception()  {        
        if(currentOrder == null) {
            System.out.println(" Ingen ordre er oprettet"); 
            return false; 
        }
         
        currentOrder.setStatus(true); 
        
        System.out.println(" Ordre er afsluttet"); 
        return true; 
   }
    
    /**
     * Method addCustomer
     * Adds a Customer to the current Order.
     *
     * @param customerId The unique identifier of the customer to add.
     */
    public void addCustomer(String customerId) { 
        Customer customer = customerController.findCustomerByCustomerId(customerId); 
   }
        
    /**
     * Method addProductToOrder
     * Adds a Product to an Order with the specified quantity.
     *
     * @param orderNumber The unique identifier of the order.
     * @param barcode The barcode of the product to add.
     * @param amount The quantity of the product to add.
     * @return True if the product was added successfully, false otherwise.
     */
    public boolean addProductToOrder(String orderNumber, String barcode, int amount) {
        Order order = this.findOrderByOrderNumber(orderNumber);
        if(order == null) {
        	order = this.currentOrder; 
        }
        if(order == null) {
            System.out.println(" Ordre ikke fundet"); 
            return false; 
        }
        
        Product product = productController.findProductByBarcode(barcode); 
        
        if(product == null) {
            System.out.println(" Produkt ikke fundet."); 
            return false; 
        }
        
        OrderLine orderLine = new OrderLine(amount, product); 
        order.addOrderLine(orderLine); 
        
        
        System.out.println("Product tiføjet til ordre!!"); 
        
        return true;
        
   }
    
    /**
     * Method addCustomerToOrder
     * Adds a Customer to an Order.
     *
     * @param orderNumber The unique identifier of the order.
     * @param customerId The unique identifier of the customer to add.
     * @return True if the customer was added successfully, false otherwise.
     */
    public boolean addCustomerToOrder(String orderNumber, String customerId) {
        Order order = this.findOrderByOrderNumber(orderNumber); 
        System.out.println("Indtast venligst Ordre Nummer: "); 
        if(order == null) {
            System.out.println(" Ordre ikke fundet"); 
            return false; 
        }
        
        Customer customer = customerController.findCustomerByCustomerId(customerId); 
        System.out.println("Indtast venligst Kunde ID: "); 
        if(customer == null) {
            System.out.println(" Kunde ikke fundet"); 
            return false; 
        }        
        
        order.setCustomer(customer); 
        
        return true; 
   }
   
   public Customer findCustomerByCustomerId(String customerId) {
       return customerController.findCustomerByCustomerId(customerId); 
   }
   
   public Product findProductByBarcode(String barcode) {
       return productController.findProductByBarcode(barcode); 
   }
   
   
   public String getProductInfo(String barcode) {
	   
	   Product product = productController.findProductByBarcode(barcode); 
	   if(product != null) {
		  
		   return product.getName() + " " + product.getSalesPrice() + "kr"; 
		   
	   }
	   return "Product ikke fundet!"; 
   }
   
   public String getCustomerInfo(String customerId) {
	   
	   Customer customer = customerController.findCustomerByCustomerId(customerId); 
	   if(customer != null) {
		   
		   return customer.getName() + " er tilføjet til denne ordre";  
	   }
	   return "Kunde ikke fundet!"; 
   }
   
   
   public List<String> getProducts() {
	    List<String> productInfoList = new ArrayList<>(); 
	    Order currentOrder = this.getCurrentOrder();  
	    if(currentOrder != null) {
	    	for (OrderLine orderLine : currentOrder.getOrderLine()) {
	    		Product p = orderLine.getProduct(); 
	    		String productInfo = p.getDescription() + "   " + p.getSalesPrice(); 
	    		productInfoList.add(productInfo); 
	    	}
	    }
	   
	   return productInfoList; 
	   
   }
   
   
   

   
 
    
    /**
     * Method printReceipt
     * Prints a receipt for the current Order.
     *
     * @return The current Order object.
     */
    public Order printReceipt() {
        return order; 
   }
    
    public Order printCurrentReceipt() {
    	return currentOrder; 
    }
    
    /**
     * Method findOrderByOrderNumber
     * Finds an Order by its order number.
     *
     * @param orderNumber The unique identifier of the order to find.
     * @return The found Order, or null if not found.
//     */
//    public static Order findOrderByOrderNumber(String orderNumber) {
//        return OrderContainer.getInstance().findOrderByOrderNumber(orderNumber); 
//   } 
//    THIS IS THE PREVIOUS METHOD!!!
    
    
    public Order findOrderByOrderNumber(String orderNumber) {
    	return OrderContainer.getInstance().findOrderByOrderNumber(orderNumber); 
    }

    /**
     * Method addProductToOrderAtReception
     * Adds a Product to the current Order.
     *
     * @param barcode The barcode of the product to add.
     * @param amount The quantity of the product to add.
     * @return True if the apartment was added successfully, false otherwise.
     */
    public boolean addapartmentLeasingToOrderAtReception(String barcode, int amount) {
    
        
    if(order == null) {
        System.out.println(" Produkt ikke fundet."); 
        return false; 
        }
    
    Product product = apartmentLeasingController.findapartmentLeasingByBarcode(barcode); 
        
    OrderLine orderLine = new OrderLine(amount, product); 
    order.addOrderLine(orderLine); 
    
    System.out.println("Type er tilføjet til ordre!!!"); 
        
    return true;    
   }
   
   //getters
    public Order getOrder() {
           return this.order; 
   }
    
   
    
    public double getTotalPrice() {
    	return order.getTotalPrice(); 
    	}
    
    
    
   
    public Order getCurrentOrder() {
    return currentOrder; 
  
   }
   
 
   //setters
    public void setStatus(boolean status) {
        order.setStatus(status); 
   }
    
 
}
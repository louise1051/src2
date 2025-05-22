package model;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import istraapartment.model.OrderLine;

public class Order
{    
    private String orderNumber; 
    private String orderType; 
    private String department; 
    private double totalPrice; 
    private boolean status; 
    private LocalDate date; 
    private ArrayList <OrderLine> orderLines; 
    private OrderLine orderLine; 
    private Customer customer;
    private List <Product> products; 
    
   
 
    /**
     * Order Constructor
     * This constructor initializes a new `Order` object. 
     *
     * @param orderNumber The unique identifier for the order (String)
     * @param discount The percentage discount applied to the order (int)
     * @param orderType The type of order(e.g. if it's shipped or not) (String)
     * @param department The department responsible for the order (String)
     * @param date The date the order was placed (String)
     */
    public Order(String orderNumber, String orderType, String department) {
        this.orderNumber=orderNumber; 
        this.orderType=orderType; 
        this.department=department; 
        this.totalPrice = 0; 
        this.status=status; 
        this.date= LocalDate.now(); 
        this.orderLines = new ArrayList<>(); 
    }
    
    //getters
    public String getOrderNumber() {
        return orderNumber; 
    }
    
    public ArrayList<String> getProducts() {
     ArrayList<String> productDetails = new ArrayList<>();  
    	
    	for(OrderLine o: orderLines) {
    		Product p = o.getProduct();  
    		
    		String productInfo = p.getDescription() + "        " + p.getSalesPrice(); 
    		productDetails.add(productInfo); 
    	
    	}
    	return productDetails; 
    }

    public String getOrderType() {
        return orderType; 
    }
    
    public String getDepartment() {
        return department; 
    }
    
    public ArrayList<OrderLine> getOrderLine() {
    	return orderLines; 
    }
    
    public double getTotalPrice() {
        double sum = 0; 
        for(OrderLine o : orderLines) {
            sum += o.getPrice();
        }
        return sum; 
    }
    
    public boolean getStatus() {
        return status; 
    }
    
    public LocalDate getDate() {
        return date; 
    }
    
    //setters
    public void setOrderNumber(String orderNumber) {
        this.orderNumber=orderNumber; 
    }
    
    public void setOrderType(String orderType) {
        this.orderType=orderType; 
    }
    
    public void setDepartment(String department) {
        this.department=department; 
    }
    
    public void setStatus(boolean status) {
        this.status=status; 
    }
    
    public void setDate(LocalDate date) {
        this.date=date; 
    }
    
    
    
    /**
     * Method addOrderLine
     * Adds an order line to the order.
     *
     * @param orderLine The order line to add.
     */
    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine); 
    }
    
    /**
     * Method addCustomer
     * Associates a customer with the order.
     *
     * @param customer The customer to associate.
     */
    public void addCustomer(Customer customer) {
        this.customer = customer; 
    }
    
    /**
     * Method displayOrder
     * Displays the details of the order.
     * 
     * @return A string representation of the order details.
     */
//    public String displayOrder() {
//        StringBuilder details = new StringBuilder(); 
//      for(OrderLine orderLine : orderLines){
//           String productInfo = orderLine.printProductInfo();
//            details.append(productInfo).append("\n"); 
//        }
//        return details.toString();
//    
//    }
    
    
    public List<String> displayOrder() {
    	List<String> orderDetails = new ArrayList<>(); 
    	for(OrderLine orderLine : orderLines) {
    		String productInfo = orderLine.printProductInfo(); 
    		orderDetails.add(productInfo); 
    	}
    	return orderDetails; 
    }
    
    
    public List<String> displayProductName() {
    	List<String> orderName = new ArrayList<>(); 
    	for(OrderLine orderLine : orderLines) {
    		String productName = orderLine.getName(); 
    		orderName.add(productName); 
    	}
    	return orderName; 
    }
    
    
    public String productName() {
    	return orderLine.getName(); 
    }
    
    public double getSalesPrice() {
    	return orderLine.getIndividualPrice(); 
    }
    
    /**
     * Method getCustomer
     * Retrieves the customer associated with the order.
     *
     * @return The customer associated with the order.
     */
    public Customer getCustomer() {
        return customer; 
    }
    
    /**
     * Method setCustomer
     * Updates the customer associated with the order
     *
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer=customer; 
    }
 
    
   
}
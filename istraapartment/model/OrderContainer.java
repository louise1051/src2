package model;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * @author (Johan Frejbæk)
 * @version (06-12-2024)
 */
public class OrderContainer
{
    private ArrayList<Order> orders; 
    private static OrderContainer instance; 
    
    /**
     * OrderContainer Constructor
     * Initializes a singleton container for managing orders.
     */
    private OrderContainer()
    {
        orders = new ArrayList<>();
    }
    
    /**
     * Method getInstance
     * Retrieves the singleton instance of OrderContainer.
     * @return The singleton instance of OrderContainer.
     */
    public static OrderContainer getInstance() {
        if(instance == null) {
            instance = new OrderContainer();  
        }
        return instance; 
    }
    
    /**
     * Method addOrder
     * Adds a new order to the container.
     * @param order A parameter
     * @return True if the order was successfully added.
     */
    public boolean addOrder(Order order) {
        return orders.add(order); 
    }
    
    /**
     * Method removeOrder
     * Removes an existing order from the container.
     * @param order The order to remove.
     */
    public void removeOrder(Order order) {
        orders.remove(order);
    }
    
    /**
     * Method getAllOrders
     * Retrieves all orders in the container.
     * @return  A list of all orders.
     */
    public ArrayList<Order> getAllOrders(){
        return new ArrayList<>(orders); 
    }
    
    /**
     * Method createOrder
     * Creates a new order and adds it to the container.
     * 
     * @param newOrderNumber A parameter
     * @param newDiscount A parameter
     * @param newOrderType A parameter
     * @param newDepartment A parameter
     * @param newDate A parameter
     * @return The newly created order object.
     */
    public Order createOrder(String newOrderNumber, String newOrderType, 
    String newDepartment) {
        Order newOrder = new Order(newOrderNumber, newOrderType, newDepartment); 
        orders.add(newOrder); 
        System.out.println("Order created: " + newOrderNumber + newOrderType +
        newDepartment); 
        return newOrder; 
    }
    
    /**
     * Method findOrderByOrderNumber
     * Finds an order by its unique order number.
     *
     * @param orderNumber A parameter
     * @return The order with the matching number, or null if not found.
     */
    public Order findOrderByOrderNumber(String orderNumber) {
        for(Order o : orders) {
            if(o.getOrderNumber().equals(orderNumber)) {
                return o; 
            }
        }
        return null; 
    }
    
     public void clear() {
        orders.clear(); 
    }

}
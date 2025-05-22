package istraapartment;

package controller;
import model.*;

/**
 
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomerController
{
    private CustomerContainer customerContainer; 
    
    public CustomerController() {
    	customerContainer = CustomerContainer.getInstance(); 
    }
    
  
    
    /**
     * Method findCustomerByCustomerId
     * Finds and retrieves a Customer object by its unique customerId.
     * 
     * @param customerId The unique identifier of the customer to be found.
     * @return The Customer object corresponding to the given customerId, 
     * or null if no such customer exists.
     */
    public Customer findCustomerByCustomerId(String customerId) {
        return CustomerContainer.getInstance().findCustomerByCustomerId(customerId); 
    }
   
    /**
     * Method addCustomer
     * Adds a new Customer object to the CustomerContainer.
     * 
     * @param customerId The Customer object to be added.
     */
    public void addCustomer(Customer customerId) {
        customerContainer.addCustomer(customerId); 
    }
    
    /**
     * Method createCustomer
     * Creates a new Customer object with the provided details and returns it.
     *
     * @param name The name of the customer.
     * @param email The email address of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param customerId The unique identifier of the customer.
     * @param address The address of the customer.
     * @param customerCategory The category of the customer (e.g. regular).
     * @return The newly created Customer object.
     */
    public Customer createCustomer(String name, String email, String phoneNumber,
    String customerId, String address, String customerCategory) {
        CustomerContainer custCon = CustomerContainer.getInstance(); 
        Customer c = new Customer(name, email, phoneNumber, customerId, address, 
        customerCategory); 
        return c;
    }
    
    /**
     * Method addCustomerToOrder
     * Associates a Customer with a given Order object using the customer's unique identifier.
     *
     * @param order The Order object to associate the customer with.
     * @param customerId The unique identifier of the customer to be added to the order.
     */
    public void addCustomerToOrder(Order order, String customerId) {
       Customer customer = findCustomerByCustomerId(customerId); 
    }
    
}
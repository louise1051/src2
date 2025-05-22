package model;
import java.util.ArrayList;



public class CustomerContainer
{
    private ArrayList<Customer> customers;
    
    private static CustomerContainer instance;
    
    /**
     * CustomerContainer Constructor
     * Initializes a singleton container for managing customers.
     */
    private CustomerContainer()
    {
        customers = new ArrayList<>();
    }
    
    /**
     * Method getInstance
     * Retrieves the singleton instance of CustomerContainer.
     * @return The singleton instance of CustomerContainer.
     */
    public static CustomerContainer getInstance() {
        if(instance == null) {
            instance = new CustomerContainer();  
        }
        return instance; 
    }
    
    /**
     * Method findCustomerByCustomerId
     * Finds a customer by their unique customer ID.
     * 
     * @param customerId A parameter
     * @return The customer with the matching ID, or null if not found.
     */
    public Customer findCustomerByCustomerId(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    
    /**
     * Method addCustomer
     * Adds a new customer to the container.
     * 
     * @param customer The customer to add.
     */
    public void addCustomer(Customer customer) {
        customers.add(customer); 
    }
    
    /**
     * Method removeCustomer
     * Removes an existing customer from the container.
     * 
     * @param customer The customer to remove.
     */
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
    
    /**
     * Method getAllCustomers
     * Retrieves all customers in the container.
     * @return A list of all customers.
     */
    public ArrayList<Customer> getAllCustomers(){
        return new ArrayList<>(customers); 
    }
    
    /**
     * Method createCustomer
     * Creates a new customer and adds them to the container.
     *
     * @param newName A parameter
     * @param newEmail A parameter
     * @param newPhoneNumber A parameter
     * @param newCustomerId A parameter
     * @param newAddress A parameter
     * @param newStatistic A parameter
     * @param newCustomerCategory A parameter
     * @return The newly created customer object.
     */
    public Customer createCustomer(String newfirstName, String newaddress, String newemail, 
    String newcountry, String newe-mail, String newphoneNumber, String newCheckin, String newNo.ofnight, String newApartmenttype) {
        Customer newCustomer = new Customer(newfirstName, newaddress, newemail, newcountry, newe-mail, newphoneNumber, newCheckin, newNoofnight, newApartmenttype);
        customers.add(newCustomer); 
        System.out.println("Customer created: " + newfirstName + newaddress + newemail + newcountry + newe-mail + newphoneNumber + newCheckin + newNoofnight + newApartmenttype); 
        return newCustomer; 
        
     
    }
    
    /**
     * Method displayCustomer
     * Displays the details of all customers in the container.
     * 
     * @return A string containing customer details.
     */
    public String displayCustomer() {
        StringBuilder details = new StringBuilder(); 
        for(Customer c : customers){
            c.printName(); 
        }
        return details.toString(); 
        
     
    }
    
     public void clear() {
        customers.clear(); 
    }

}
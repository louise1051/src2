package model;


/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables 
	private String name;
    private String email;
    private String phoneNumber;
    private String customerId;
    private String address;
    private String customerCategory;

    
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String name, String email, String phoneNumber, String customerId, String address, String customerCategory)
    {
        // Initialize instance variables with provided values
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.customerId = customerId;
        this.address = address;
        this.customerCategory = customerCategory;
    }

    /**
     * Method printName
     * Prints the customer's name to the console
     */
    public void printName() {
        System.out.println("Navn: " + name); 
    }
    
    //setters
    public void setName(String name){
        this.name = name;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    
    public void setCustomerCategory(String customerCategory){
         this.customerCategory = customerCategory;
    }
    
    //getters
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public String getCustomerId(){
        return customerId;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getCustomerCategory(){
        return customerCategory;
    }
    
}
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.*;

public class LeasingController {

	private CustomerController customerController;
	private ArrayList<LeasingContainer> leasingContainer;
	private ProductController productController;
	private ArrayList<Leasing> leasings;
	private Leasing leasing;
	private static final double DAILY_RATE = 50.0; 
	private static final double WEEKLY_RATE = 300.0;
	private static final double MONTHLY_RATE = 1000.0; 
	
	
	
	public LeasingController() {
		customerController = new CustomerController();
		productController = new ProductController();
		leasings = new ArrayList<>();
	}
	
	public Leasing createLeasing(LocalDate newEndDate, LocalDate newStartDate, String newLeasingNumber, boolean newReturnStatus) {
		Leasing newLeasing = new Leasing(newEndDate, newStartDate, newLeasingNumber, newReturnStatus);
		newLeasing.calculateLeasingPrice(DAILY_RATE, WEEKLY_RATE, MONTHLY_RATE);
		
		leasings.add(newLeasing); 
		System.out.println("Leasing Created " + newEndDate + newStartDate + newLeasingNumber + newReturnStatus); 
		return newLeasing; 
	
	}
	
	public boolean confirmLeasing(String leasingNumber) {
		leasing = this.findLeasingByLeasingNumber(leasingNumber);
		
		if (leasing == null) {
			System.out.println(" Ingen leasing er oprettet ");
			return false;
		
		}
		leasing.setReturnStatus(true);
		
		System.out.println("Leasing er afsluttet");
		return true;
	}
	public Leasing findLeasingByLeasingNumber(String leasingNumber) {
		return LeasingContainer.getInstance().findLeasingByLeasingNumber(leasingNumber);
	}
	
	  public void addCustomer(String customerId) { 
	        Customer customer = customerController.findCustomerByCustomerId(customerId); 
	   }
	  
	  public boolean addProductToLeasing(String leasingNumber, String barcode) {
	        Leasing leasing = this.findLeasingByLeasingNumber(leasingNumber);
	       
	        if(leasing == null) {
	            System.out.println(" Leasing ikke fundet"); 
	            return false; 
	        } 
	        
	        Product product = productController.findProductByBarcode(barcode); 
	        
	        if(product == null) {
	            System.out.println(" Produkt ikke fundet."); 
	            return false; 
	        }
	        return true;
	  }
	  public boolean addCustomerToLeasing(String leasingNumber, String customerId) {
		  Leasing leasing = this.findLeasingByLeasingNumber(leasingNumber);
	        System.out.println("Indtast venligst Leasing Nummer: "); 
	        if(leasing == null) {
	            System.out.println("Leasing ikke fundet"); 
	            return false; 
	        }
	        
	        Customer customer = customerController.findCustomerByCustomerId(customerId); 
	        System.out.println("Indtast venligst Kunde ID: "); 
	        if(customer == null) {
	            System.out.println(" Kunde ikke fundet"); 
	            return false; 
	        }        
	        
	        leasing.setCustomer(customer); 
	        
	        return true;
	  }
	  
	  public Customer findCustomerByCustomerId(String customerId) {
	       return CustomerController.findCustomerByCustomerId(customerId); 
	   }
	   
	   public Product findProductByBarcode(String barcode) {
	       return productController.findProductByBarcode(barcode); 
	   }
	   
	   public Leasing printReceipt() {
	        return leasing;
	   }
	
	  
	   public void setReturnStatus(boolean returnStatus) {
	        leasing.setReturnStatus(returnStatus); 
	   }
	
}

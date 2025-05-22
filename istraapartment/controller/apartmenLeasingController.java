package istraapartment;

package apartmentLeasingcontroller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.*;

public class apartmentLeasingController {

	private CustomerController customerController;
	private ArrayList<LeasingContainer> leasingContainer;
	private Controller apartmentLeasingController;
	private ArrayList<Leasing> leasings;
	private Leasing leasing;
	private Leasing currentLeasing; 
	private static final double DAILY_RATE = 50.0; 
	private static final double WEEKLY_RATE = 300.0;
	
	
	
	
	public LeasingController() {
		customerController = new CustomerController();
		apartmentLeasingController = new apartmentLeasingController();
		leasings = new ArrayList<>();
	}
	
	public Leasing createLeasing(int newDuration, LocalDate newStartDate, String newapartmentLeasingNumber) {
	LeasingContainer leasCon = apartmentLeasingContainer.getInstance(); 
		Leasing newLeasing = new Leasing(newDuration, newStartDate, newLeasingNumber);
		leasCon.addapartmentLeasing(newLeasing); 
		newLeasing.calculateLeasingPrice(DAILY_RATE, WEEKLY_RATE);
		
		leasings.add(newapartmentLeasing); 
		System.out.println("==================================="); 
		System.out.println("Leje periode er oprettet!"); 
		System.out.println("Reservation Nummer: " + newLeasingNumber); 
		System.out.println("Varighed: " + newDuration); 
		System.out.println("Start Dato: " + newStartDate); 
		System.out.println("==================================="); 
		
		return newLeasing; 
	
	}
	
	
	public boolean confirmLeasing(String leasingNumber) {
		leasing = this.findapartmentLeasingByLeasingNumber(leasingNumber);
		
		if (leasing == null) {
			System.out.println(" Ingen reservation er oprettet ");
			return false;
		
		}
		leasing.setReturnStatus(true);
		
		System.out.println("Reservation er hermed afsluttet");
		return true;
	}
	
	
	public Leasing findapartmentLeasingByLeasingNumber(String leasingNumber) {
		return apartmentLeasingContainer.getInstance().findapartmentLeasingByLeasingNumber(leasingNumber);
	}
	
	
	
	  public void addCustomer(String customerId) { 
	        Customer customer = customerController.findCustomerByCustomerId(customerId); 
	   }
	  
	  

	  
	  
	  public boolean addCustomerToLeasing(String leasingNumber, String customerId) {
		  Leasing leasing = this.findLeasingByLeasingNumber(leasingNumber);
	      
		  if(leasing == null) {
			  leasing = this.currentLeasing; 
		  }
		  
		  if(leasing == null) {
	   
	            System.out.println("Leasing ikke fundet med leasing nummeret: " + leasingNumber); 
	            return false; 
	        }
	        
	        Customer customer = customerController.findCustomerByCustomerId(customerId); 
	     //   System.out.println("Indtast venligst Kunde ID: "); 
	        if(customer == null) {
	            System.out.println(" Kunde ikke fundet"); 
	            return false; 
	        }        
	        
	        leasing.setCustomer(customer); 
	        
	        return true;
	  }
	  
	   public boolean addProductToLeasing(String leasingNumber, String barcode) {
		    Leasing leasing = this.findLeasingByLeasingNumber(leasingNumber); 
		    
		    if(leasing == null) {
		    	leasing = this.currentLeasing; 
		    }
		    
		    if(leasing == null) {
		    	System.out.println("Leasing ikke fundet med nummeret: " + leasingNumber); 
		    	return false; 
		    }
	        
		 
		    
		    Product product = productController.findProductByBarcode(barcode); 
		    System.out.println("Scan venligst produktet"); 
		    if(product == null) {
		    	System.out.println(" Produktet ikke fundet"); 
		    	return false; 
		    }
		       
		    
		   leasing.setProduct(product); 

return true;    
}



public Customer findCustomerByCustomerId(String customerId) {
return customerController.findCustomerByCustomerId(customerId); 
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

package model;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Leasing {
	
	private LocalDate endDate; 
	private int duration;  
	private LocalDate startDate; 
	private String leasingNumber; 
	private boolean returnStatus;
	private Customer customer;
	private double leasingPrice;
	private List<apartmentLeasing> apartmentLeasing; 
	private apartmentLeasing apartmentLeasing; 
	
	
	public Leasing(int duration, LocalDate startDate, String leasingNumber) {
		//this.endDate=endDate;
		this.duration=duration; 
		this.startDate = startDate;
		this.leasingNumber = leasingNumber;
		this.returnStatus = returnStatus;
		this.leasingPrice = 0.0;
		this.products= new ArrayList<>(); 
	}
	
	
	public void calculateLeasingPrice(double dailyRate, double weeklyRate, double monthlyRate) {
//        long days = ChronoUnit.DAYS.between(startDate, endDate);

        System.out.println("Start Date: " + startDate);
     //  System.out.println("End Date: " + endDate);
        System.out.println("Antal dage " + duration);
        
        if (duration == 1) {
            leasingPrice = dailyRate;
        } else if (duration == 7) {
            leasingPrice = weeklyRate;
        } else if (duration == 30) {
            leasingPrice = monthlyRate;
        }
    }
	


	 public double getLeasingPrice() {
	        return leasingPrice;
	    }
	


//	public LocalDate getEndDate() {
//		return endDate;
//	}
	 
	 public LocalDate getEndDate() {
		 return startDate.plusDays(duration); 
	 }


	public void setEndDate(LocalDate leasingPeriod) {
		this.endDate = leasingPeriod;
	}
	
	public int getDuration() {
		return duration; 
	}
	
	public void setDuration(int duration) {
		this.duration=duration; 
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public String getLeasingNumber() {
		return leasingNumber;
	}


	public void setLeasingNumber(String leasingNumber) {
		this.leasingNumber = leasingNumber;
	}


	public boolean isReturnStatus() {
		return returnStatus;
	}


	public void setReturnStatus(boolean returnStatus) {
		this.returnStatus = returnStatus;
	}




	public void setCustomer(Customer customer) {
		// TODO Auto-generated method stub
		 this.customer=customer; 
	}
	
public Customer getCustomer() {
	return customer;
}


public void addapartmentLeasing(apartmentLeasing produapartmentLeasing) {
	apartment.add(apartment);
	
}

public apartment getapartmentLeasing() {
	return apartment; 
}

public void setapartmentLeasing(ProdapartmentLeasing prodapartmentLeasing) {
	this.apartmentLeasing = apartmentLeasing; 
}



 
	
	

}
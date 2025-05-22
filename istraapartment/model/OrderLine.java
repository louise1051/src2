package istraapartment.model;

public class OrderLine
{
    private int amount; 
    private Product apartmentLeasing; 
    private Order order; 
    private Product name; 
     

    /**
     * Constructor for objects of class OrderLine
     */
    public OrderLine(int amount, Product product)
    {
        this.amount=amount;  
        this.apartmentLeasing=product; 
    }
    
    /**
     * Method addProduct
     * Adds a product to the current instance.
     * 
     * @param product The product to be added
     */
    public void addProduct(Product product) {
        this.apartmentLeasing = product; 
    }
    
    /**
     * Method setProduct
     * Sets the product for the current instance.
     * 
     * @param product The product to be set.
     */
    public void setProduct(Product product) {
        this.apartmentLeasing=product; 
    }
    
    /**
     * Method setAmount
     * Sets the amount for the current instance.
     * 
     * @param amount The quantity of the product to set.
     */
    public void setAmount(int amount) {
        this.amount=amount;
    }
    
    /**
     * Method getProduct
     * Retrieves the product associated with the current instance.
     * @return The product object
     */
    public Product getProduct() {
        return name; 
    }
    
    public String getName() {
        return apartmentLeasing.getName(); 
    }
    
    
    /**
     * Method getAmount
     * Retrieves the amount associated with the current instance.
     * @return The  quantity of the product.
     */
    public int getAmount() {
        return amount; 
    }
    
    /**
     * Method printInfo
     * Prints information about the product if it exists.
     */
    public void printInfo(){
        if(apartmentLeasing != null){
        	apartmentLeasing.printProductInfo();
        }
    }
    
    /**
     * Method printProductInfo
     * Prints detailed information about the product.
     */
//    public void printProductInfo() {
//         System.out.println("Produkt Navn: " + product.getName()); 
//         System.out.println("Pris: " + getPrice()); 
//     }
    
    public String printProductInfo() {
    	return apartmentLeasing.getName() + "      " + apartmentLeasing.getSalesPrice() + "kr"; 
    }
    
//    public String printProductInfo() {
//    	return product.getName(); 
//    }
    
    
    
    
      
    /**
     * Method getPrice
     * Calculates and retrieves the total price based on the product's sales price and the amount.
     * @return The total price of the product multiplied by the amount.
     */
    public double getPrice() {
           return product.getSalesPrice()*amount; 
      }
    
    public double getIndividualPrice() {
    	return product.getSalesPrice(); 
    }
     


}
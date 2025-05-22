	package tui;
import model.*;

/**
 * Write a description of class TryMe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TryMe
{
    // instance variables - replace the example below with your own
    ProductContainer productContainer; 
    CustomerContainer customerContainer; 
    OrderContainer orderContainer; 

    /**
     * Constructor for objects of class TryMe
     */
    public TryMe()
    {
        productContainer = ProductContainer.getInstance(); 
        customerContainer = CustomerContainer.getInstance();  
        orderContainer = OrderContainer.getInstance(); 
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void generateData() 
    {
        Product tester = new Product("Description", 55, 55, true, "5555", "Hammer", "8489199", "DIY", "Køkken", 26, "365", "8188", 25); 
        OrderLine OlTester = new OrderLine(1, tester);
        productContainer.addProduct(tester); 
        Product productTester = new Product("Description", 40, 40, true, "6666", "Søm", "858585", "DIY", "Stue", 43, "444", "1717", 25); 
        OrderLine OlTester2 = new OrderLine(2, productTester); 
        productContainer.addProduct(productTester); 
         Customer tester1 = new Customer("Bent", "Bent@gmail.com", "12345678", "12345", "vej", "Entreprenør-kunde");
        customerContainer.addCustomer(tester1);
       Order orderTest = new Order("555", "Lokal-bestilling", "DIY");
       orderContainer.addOrder(orderTest); 
       /* String name, String email, String phoneNumber, String customerId, 
        * String address, int statistic, String customerCategory)
        
        
        
        /*String description, int salesPrice, int costPrice,
                int basePrice, boolean status, String barcode, String name, 
                String stockNumber, int salesStatistic, String location, 
                String category, int inventoryQuantity, String productId, String sku 
*/
            }
}

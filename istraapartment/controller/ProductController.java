package controller;
import model.*;

/**
 * Controller class for managing and interacting with Product objects.
 * @author (Jean Paul Mugisha-Kennedy)
 * @version (09-12-2024)
 */
public class ProductController
{
    // instance variables - replace the example below with your own
    private ProductContainer productContainer; 
    private Product products; 

    /**
     * Constructor for objects of class ProductController
     */
    public ProductController() {
        productContainer = ProductContainer.getInstance();
    }
    
    /**
     * Method findProductByProductId
     * Find a product by its ID
     * @param productId A parameter
     * @return The return value
     */
//    public static Product findProductByBarcode(String barcode) {
//        return ProductContainer.getInstance().findProductByBarcode(barcode);
//    } 
    //THIS IS THE OLD METHOD!!!!
    
    
    public Product findProductByBarcode(String barcode) {
    	return ProductContainer.getInstance().findProductByBarcode(barcode); 
    }

    /**
     * Method addProduct
     * Add a new product
     * @param description A parameter
     * @param salesPrice A parameter
     * @param costPrice A parameter
     * @param basePrice A parameter
     * @param status A parameter
     * @param barcode A parameter
     * @param name A parameter
     * @param stockNumber A parameter
     * @param salesStatistic A parameter
     * @param location A parameter
     * @param category A parameter
     * @param inventoryQuantity A parameter
     * @param productId A parameter
     * @param sku A parameter
     */
    public void addProduct(String description, double costPrice,
                           double basePrice, boolean status, String barcode, String name, 
                           String stockNumber, String location, 
                           String category, int inventoryQuantity, String productId, String sku, int discount) {
    
     // Create a new Product object
     Product product = new Product(description, costPrice, basePrice, status, 
                                  barcode, name, stockNumber, 
                                  location, category, inventoryQuantity, productId, sku, discount);

     // Add the new product to the product container
     productContainer.addProduct(product);
    }
    
    public Product printProductInfo() {
         // System.out.println("Produkt Navn: " + products.getName()); 
         // System.out.println("Pris: " + products.getSalesPrice()); 
         return products; 
      }

}
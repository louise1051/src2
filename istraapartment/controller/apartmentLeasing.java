package model;
import java.util.List;
import java.util.ArrayList;


public class ProductContainer
{
    // Singleton instance: Ensures only one instance of the class exists
    private static ProductContainer instance;
    
    // List to store products
    private List<Product> apartment;
    
    /**
     * ProductContainer Constructor
     * Private constructor to prevent direct creation of objects.
     */
    public apartmentLeasingContainer() {
        products = new ArrayList<>();
    }
    
    /**
     * Method getInstance
     * Gets the singleton instance
     * @return The return value
     */
    public static ProductContainer getInstance() {
        if (instance == null) {
            // Create a new instance if it doesn't exist´
            instance = new ProductContainer();
        }
        return instance;
    }
    
    /**
     * Method addProduct
     * Adds a product to the container
     * @param product A parameter
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Method removeProduct
     * Removes a product from the container
     * @param product A parameter
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }
    
    /**
     * Method findProductByProductId
     * Filters products by category
     * @param productId A parameter
     * @return The return value
     */
    public Product findProductByBarcode(String barcode) {
        for (Product product : products) {
            if (product.getBarcode().equals(barcode)) {
                return product;
            }
        }
        return null; // Product not found
    }
    
    /**
     * Method getAllProducts
     * Returns a copy of all products to prevent outside modifications
     * @return The return value
     */
    public List<Product> getAllProducts() {
        return new ArrayList<>(products); 
    }

    /**
     * Method getProductsByCategory
     * Filters products by category, creating a new list to avoid modifying the original
     * @param category A parameter
     * @return The return value
     */
    public List<Product> getProductsByCategory(String category) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
    
    /**
     * Method getProductCount
     * Gets the total number of products in the container
     * @return The return value
     */
    public int getProductCount() {
        return products.size();
    }
    
    /**
     * Method updateProduct
     * Updates an existing product in the container by finding it by ID and replacing it
     * @param updatedProduct A parameter
     */
    public void updateProduct(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(updatedProduct.getProductId())) {
                products.set(i, updatedProduct);
                break;
            }
        }
    }
    
    /**
     * Method isProductAvailable
     * Checks if a product is available by ID and inventory quantity
     * @param productId A parameter
     * @return The return value
     */
    public boolean isProductAvailable(String barcode) {
        Product product = findProductByBarcode(barcode);
        return product != null && product.getInventoryQuantity() > 0;
    }
    
    public void clear() {
        products.clear(); 
    }
}
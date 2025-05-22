package model;

/**
 * Represents a product in the inventory system, storing details like:
 * - Basic information: description, name, barcode, and stock number.
 * - Pricing: sales price, cost price, and base price.
 * - Inventory: quantity and store location.
 * - Status: active or inactive.
 * - Sales data: units sold or total revenue.
 * - Identifiers: product ID and SKU.
 * @author (Jean Paul Mugisha-Kennedy)
 * @version (09-12-2024)
 */
public class Product{
 private String description;
 private double salesPrice;
 private double costPrice;
 private double basePrice;
 private boolean status;
 private String barcode;
 private String name;
 private String stockNumber;
 private String location;
 private String category;
 private int inventoryQuantity;
 private String productId;
 private String sku;
 private int discount; 
    
 
 /**
  * Product Constructor
  * Initializes a new Product object with the given attributes.
  * @param description A parameter
  * @param salesPrice A parameter
  * @param costPrice A parameter
  * @param basePrice A parameter
  * @param status A parameter
  * @param barcode A parameter
  * @param name A parameter
  * @param stockNumber A parameter
  * @param location A parameter
  * @param category A parameter
  * @param inventoryQuantity A parameter
  * @param productId A parameter
  * @param sku A parameter
  */
 public Product(String description, double costPrice,
                double basePrice, boolean status, String barcode, String name, 
                String stockNumber, String location, 
                String category, int inventoryQuantity, String productId, String sku,
                int discount)
{
    this.description = description;
    this.costPrice = costPrice; 
    this.basePrice = basePrice;
    this.status = status;
    this.barcode = barcode;
    this.name = name;
    this.stockNumber = stockNumber;
    this.location = location;
    this.category = category;
    this.inventoryQuantity = inventoryQuantity;
    this. productId = productId;
    this.sku = sku;
    this.discount = discount; 
 }

 //setters
 public void setDescription(String description) {
        this.description = description;
     }

 public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
     }
     
 public void setCostPrice(double costPrice) {
         this.costPrice = costPrice; 
     }

 public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
     }

 public void setStatus(boolean status) {
        this.status = status;
     }

 public void setBarcode(String barcode) {
        this.barcode = barcode;
     }

 public void setName(String name) {
        this.name = name;
     }

 public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
     }


 public void setLocation(String location) {
         this.location = location;
    }
 
 public void setCategory(String category) {
        this.category = category;
     }

 public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
     }

 public void setProductId(String productId) {
         this.productId = productId;
    }

 public void setSku(String sku) {
         this.sku = sku;
    }
    
 public void setDiscount(int discount) {
       this.discount=discount; 
    }

 //getters
 public String getDescription() {
         return description;
    }

 public double getSalesPrice() {
     return costPrice - (costPrice/100) * discount; 
    }
    
public double getCostPrice() {
    return costPrice; 
}

 public double getBasePrice() {
         return basePrice;
    }

 public boolean isStatus() {
        return status;
     }

 public String getBarcode() {
        return barcode;
     }

 public String getName() {
         return name;
    }

 public String getStockNumber() {
         return stockNumber;
    }


 public String getLocation() {
         return location;
    }

 public String getCategory() {
         return category;
    }

 public int getInventoryQuantity() {
         return inventoryQuantity;
    }

 public String getProductId() {
        return productId;
     }

 public String getSku() {
         return sku;
     }
     
 public int getDiscount() {
    return discount; 
    }

 public void printProductInfo() {
         System.out.println("Produkt Navn: " + name); 
         System.out.println("Pris: " + salesPrice); 
      }
}
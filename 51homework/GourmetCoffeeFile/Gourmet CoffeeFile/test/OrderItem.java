
/*
Class OrderItem models an item in an order. 
Instance variables:
 product. This instance variable represents the one-way association between 
OrderItem and Product. It contains a reference to a Product object. 
 quantity. The quantity of the product in the order. 
Constructor and methods:
 public OrderItem(Product initialProduct,
 int initialQuantity)
Constructor that initializes the instance variables product and quantity.
 public Product getProduct(). Returns the value of the instance variable 
product, a reference to a Product object. 
 public int getQuantity(). Returns the value of the instance variable 
quantity. 
 public void setQuantity(int newQuantity). Sets the instance variable 
quantity to the value of parameter newQuantity. 
 public double getValue(). Returns the product of quantity and price. 
 String toString(). Overrides the method toString in the class Object. 
Returns the string representation of an OrderItem object. The String
representation has the following format: 
quantity product-code product-price
The fields are separated by a space. You can assume that the fields themselves do 
not contain any spaces.
 */
public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product initialProduct, int initialQuantity) {
        this.product = initialProduct;
        this.quantity = initialQuantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public double getValue() {
        return this.product.getPrice() * this.quantity;
    }

    @Override
    public String toString() {
        String str = quantity + " " + product.getCode() + " " + product.getPrice();
        return str;
    }

}

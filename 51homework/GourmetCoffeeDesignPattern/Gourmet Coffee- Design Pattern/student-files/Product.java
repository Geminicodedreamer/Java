/*
The class Product models a generic product in the store.
Instance variables:
 code. The unique code that identifies the product 
 description. A short description of the product 
 price. The price of the product 
Constructor and methods:
 public Product(String initialCode,
 String initialDescription,
 double initialPrice)
Constructor that initializes the instance variables code, description, and price.
 public String getCode(). Returns the value of instance variable code. 
 public String getDescription(). Returns the value of instance variable 
description. 
 public double getPrice(). Returns the value of instance variable price. 
 boolean equals(Object object). Overrides the method equals in the class 
Object. Two Product objects are equal if their codes are equal. 
 String toString(). Overrides the method toString in the class Object. 
Returns the string representation of a Product object. The String returned has the 
following format: 
code_description_price
The fields are separated by an underscore ( _ ). You can assume that the fields 
themselves do not contain any underscores.
 */
public class Product {
    private String code;
    private String description;
    private double price;

    public Product(String initialCode, String initialDescription, double initialPrice) {
        this.code = initialCode;
        this.description = initialDescription;
        this.price = initialPrice;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object object) {
        return this.code.equals(object);
    }

    @Override
    public String toString() {
        return new String(code + '_' + description + '_' + price);
    }
}

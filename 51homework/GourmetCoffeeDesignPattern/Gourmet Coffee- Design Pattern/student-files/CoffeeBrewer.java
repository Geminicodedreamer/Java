/*
Class CoffeeBrewer models a coffee brewer. It extends class Product.
Instance variables:
 model. The model of the coffee brewer 
 waterSupply. The water supply (Pour-over or Automatic) 
 numberOfCups. The capacity of the coffee brewer 
Constructor and methods:
 public CoffeeBrewer(String initialCode, 
 String initialDescription, 
 double initialPrice,
 String initialModel,
 String initialWaterSupply,
 int initialNumberOfCups)
Constructor that initializes the instance variables code, description, price, 
model, waterSupply, and numberOfCups.
 public String getModel(). Returns the value of instance variable model. 
 public String getWaterSupply(). Returns the value of instance variable 
waterSupply. 
 public int getNumberOfCups(). Returns the value of instance variable 
numberOfCups. 
 String toString(). Overrides the method toString in the class Object. 
Returns the string representation of a CoffeeBrewer object. The String returned 
has the following format: 
code_description_price_model_waterSupply_numberOfCups
The fields are separated by an underscore ( _ ). You can assume that the fields 
themselves do not contain any underscores.
 */
public class CoffeeBrewer extends Product {
    private String model;
    private String waterSupply;
    private int numberOfCups;

    public CoffeeBrewer(String initialCode, String initialDescription,
            double initialPrice,
            String initialModel,
            String initialWaterSupply,
            int initialNumberOfCups) {
        super(initialCode, initialDescription, initialPrice);
        this.model = initialModel;
        this.waterSupply = initialWaterSupply;
        this.numberOfCups = initialNumberOfCups;
    }

    public String getModel() {
        return this.model;
    }

    public int getNumberOfCups() {
        return this.numberOfCups;
    }

    public String getWaterSupply() {
        return this.waterSupply;
    }

    @Override
    public String toString() {
        return new String(
                this.getCode() + '_' + this.getDescription() + '_' + this.getPrice() + '_' + model + '_' + waterSupply
                        + '_' + numberOfCups);
    }
}

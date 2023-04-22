/*
The class Coffee models a coffee product. It extends class Product.
Instance variables:
 origin. The origin of the coffee 
 roast. The roast of the coffee 
 flavor. The flavor of the coffee 
 aroma. The aroma of the coffee 
 acidity. The acidity of the coffee 
 body. The body of the coffee 
Constructor and methods:
 public Coffee(String initialCode,
 String initialDescription,
 double initialPrice,
 String initialOrigin,
 String initialRoast,
 String initialFlavor,
 String initialAroma,
 String initialAcidity,
 String initialBody)
Constructor that initializes the instance variables code, description, price, 
origin, roast, flavor, aroma, acidity, and body.
 public String getOrigin(). Returns the value of instance variable origin. 
 public String getRoast(). Returns the value of instance variable roast. 
 public String getFlavor(). Returns the value of instance variable flavor. 
 public String getAroma(). Returns the value of instance variable aroma. 
 public String getAcidity(). Returns the value of instance variable acidity. 
 public String getBody(). Returns the value of instance variable body. 
 String toString(). Overrides the method toString in the class Object. 
Returns the string representation of a Coffee object. The String returned has the 
following format: 
code_description_price_origin_roast_flavor_aroma_acidity_body
The fields are separated by an underscore ( _ ). You can assume that the fields 
themselves do not contain any underscores.
 */
public class Coffee extends Product {

    private String origin;
    private String roast;
    private String flavor;
    private String aroma;
    private String acidity;
    private String body;

    public Coffee(String initialCode, String initialDescription, double initialPrice, String initialOrigin,
            String initialRoast, String initialFlavor, String initialAroma, String initialAcidity, String initialBody) {
        super(initialCode, initialDescription, initialPrice);
        this.origin = initialOrigin;
        this.roast = initialRoast;
        this.aroma = initialAroma;
        this.acidity = initialAcidity;
        this.body = initialBody;
        this.flavor = initialFlavor;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getRoast() {
        return this.roast;
    }

    public String getFlavor() {
        return this.flavor;
    }

    public String getAroma() {
        return this.aroma;
    }

    public String getAcidity() {
        return this.acidity;
    }

    public String getBody() {
        return this.body;
    }

    @Override
    public String toString() {
        return new String(this.getCode() + '_' + this.getDescription() + '_' + this.getPrice() + '_' + origin + '_'
                + roast + '_' + flavor + '_'
                + aroma + '_' + acidity + '_' + body);
    }
}

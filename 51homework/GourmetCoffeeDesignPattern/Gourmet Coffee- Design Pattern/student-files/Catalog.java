import java.util.ArrayList;
import java.util.Iterator;

/* 
The class Catalog models a product catalog. This class implements the interface Iterable<Product> to being able to iterate through the products using the for-each loop.
Instance variables:
products — An ArrayList collection that contains references to instances of class Product. 
Constructor and public methods:
public Catalog() — Creates the collection products, which is initially empty. 
public void addProduct(Product product) — Adds the specified product to the collection products. 
public Iterator<Product> iterator() — Returns an iterator over the instances in the collection products. 
public Product getProduct(String code) — Returns a reference to the Product instance with the specified code. Returns null if there are no products in the catalog with the specified code. 
public int getNumberOfProducts() — Returns the number of instances in the collection products. 
*/
public class Catalog implements Iterable<Product> {
    private ArrayList<Product> products;

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public Catalog() {
        products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProduct(String code) {
        for (Product it : products) {
            if (it.getCode().equals(code)) {
                return it;
            }
        }
        return null;
    }

    public int getNumberOfProducts() {
        return products.size();
    }

}

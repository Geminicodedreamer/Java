import java.util.ArrayList;
import java.util.Iterator;

/*
The class Sales maintains a list of the orders that have been completed. This class implements the interface Iterable<Order> to being able to iterate through the orders using the for-each loop.
Instance variables:
orders — An ArrayList collection that contains references to instances of class Order. 
Constructor and public methods:
public Sales() — Creates the collection orders, which is initially empty. 
public void addOrder(Order order) — Adds the specified order to the collection orders. 
 — Returns an iterator over the instances in the collection orders. 
public int getNumberOfOrders() — Returns the number of instances in the collection orders. 
 */
public class Sales implements Iterable<Order> {
    private ArrayList<Order> orders;

    public Sales() {
        orders = new ArrayList<Order>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Iterator<Order> iterator() {
        return orders.iterator();
    }

    public int getNumberOfOrders() {
        return orders.size();
    }
}

import java.util.ArrayList;
import java.util.Iterator;

/*
The class Order maintains a list of order items. This class implements the interface Iterable<OrderItem> to being able to iterate through the items using the for-each loop.
Instance variables:
items — An ArrayList collection that contains references to instances of class OrderItem. 
Constructor and public methods:
public Order() — Creates the collection items, which is initially empty. 
public void addItem(OrderItem orderItem) — Adds the specified order item to the collection items. 
public void removeItem(OrderItem orderItem) — Removes the specified order item from the collection items. 
public Iterator<OrderItem> iterator() — Returns an iterator over the instances in the collection items. 
public OrderItem getItem(Product product) — Returns a reference to the OrderItem instance with the specified product. Returns null if there are no items in the order with the specified product. 
public int getNumberOfItems() — Returns the number of instances in the collection items. 
public double getTotalCost() — Returns the total cost of the order. 
 */
public class Order implements Iterable<OrderItem> {
    private ArrayList<OrderItem> items;

    public Order() {
        items = new ArrayList<OrderItem>();
    }

    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        items.remove(orderItem);
    }

    public Iterator<OrderItem> iterator() {
        return items.iterator();
    }

    public OrderItem getItem(Product product) {
        for (OrderItem it : items) {
            if (it.getProduct().equals(product)) {
                return it;
            }
        }
        return null;
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public double getTotalCost() {
        double res = 0.0;
        for (OrderItem it : items) {
            res += it.getValue();
        }
        return res;
    }

}

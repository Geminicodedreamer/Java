public class PlainTextSalesFormatter implements SalesFormatter {
    private static PlainTextSalesFormatter singletonInstance = new PlainTextSalesFormatter();

    private PlainTextSalesFormatter() {
    }

    public static PlainTextSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    public String formatSales(Sales sales) {
        StringBuilder sb = new StringBuilder();
        int orderNumber = 1;
        for (Order order : sales) {
            sb.append("------------------------\n");
            sb.append("Order ").append(orderNumber).append("\n\n");
            for (OrderItem item : order) {
                sb.append(item.getQuantity()).append(" ");
                sb.append(item.getProduct().getCode()).append(" ");
                sb.append(item.getProduct().getPrice()).append("\n");
            }
            sb.append("\nTotal = ").append(order.getTotalCost()).append("\n");
            orderNumber++;
        }
        return sb.toString();
    }
}

public class XMLSalesFormatter implements SalesFormatter {
    private static XMLSalesFormatter singletonInstance = new XMLSalesFormatter();

    private XMLSalesFormatter() {
    }

    public static XMLSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    public String formatSales(Sales sales) {
        StringBuilder sb = new StringBuilder();
        sb.append("<Sales>\n");
        for (Order order : sales) {
            sb.append("  <Order total=\"").append(order.getTotalCost()).append("\">\n");
            for (OrderItem item : order) {
                sb.append("    <OrderItem quantity=\"").append(item.getQuantity())
                        .append("\" price=\"").append(item.getProduct().getPrice())
                        .append("\">").append(item.getProduct().getCode()).append("</OrderItem>\n");
            }
            sb.append("  </Order>\n");
        }
        sb.append("</Sales>");
        return sb.toString();
    }
}

public class HTMLSalesFormatter implements SalesFormatter {
    private static HTMLSalesFormatter singletonInstance = new HTMLSalesFormatter();

    private HTMLSalesFormatter() {}

    public static HTMLSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    public String formatSales(Sales sales) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>\n");
        sb.append("  <body>\n");
        sb.append("    <center><h2>Orders</h2></center>\n");

        for (Order order : sales) {
            sb.append("    <hr>\n");
            sb.append("    <h4>Total = " + order.getTotalCost() + "</h4>\n");

            for (OrderItem item : order) {
                sb.append("    <p>\n");
                sb.append("      <b>code:</b> " + item.getProduct().getCode() + "<br>\n");
                sb.append("      <b>quantity:</b> " + item.getQuantity() + "<br>\n");
                sb.append("      <b>price:</b> " + item.getProduct().getPrice() + "\n");
                sb.append("    </p>\n");
            }
        }

        sb.append("  </body>\n");
        sb.append("</html>\n");

        return sb.toString();
    }
}

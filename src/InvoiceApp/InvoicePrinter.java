package InvoiceApp;

public class InvoicePrinter {

    public static String printInvoice(Invoice invoice) {
        StringBuilder invoiceText = new StringBuilder();
        
        // Header
        invoiceText.append(String.format("%35s\n", "Invoice"));
        invoiceText.append("---------------------------------------------------------\n");
        invoiceText.append(String.format("%-30s %5s %10s %10s\n", "ITEM", "QTY", "PRICE", "TOTAL"));
        invoiceText.append("---------------------------------------------------------\n");

        // Line items
        for (LineItem item : invoice.getLineItems()) {
            String itemName = item.getProduct().getName();
            int qty = item.getQuantity();
            double price = item.getProduct().getUnitPrice();
            double lineTotal = item.calculateLineTotal();

            // Format each line item with alignment
            invoiceText.append(String.format("%-30s %5d %10.2f %10.2f\n", itemName, qty, price, lineTotal));
        }

        invoiceText.append("---------------------------------------------------------\n");

        // Subtotal
        double subtotal = invoice.calculateTotalAmount();
        invoiceText.append(String.format("SUBTOTAL: %40.2f\n", subtotal));

        return invoiceText.toString();
    }
}

package InvoiceApp;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private List<LineItem> lineItems;

    public Invoice() {
        lineItems = new ArrayList<>();
    }

    // add line item to the invoice
    public void addLineItem(LineItem item) {
        lineItems.add(item);
    }

    //retrieve the list of line items
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    //calculate the total amount due
    public double calculateTotalAmount() {
        double total = 0;
        for (LineItem item : lineItems) {
            total += item.calculateLineTotal();
        }
        return total;
    }
}

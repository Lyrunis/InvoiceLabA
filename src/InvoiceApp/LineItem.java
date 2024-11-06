package InvoiceApp;

public class LineItem {
    private int quantity;
    private Product product;

    public LineItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Getter for product
    public Product getProduct() {
        return product;
    }

    // Method to calculate the total price for this line item
    public double calculateLineTotal() {
        return quantity * product.getUnitPrice();
    }
}

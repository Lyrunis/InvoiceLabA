package InvoiceApp;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvoiceApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Invoice Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            // Main Panel and Input
            JPanel panel = new JPanel(new GridLayout(4, 2));
            JTextField productNameField = new JTextField();
            JTextField unitPriceField = new JTextField();
            JTextField quantityField = new JTextField();
            JTextArea invoiceDisplayArea = new JTextArea();
            invoiceDisplayArea.setEditable(false);

            // Labels
            panel.add(new JLabel("Product Name:"));
            panel.add(productNameField);
            panel.add(new JLabel("Unit Price:"));
            panel.add(unitPriceField);
            panel.add(new JLabel("Quantity:"));
            panel.add(quantityField);

            // Calculate
            JButton addButton = new JButton("Add Line Item");
            panel.add(addButton);

            frame.add(panel, BorderLayout.NORTH);
            frame.add(new JScrollPane(invoiceDisplayArea), BorderLayout.CENTER);

            // Create invoice object
            Invoice invoice = new Invoice();

            // Add line item button
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String productName = productNameField.getText();
                        double unitPrice = Double.parseDouble(unitPriceField.getText());
                        int quantity = Integer.parseInt(quantityField.getText());

                        Product product = new Product(productName, unitPrice);
                        LineItem lineItem = new LineItem(quantity, product);
                        invoice.addLineItem(lineItem);

                        // Clear the input fields after button press
                        productNameField.setText("");
                        unitPriceField.setText("");
                        quantityField.setText("");

                        // Invoice printer call
                        String invoiceText = InvoicePrinter.printInvoice(invoice);
                        invoiceDisplayArea.setText(invoiceText);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter valid values.",
                                                      "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            frame.setVisible(true);
        });
    }
}

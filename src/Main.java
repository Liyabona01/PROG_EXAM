import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

    public class Main extends JFrame {

        JTextField txtCustomerName;
        JTextField txtPrice;
        JComboBox<String> cmbProduct;
        JButton btnProcess;

        public Main() {

            setTitle("Product App");
            setSize(500, 350);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

// Create menu bar
            JMenuBar menuBar = new JMenuBar();

            JMenu fileMenu = new JMenu("File");
            JMenu toolsMenu = new JMenu("Tools");

            JMenuItem exitItem = new JMenuItem("Exit");
            JMenuItem processItem = new JMenuItem("Process");
            JMenuItem clearItem = new JMenuItem("Clear");

            fileMenu.add(exitItem);
            toolsMenu.add(processItem);
            toolsMenu.add(clearItem);

            menuBar.add(fileMenu);
            menuBar.add(toolsMenu);

            setJMenuBar(menuBar);

// Create input components
            txtCustomerName = new JTextField();
            txtPrice = new JTextField();

            String[] products = {
                    "Cozy Nights Monarch",
                    "Restonic Barbados",
                    "Sealy Phuket"
            };

            cmbProduct = new JComboBox<>(products);

            btnProcess = new JButton("PROCESS");

// Create form
            JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));

            panel.setBorder(
                    BorderFactory.createEmptyBorder(30, 30, 30, 30)
            );

            panel.add(new JLabel("Customer Name:"));
            panel.add(txtCustomerName);

            panel.add(new JLabel("Select Product:"));
            panel.add(cmbProduct);

            panel.add(new JLabel("Enter Price:"));
            panel.add(txtPrice);

            panel.add(new JLabel(""));
            panel.add(btnProcess);

            add(panel, BorderLayout.CENTER);

// Button action
            btnProcess.addActionListener(e -> processSale());

// Menu actions
            processItem.addActionListener(e -> processSale());

            clearItem.addActionListener(e -> clearFields());

            exitItem.addActionListener(e -> System.exit(0));

            setLocationRelativeTo(null);
            setVisible(true);
        }

        // Main method
        public static void main(String[] args) {
            new Main();
        }

        // Process sale method
        public void processSale() {

            try {

                String customer = txtCustomerName.getText();

                String product = cmbProduct.getSelectedItem().toString();

                double price = Double.parseDouble(txtPrice.getText());

                if (customer.trim().isEmpty() || price <= 0) {
                    JOptionPane.showMessageDialog(this,
                            "Enter a valid customer name and price.");
                    return;
                }

                ProductCalculations calculation =
                        new ProductCalculations(price);

                double vat = calculation.GetVat();

                double commission = calculation.GetCommission();

                double total = calculation.GetTotal();

                String message =
                        "Customer Name: " + customer +
                                "\nProduct: " + product +
                                "\nVAT: R " + vat +
                                "\nCOMMISSION: R " + commission +
                                "\nTOTAL: R " + total;

                JOptionPane.showMessageDialog(this, message);

// Save information to file
                FileWriter writer = new FileWriter("data.txt", true);

                writer.write("DATA LOG\n");
                writer.write("********************************\n");
                writer.write("Customer Name: " + customer + "\n");
                writer.write("Product: " + product + "\n");
                writer.write("VAT: R " + vat + "\n");
                writer.write("COMMISSION: R " + commission + "\n");
                writer.write("TOTAL: R " + total + "\n");
                writer.write("********************************\n\n");

                writer.close();

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(this,
                        "Please enter a valid price.");

            } catch (IOException e) {

                JOptionPane.showMessageDialog(this,
                        "Error saving data to file.");

            }
        }

        // Clear method
        public void clearFields() {

            txtCustomerName.setText("");

            txtPrice.setText("");

            cmbProduct.setSelectedIndex(0);
        }
    }


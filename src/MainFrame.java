
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

    private final Font mainFont = new Font("Segoe Print", Font.BOLD, 18);
    private JTextField tfFirstName, tfLastName;
    private JLabel lbWelcome;

    public MainFrame() {
        setUndecorated(true);
        initialize();
    }

    private void initialize() {
        setLookAndFeel();

        // Form Panel
        JPanel formPanel = createFormPanel();

        // Welcome Label
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);
        lbWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lbWelcome.setForeground(Color.WHITE);
        lbWelcome.setBorder(new EmptyBorder(10, 0, 10, 0)); // Add some spacing

        // Buttons Panel
        JPanel buttonsPanel = createButtonsPanel();

        // Main Panel Setup
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(17, 18, 22)); // Blue background
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15)); // Add padding around the main panel
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Welcome");
        setSize(500, 600);
        setMinimumSize(new Dimension(800, 800));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    private JPanel createFormPanel() {
        JLabel lbFirstName = new JLabel("First Name");
        lbFirstName.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Last Name");
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName);
        formPanel.add(lbLastName);
        formPanel.add(tfLastName);

        return formPanel;
    }

    private JPanel createButtonsPanel() {
        JButton btnOK = new JButton("OK");
        btnOK.setFont(mainFont);
        btnOK.setForeground(Color.BLACK); // Use black for the text color for better visibility
        btnOK.setFocusPainted(false);
        btnOK.setContentAreaFilled(true); // Ensure content area is filled
        btnOK.addActionListener(this::handleOkButton);

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.setForeground(Color.BLACK); // Use black for the text color for better visibility
        btnClear.setFocusPainted(false);
        btnClear.setContentAreaFilled(true); // Ensure content area is filled
        btnClear.addActionListener(e -> clearForm());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnClear);

        return buttonsPanel;
    }

    private void handleOkButton(ActionEvent e) {
        String firstName = tfFirstName.getText().trim();
        String lastName = tfLastName.getText().trim();

        if (firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both First Name and Last Name.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } else {
            lbWelcome.setText("Hello, " + firstName + " " + lastName + "!");
        }
    }

    private void clearForm() {
        tfFirstName.setText("");
        tfLastName.setText("");
        lbWelcome.setText("");
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Failed to set Look and Feel: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

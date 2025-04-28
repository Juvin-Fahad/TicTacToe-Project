import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class RegisterForm extends JFrame {
    JTextField nameField, genderField, ageField, emailField;
    JPasswordField passwordField;
    JButton registerButton;

    public RegisterForm() {
        setTitle("Register");
        setSize(300, 300);
        setLayout(new GridLayout(6, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Gender:"));
        genderField = new JTextField();
        add(genderField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        registerButton = new JButton("Register");
        add(new JLabel()); // Empty cell
        add(registerButton);

        registerButton.addActionListener(e -> registerUser());

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void registerUser() {
        String name = nameField.getText();
        String gender = genderField.getText();
        String ageText = ageField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty() || gender.isEmpty() || ageText.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a number!");
            return;
        }

        try (Connection conn = Dbconnection.getConnection()) {
            String sql = "INSERT INTO info (Name, Gender, Age, Email, Password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, gender);
            stmt.setInt(3, age);
            stmt.setString(4, email);
            stmt.setString(5, password);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration Successful!");

            dispose();
            SwingUtilities.invokeLater(() -> new TicTacToeGUI());

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while registering!");
        }
    }
}

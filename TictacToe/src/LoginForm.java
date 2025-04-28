import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LoginForm extends JFrame {
    JTextField emailField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginForm() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Login");
        add(new JLabel()); // Empty cell
        add(loginButton);

        loginButton.addActionListener(e -> loginUser());

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void loginUser() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email and Password are required!");
            return;
        }

        try (Connection conn = Dbconnection.getConnection()) {
            String sql = "SELECT * FROM info WHERE Email = ? AND Password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome " + rs.getString("name"));
                dispose();
                SwingUtilities.invokeLater(() -> new TicTacToeGUI());
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while logging in!");
        }
    }
}

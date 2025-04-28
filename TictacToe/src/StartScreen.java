import javax.swing.*;
import java.awt.*;

public class StartScreen extends JFrame {
    JButton loginButton, registerButton;
    public StartScreen() {
        setTitle("Welcome");
        setSize(300, 150);
        setLayout(new GridLayout(2, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        loginButton.addActionListener(e -> {
            dispose(); // Close start screen
            SwingUtilities.invokeLater(() -> new LoginForm());
        });
        registerButton.addActionListener(e -> {
            dispose(); // Close start screen
            SwingUtilities.invokeLater(() -> new RegisterForm());
        });

        add(loginButton);
        add(registerButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new StartScreen());
    }
}

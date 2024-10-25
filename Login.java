package dao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel username, password;
    JTextField userTextField;
    JPasswordField passwordTextField; // Use JPasswordField for password input
    JButton loginButton, cancelButton;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Login_Page");
        setLocation(500, 200);

        // Load image
        try {
            ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("dao/login_image.jpg"));
            Image i3 = i2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i4 = new ImageIcon(i3);
            JLabel label = new JLabel(i4);
            label.setBounds(210, 30, 100, 100);
            add(label);
        } catch (Exception e) {
            System.out.println("Image could not be loaded. Please check the path.");
            e.printStackTrace();
        }

        username = new JLabel("UserName:");
        username.setBounds(50, 150, 200, 20);
        username.setFont(new Font("Railways", Font.CENTER_BASELINE, 15));
        add(username);

        userTextField = new JTextField();
        userTextField.setBounds(170, 150, 200, 25);
        userTextField.setFont(new Font("RALEWAY", Font.CENTER_BASELINE, 20));
        add(userTextField);

        password = new JLabel("Password:");
        password.setBounds(50, 200, 200, 20);
        password.setFont(new Font("Railways", Font.CENTER_BASELINE, 15));
        add(password);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(170, 200, 200, 25);
        passwordTextField.setFont(new Font("RALEWAY", Font.CENTER_BASELINE, 20));
        add(passwordTextField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 250, 120, 30);
        loginButton.setFont(new Font("RALEWAY", Font.BOLD, 15));
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 250, 120, 30);
        cancelButton.setFont(new Font("RALEWAY", Font.BOLD, 15));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setSize(600, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            String username = userTextField.getText();
            String password = new String(passwordTextField.getPassword()); // Extract password securely
            String query = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'";
            try {
                Conn con = new Conn();
                ResultSet rs = con.st.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new EmployeeForm().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancelButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

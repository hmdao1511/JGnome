import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewAccount implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Go back to Login");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel registerLabel = new JLabel("Register an account");
    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel message = new JLabel();

    HashMap<String, String> loginInfoDatabase = new HashMap<>();

    NewAccount(HashMap<String, String> loginInfo) {
        // Toolkit + Dimension for retrieving the screen size
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = t.getScreenSize();

        this.loginInfoDatabase = loginInfo;

        registerLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
        registerLabel.setBounds(140, 20, 250, 30);
        usernameLabel.setBounds(50, 70, 75, 25);
        passwordLabel.setBounds(50, 120, 75, 25);

        message.setBounds(80, 220, 400, 35);
        message.setFont(new Font("Times New Roman", Font.ITALIC, 25));

        usernameField.setBounds(125, 70, 250, 25);
        passwordField.setBounds(125, 120, 250, 25);

        registerButton.setBounds(50, 150, 100, 30);
        resetButton.setBounds(155, 150, 100, 30);
        backButton.setBounds(260, 150, 160, 30);
        registerButton.setFocusable(false);
        resetButton.setFocusable(false);
        backButton.setFocusable(false);
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        backButton.addActionListener(this);

        frame.add(registerLabel);
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(message);
        frame.add(usernameField);
        frame.add(passwordField);
        frame.add(registerButton);
        frame.add(resetButton);
        frame.add(backButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("JGnome Launcher");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocation(new Point(3 * (screenSize.width / 8), 3 * (screenSize.height / 8)));
        frame.setSize(screenSize.width / 4, screenSize.height / 4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton) {
            usernameField.setText("");
            passwordField.setText("");
        }

        if(e.getSource() == registerButton) {
            String userInput = usernameField.getText();
            String passwordInput = String.valueOf(passwordField.getPassword());
            if(loginInfoDatabase.containsKey(userInput)) {
                message.setForeground(Color.RED);
                message.setText("This username already exists");
            } else if(userInput.equals("") || passwordInput.equals("")) {
                message.setForeground(Color.RED);
                message.setText("Username or Password is empty!");
            } else {
                message.setForeground(Color.GREEN);
                message.setText("Created an account");
                usernameField.setText("");
                passwordField.setText("");
                UserCredentials retrieveUsers = new UserCredentials();
                retrieveUsers.addUser(userInput, passwordInput);
            }
        }

        if(e.getSource() == backButton) {
            frame.dispose();
            UserCredentials userCredentials = new UserCredentials();
            Login login = new Login(userCredentials.getLoginInfo());
        }
        
    }
}

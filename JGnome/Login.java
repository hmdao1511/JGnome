import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.util.HashMap;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton createAccountButton = new JButton("Create a new account");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel loginLabel = new JLabel("Login to JGnome");
    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel message = new JLabel();
    
    // Tester var (please delete after finishing testing)
    JButton tester = new JButton("Test");

    HashMap<String, String> loginInfoDatabase = new HashMap<>();

    Login(HashMap<String, String> loginInfoOriginal) {
        // Toolkit + Dimension for retrieving the screen size
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = t.getScreenSize();

        this.loginInfoDatabase = loginInfoOriginal;
        System.out.println(loginInfoDatabase);

        loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
        loginLabel.setBounds(140, 20, 250, 30);
        usernameLabel.setBounds(50, 70, 75, 25);
        passwordLabel.setBounds(50, 120, 75, 25);

        message.setBounds(80, 220, 400, 35);
        message.setFont(new Font("Times New Roman", Font.ITALIC, 25));

        usernameField.setBounds(125, 70, 250, 25);
        passwordField.setBounds(125, 120, 250, 25);

        loginButton.setBounds(50, 150, 100, 30);
        resetButton.setBounds(155, 150, 100, 30);
        createAccountButton.setBounds(260, 150, 160, 30);
        loginButton.setFocusable(false);
        resetButton.setFocusable(false);
        createAccountButton.setFocusable(false);
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        createAccountButton.addActionListener(this);
        
        // Tester block (please delete after finishing testing)
        tester.setBounds(50, 192, 100, 30);
        tester.setFocusable(false);
        tester.addActionListener(this);

        frame.add(loginLabel);
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(message);
        frame.add(usernameField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(createAccountButton);
        // Delete this line below if you finished testing
        frame.add(tester);

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

        if(e.getSource() == loginButton) {
            String usernameInput = usernameField.getText();
            String passwordInput = String.valueOf(passwordField.getPassword());

            if(loginInfoDatabase.containsKey(usernameInput) && loginInfoDatabase.get(usernameInput).equals(passwordInput)) {
                frame.dispose();
                MainUserPage mainUserPage = new MainUserPage(usernameInput);
            } else {
                message.setForeground(Color.RED);
                message.setText("Incorrect Username or Password!");
            }
        }

        if (e.getSource() == createAccountButton) {
            frame.dispose();
            NewAccount newAccount = new NewAccount(loginInfoDatabase);
        }
        
        // Tester block (please delete after finishing testing)
        if(e.getSource() == tester) {
        	frame.dispose();
        	MainUserPage mainUserPage = new MainUserPage("test");
        }
    }
}

package JGnomePackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class MainUserPage implements ActionListener {

    private int count = 0;
    String nameUser = "";
    JButton clickMeButton;
    JButton logOutButton;
    JButton guessTheNumberGameButton;
    JFrame frame = new JFrame();
    JLabel welcomeMessage = new JLabel();

    MainUserPage(String username) {
        // Toolkit + Dimension for retrieving the screen size
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = t.getScreenSize();
        
        this.nameUser = username;

        welcomeMessage.setBounds((screenSize.width / 4) + 30, (screenSize.height / 4) - 250, 200, 40);
        welcomeMessage.setText("Welcome " + username);
        welcomeMessage.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Click me Button
        clickMeButton = new JButton();
        clickMeButton.setBounds((screenSize.width / 4) + 100, (screenSize.height / 4) - 100, 200, 100);
        clickMeButton.setText("Click me!");
        clickMeButton.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        clickMeButton.setFocusable(false);
        
        // Log out button
        logOutButton = new JButton();
        logOutButton.setBounds((screenSize.width / 4) + 100, (screenSize.height / 4) + 30, 200, 50);
        logOutButton.setText("Log Out");
        logOutButton.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        logOutButton.setFocusable(false);
        logOutButton.addActionListener(this);
        
        // Guess The Number Game button
        guessTheNumberGameButton = new JButton();
        guessTheNumberGameButton.setBounds((screenSize.width / 4) + 100, (screenSize.height / 4) + 100, 200, 50);
        guessTheNumberGameButton.setText("Guess The Number!");
        guessTheNumberGameButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        guessTheNumberGameButton.setFocusable(false);
        guessTheNumberGameButton.addActionListener(this);

        // Create Border for the application and the thickness of the border
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
        // For adding an image to the frame as a label
        ImageIcon image = new ImageIcon("random.png");

        // Label items for the frame
        JLabel label = new JLabel();
        // Text label
        label.setText("JGnome");
        // Image label (from above)
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT/CENTER/RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.BOTTOM); // set text TOP/CENTER/BOTTOM of imageicon
        label.setForeground(Color.WHITE); // sets the text color of the label
        label.setFont(new Font("MV Boli", Font.PLAIN, 40)); // sets font of text and font size
        label.setBackground(new Color(123, 50, 250)); // sets background color (not displayed yet)
        label.setOpaque(true); // display the background color
        label.setBorder(border); // display the border created above
        label.setHorizontalAlignment(JLabel.CENTER); // sets horizontal position of imageicon
        label.setVerticalAlignment(JLabel.CENTER); // sets vertical position of imageicon
        label.setBounds(0, 0, 500, screenSize.height / 2);

        // This is an anonymous function for the clickMeButton just for fun! But I would
        // personally stick to the actionPerformed method at the end of the class...
        clickMeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                label.setText("JGnome clicked: " + count);
            }
        });

        frame.add(welcomeMessage);
        frame.add(label);
        frame.add(clickMeButton);
        frame.add(logOutButton);
        frame.add(guessTheNumberGameButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("JGnome Launcher");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocation(new Point(screenSize.width / 4, screenSize.height / 4));
        frame.setSize(screenSize.width / 2, screenSize.height / 2);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logOutButton) {
			frame.dispose();
			UserCredentials retrieveUserDatabase = new UserCredentials();
			Login loginPopUp = new Login(retrieveUserDatabase.getLoginInfo());
			loginPopUp.message.setText("Logged out");
			loginPopUp.message.setForeground(Color.GREEN);
		}
		
		if(e.getSource() == guessTheNumberGameButton) {
			frame.dispose();
			GuessTheNumberGame gamePopUp = new GuessTheNumberGame(nameUser);
		}
		
	}
}

package JGnomePackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import aanubis.*;

public class GuessTheNumberGame implements ActionListener {
	String username = "";
	JFrame frame = new JFrame();
	JLabel title = new JLabel("Guess The Number!");
	JLabel message = new JLabel("Enter the maximum number:");
	JTextField userInput = new JTextField();
	JButton submit = new JButton("Submit");
	JButton reload = new JButton("Retry");
	JButton backButton = new JButton("Main menu");
	JButton logOutButton = new JButton("Log Out");
	
	String guess = "";
	String max = "";
    int counter = 0;
    int numberGuess = 0;
    int target = 0;
	GuessTheNumberGame(String username) {
		this.username = username;
		counter = 0;
		
		// Toolkit + Dimension for retrieving the screen size
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = t.getScreenSize();
        
        // Title
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setBounds((screenSize.width / 4) - 200, (screenSize.height / 4) - 250, 300, 40);
        
        // Message
        message.setFont(new Font("Times New Roman", Font.BOLD, 20));
        message.setBounds((screenSize.width / 4) - 430, (screenSize.height / 4) - 180, 700, 40);
        
        // Text field for taking user input
        userInput.setBounds((screenSize.width / 4) - 430, (screenSize.height / 4) - 120, 300, 40);
        
        // Submit button
        submit.setBounds((screenSize.width / 4) - 430, (screenSize.height / 4) - 75, 200, 50);
        submit.setText("Submit");
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        submit.setFocusable(false);
        submit.addActionListener(this);
        
        // Retry button
        reload.setBounds((screenSize.width / 4), (screenSize.height / 4) - 75, 200, 50);
        reload.setText("Retry");
        reload.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        reload.setFocusable(false);
        reload.addActionListener(this);
        
        // Main Menu button
        backButton.setBounds((screenSize.width / 4), (screenSize.height / 4), 200, 50);
        backButton.setText("Main Menu");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        
        // Log Out button
        logOutButton.setBounds((screenSize.width / 4), (screenSize.height / 4) + 75, 200, 50);
        logOutButton.setText("Submit");
        logOutButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        logOutButton.setFocusable(false);
        logOutButton.addActionListener(this);
        
		
        frame.add(title);
        frame.add(message);
        frame.add(userInput);
        frame.add(submit);
        frame.add(reload);
        frame.add(backButton);
        frame.add(logOutButton);
		
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
		if(e.getSource() == submit) {
			// ........ core of game will be in here .....................
			if(counter == 0) {
				String max = userInput.getText();
				if (!Amath.isNum(max) || (int) Double.parseDouble(max) < 10 || !Amath.isInt(max)) {
					message.setText("Enter a valid number! Maximum number must be larger than 9 !");
				} else {
					counter++;
					message.setText("Enter your first guess!");
					target = (int) Math.floor(Math.random() * Integer.parseInt(max)) + 1;
	                System.out.println(target);
				}
				
			} else {
				numberGuess++;
                guess = userInput.getText();
                if(!Amath.isNum(guess)) {
                	message.setText("Not a valid number! Enter your guess again! No. of guesses made: " + numberGuess);
                } else if (Amath.isInt(guess)) {
                	if(Integer.parseInt(guess) > target) {
                		message.setText("Too high! Enter your guess again! No. of guesses made: " + numberGuess);
                	} else if(Integer.parseInt(guess) < target) {
                		message.setText("Too low! Enter your guess again! No. of guesses made: " + numberGuess);
                	} else {
                		message.setText("You won! The number is indeed " + target + "! You've made " + numberGuess + " guesses.");
                		submit.setVisible(false);
                	}
                }
			}
			userInput.setText("");
			
		}
		
		if(e.getSource() == reload) {
			frame.dispose();
			GuessTheNumberGame newGame = new GuessTheNumberGame(username);
		}
		
		if(e.getSource() == backButton) {
			frame.dispose();
			MainUserPage userPage = new MainUserPage(username);
		} 
		 
		if(e.getSource() == logOutButton) {
			frame.dispose();
			UserCredentials retrieveUserDatabase = new UserCredentials();
			Login loginPopUp = new Login(retrieveUserDatabase.getLoginInfo());
			loginPopUp.message.setText("Logged out");
			loginPopUp.message.setForeground(Color.GREEN);
		}
		
		
		
	}
}

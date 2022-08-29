import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class MainUserPage {

    private int count = 0;
    JButton button;
    JFrame frame = new JFrame();
    JLabel welcomeMessage = new JLabel();

    MainUserPage(String username) {
        // Toolkit + Dimension for retrieving the screen size
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = t.getScreenSize();

        welcomeMessage.setBounds((screenSize.width / 4) + 30, (screenSize.height / 4) - 250, 200, 40);
        welcomeMessage.setText("Welcome " + username);
        welcomeMessage.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Button
        button = new JButton();
        button.setBounds((screenSize.width / 4) + 100, (screenSize.height / 4) - 100, 200, 100);
        button.setText("Click me!");
        button.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        button.setFocusable(false);

        // Create Border for the application and the thickness of the border
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);
        // For adding an image to the frame as a label
        ImageIcon image = new ImageIcon("../random.png");

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

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                label.setText("JGnome clicked: " + count);
            }
        });

        frame.add(welcomeMessage);
        frame.add(label);
        frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("JGnome Launcher");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocation(new Point(screenSize.width / 4, screenSize.height / 4));
        frame.setSize(screenSize.width / 2, screenSize.height / 2);
    }
}

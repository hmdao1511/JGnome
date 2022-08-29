import java.awt.Color;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        UserCredentials userCredentials = new UserCredentials();
        Login login = new Login(userCredentials.getLoginInfo());

    }

}

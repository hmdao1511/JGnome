import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class UserCredentials {

    HashMap<String, String> loginInfo = new HashMap<>();

    UserCredentials() {
        try {
            File myObj = new File("account.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String username = myReader.nextLine();
                String password = myReader.nextLine();
                loginInfo.put(username, password);
            }
            System.out.println("Succesfully read the file");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }

    protected void addUser(String username, String password) {
        loginInfo.put(username, password);

        try {
            FileWriter myWriter = new FileWriter("account.txt", true);
            myWriter.write(username + "\n");
            myWriter.write(password + "\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

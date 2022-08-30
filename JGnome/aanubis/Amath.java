/*
 * AAnubis (Accessible, Awesome)
 *
 * Pack name: AAnubis Amath 
 * Written by Hai Minh Dao (4/8/2021)
 * Last Updated:
 * 
 * In this pack, everything is static, meaning that you only have to call 
 * the Amath out anytime you need it!
 * 
 * This java file provide you with things that the normal default Math Object 
 * of Java does not have
 * 
 */
package aanubis;
public class Amath {
    public static double pi = Math.PI;
    public static double piSqr = pi * pi;
    public static double piCube = Math.pow(pi, 3);

    public static boolean isNum(String input) {
        try {
            double parsed = Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPrime(int input) {
        boolean status = true;
        if (input < 2) {
            return false;
        } else {
            for (int i = 2; i < input / 2; i++) {
                if (input % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSqrNum(int input) {
        if(input % Math.sqrt(input) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isInt(String input) {
        try {
            int num = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void greet() {
        System.out.println("Hello World");
    }

}


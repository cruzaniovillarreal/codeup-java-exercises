package util;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Input {
    private Scanner scanner;


     public Input() {
     this.scanner = new Scanner(System.in);
    }

    public Input(String prompt) {
        System.out.println(prompt);
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return scanner.nextLine();
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public boolean yesNo() {
        String capture = scanner.nextLine();
        return capture.equalsIgnoreCase("y") || capture.equalsIgnoreCase("yes");
    }

    public boolean yesNo(String prompt) {
        System.out.print(prompt);
        String capture = scanner.nextLine();
        return capture.equalsIgnoreCase("y") || capture.equalsIgnoreCase("yes");
    }

    public int getInt(int min, int max) {
         while (true) {
             System.out.printf("\nEnter an integer between %d and %d: ", min, max);
             int num;
             try {
                 String capture = getString();
                 num = Integer.parseInt(capture);
             } catch (RuntimeException re) {
                 System.err.println("You must enter an integer.");
                 return getInt(min, max);
             }
             if (num >= min && num <= max) {
                 return num;
             }
             System.err.println("Value outside of defined range. Please try again.");
         }
    }

    public int getInt(int min, int max, String prompt) {
        while (true) {
            System.out.println(prompt);
            int num;
            try {
                String capture = getString();
                num = Integer.parseInt(capture);
            } catch (RuntimeException re) {
                System.err.println("You must enter an integer.");
                return getInt(min, max);
            }
            if (num >= min && num <= max) {
                return num;
            }
            System.err.println("Value outside of defined range. Please try again.");
        }
    }

    public int getInt(String prompt) {
        try {
            System.out.println(prompt);
            return Integer.parseInt(getString());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid input. Please try again.");
            return getInt(prompt);
        }
    }

    public int getInt() {
        return scanner.nextInt();
    }

    public double getDouble(double min, double max) {
        while (true) {
            System.out.printf("\nEnter a double between %s and %s: ", min, max);
            double num;
            try {
                String capture = getString();
                num = Double.parseDouble(capture);
            } catch (RuntimeException re) {
                System.err.println("You must enter a double within the defined range.");
                return getDouble(min, max);
            }
            if (num >= min && num <= max) {
                return num;
            }
            System.err.println("Value outside of defined range. Please try again.");
        }
    }

    public double getDouble(double min, double max, String prompt) {
        while (true) {
            System.out.println(prompt);
            double num;
            try {
                String capture = getString();
                num = Double.parseDouble(capture);
            } catch (RuntimeException re) {
                System.err.println("You must enter a double within the defined range.");
                return getDouble(min, max, prompt);
            }
            if (num >= min && num <= max) {
                return num;
            }
            System.err.println("Value outside of defined range. Please try again.");
        }
    }

    public double getDouble() {
        return scanner.nextDouble();
    }

    public double getDouble(String prompt) {
        try {
            System.out.println(prompt);
            return Double.parseDouble(getString());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid input. Please try again.");
            return getDouble(prompt);
        }
    }

    public static int toBinary(String biString){
        return Integer.valueOf(biString, 2);
    }

    public static int toHexDec(String hexString){
        return Integer.valueOf(hexString, 16);
    }

    public static String toBinaryString(int i){
        return Integer.toBinaryString(i);
    }
    public static String toHexString(int i) {
        return Integer.toHexString(i);
    }

    public static void main(String[] args) {

        String answer1 = new Input().getString("Enter a binary number: ");
        System.out.println("Your number is: "+toBinary(answer1));

        String answer2 = new Input().getString("Enter a hexidecimal number: ");
        System.out.println("Your number is: "+toHexDec(answer2));


        String answer3 = new Input().getString("Enter a number: ");
        int answerToInt = Integer.parseInt(answer3);
        System.out.println("Binary is " + Integer.toBinaryString(answerToInt));


        String answer4 = new Input().getString("Enter a number: ");
        int answerToInt2 = Integer.valueOf(answer4);
        System.out.println("Hexidecimal is " + Integer.toHexString(answerToInt2));
    }

}

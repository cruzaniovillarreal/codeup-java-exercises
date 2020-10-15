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
        System.out.printf("\nEnter and integer between %d and %d: ", min, max);
        int capture = scanner.nextInt();
        if (capture >= min && capture <= max) {
            return capture;
        } else {
            return getInt(min, max);
        }
    }

    public int getInt(int min, int max, String prompt) {
        System.out.print(prompt);
        int capture = scanner.nextInt();
        if (capture >= min && capture <= max) {
            return capture;
        } else {
            return getInt(min, max);
        }
    }

    public int getInt() {
        try {
            return Integer.valueOf(getString("Enter an integer: "));
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid input. Please try again.");
            return getInt();
        }
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public double getDouble(double min, double max) {
        System.out.printf("\nEnter a number between %f and %f: ", min, max);
        double capture = scanner.nextDouble();
        if (capture >= min && capture <= max) {
            return capture;
        } else {
            return getDouble(min, max);
        }
    }

    public double getDouble(double min, double max, String prompt) {
        System.out.print(prompt);
        double capture = scanner.nextDouble();
        if (capture >= min && capture <= max) {
            return capture;
        } else {
            return getDouble(min, max);
        }
    }

    public double getDouble() {
         try {
             return Double.valueOf(getString("Enter a double: "));
         } catch (NumberFormatException nfe) {
             return getDouble();

         }
    }

    public double getDouble(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

}

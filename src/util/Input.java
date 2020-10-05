package util;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);

    public String getString() {
        System.out.print("Enter a line to return: ");
        return scanner.nextLine();
    }

    public boolean yesNo() {
        System.out.print("\nEnter variations of yes: ");
        String capture = scanner.nextLine();
        return capture.equalsIgnoreCase("y") || capture.equals("yes");
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

    public int getInt() {
        System.out.print("\nEnter an integer: ");
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
    public double getDouble() {
        System.out.print("\nEnter a double: ");
        return scanner.nextDouble();
    }
}

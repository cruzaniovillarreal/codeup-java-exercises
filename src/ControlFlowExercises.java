import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
public class ControlFlowExercises {
    public static void main(String[] args) {

//        int y = 5;
//        while (y <= 15) {
//            System.out.print(y + " ");
//            y++;
//        }

//        double j = 2;
//        do {
//            System.out.print("\n" + j);
//            j = Math.pow(j, 2);
//        } while (j < 1000000);

//        for (int i=1; i<100; i++) {
//            if (i%3==0 & i%5==0) {
//                System.out.print("\nFizzBuzz");
//            } else if (i%3== 0) {
//                System.out.print("\nFizz");
//            } else if (i%5== 0) {
//                System.out.print("\nBuzz");
//            } else {
//                System.out.print("\n" + i);
//            }
//        }

        String userAnswer = "";
        do {
            Scanner newNumber = new Scanner(System.in);
            System.out.print("Enter an integer: ");
            int userNumber = newNumber.nextInt();
            System.out.print("\nHere is your table!");
            String leftAlignFormat = "| %-6d | %-6d | %-6d |%n";
            System.out.format("\n+--------+---------+-------+%n");
            System.out.format("| Number | Squared | Cubed |%n");
            System.out.format("+--------+---------+-------+%n");
            for (int i = 1; i <= userNumber; i++) {
                System.out.format(leftAlignFormat,i, i*i, i*i*i);
            }
            Scanner toContinue = new Scanner(System.in);
            System.out.print("\nWould you like to continue? [Y/N]");
            userAnswer += toContinue.next();
        } while (userAnswer.equalsIgnoreCase("y"));

//        System.out.format("+--------+---------+-------+%n");
//        Scanner scanner = new Scanner(System.in);
//        String choice = "y";
//        do
//        {
//            // Get input from the user
//            System.out.print("Enter an integer: ");
//            int integer = scanner.nextInt();
//            // Create a header
//            String header = "Number | " + "Squared | " + "Cubed   " + "\n"
//                    +   "------ | " + "------- | " + "-----   " + "\n";
//            System.out.format("%-15s", header);
//            int square = 0;
//            int cube = 0;
//            String row = "";
//            for (int i = 1; i <= integer; i++)
//            {
//                square = i * i;
//                cube = i * i * i;
//                if (i < 4) {
//                    row = i + "      | " + square + "       | " + cube;
//                } else {
//                    row = i + "      | " + square + "      | " + cube;
//                }
//                System.out.format("%-15s\n", row);
//            }
//            // See if the user wants to continue
//            System.out.print("Continue? (y/n): ");
//            choice = scanner.next();
//            System.out.println();
//        }
//        while (!choice.equalsIgnoreCase("n"));
    }
}

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
public class ControlFlowExercises {
    public static void main(String[] args) {

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

        Scanner newNumber = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int userNumber = newNumber.nextInt();
        System.out.print(userNumber);

        System.out.print("\n\nHere is your table!");

        String leftAlignFormat = "| %-6d | %-6d | %-6d |%n";
        System.out.format("\n+--------+---------+-------+%n");
        System.out.format("| Number | Squared | Cubed |%n");
        System.out.format("+--------+---------+-------+%n");
        for (int i = 1; i <= userNumber; i++) {
            Scanner toContinue = new Scanner(System.in);
            System.out.print("Would you like to continue? [Y/N]");
            String userAnswer = toContinue.next();
            if (userAnswer.equals("y")) {
                System.out.format(leftAlignFormat,i, i*i, i*i*i);
            } else {
                break;
            }
        }
        System.out.format("+--------+---------+-------+%n");

    }
}

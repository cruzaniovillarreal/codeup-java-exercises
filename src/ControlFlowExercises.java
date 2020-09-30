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

//        String userAnswer = "";
//        do {
//            userAnswer = "";
//            Scanner newNumber = new Scanner(System.in);
//            System.out.print("Enter an integer: ");
//            int userNumber = newNumber.nextInt();
//            System.out.print("\nHere is your table!");
//            String leftAlignFormat = "| %-6d | %-6d | %-6d |%n";
//            System.out.format("\n+--------+---------+-------+%n");
//            System.out.format("| Number | Squared | Cubed |%n");
//            System.out.format("+--------+---------+-------+%n");
//            for (int i = 1; i <= userNumber; i++) {
//                System.out.format(leftAlignFormat, i, i * i, i * i * i);
//            }
//            Scanner toContinue = new Scanner(System.in);
//            System.out.print("\nWould you like to continue? [Y/N]");
//            userAnswer += toContinue.next();
//        } while (userAnswer.equalsIgnoreCase("y"));

        String answer = "";
        do {
            answer = "";
            Scanner newGrade = new Scanner(System.in);
            System.out.print("Enter a grade number (0-100) to receive letter grade: ");
            int userGrade = newGrade.nextInt();
            if (userGrade >= 88) {
                if (userGrade >= 99) {
                    System.out.print("A+");
                } else if (userGrade >= 93) {
                    System.out.print("A");
                } else {
                    System.out.print("A-");
                }
            } else if (userGrade >= 80) {
                if (userGrade >= 86) {
                    System.out.print("B+");
                } else if (userGrade >= 83) {
                    System.out.print("B");
                } else {
                    System.out.print("B-");
                }
            } else if (userGrade >= 67) {
                if (userGrade >= 78) {
                    System.out.print("C+");
                } else if (userGrade >= 72) {
                    System.out.print("C");
                } else {
                    System.out.print("C-");
                }
            } else if (userGrade >= 60) {
                if (userGrade >= 65) {
                    System.out.print("D+");
                } else if (userGrade >= 63) {
                    System.out.print("D");
                } else {
                    System.out.print("D-");
                }
            } else {
                System.out.print("F");
            }
            Scanner toContinue = new Scanner(System.in);
            System.out.print("\nWould you like to continue? [Y/N]");
            answer += toContinue.next();
        } while (answer.equalsIgnoreCase("y"));

    }
}

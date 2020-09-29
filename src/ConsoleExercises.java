import java.util.Scanner;
public class ConsoleExercises {
    public static void main(String[] args) {
        double pi = 3.14159;
        System.out.printf("The value of pi is approximately %s \n", pi);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter something: ");
        //.next captures one word, .nextLine() will capture sentence
        String userInput = scanner.next();
        System.out.println("You entered: --> \"" + userInput + "\" <-- \n");

        Scanner userInt = new Scanner((System.in));
        System.out.print("Enter a number here: ");
        int userNumber = scanner.nextInt();
        System.out.printf("Your number is %d", userNumber);
    }
}

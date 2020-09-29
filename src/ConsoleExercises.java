import java.util.Scanner;
import static java.lang.Integer.parseInt;
import static java.lang.Float.parseFloat;
public class ConsoleExercises {
    public static void main(String[] args) {
//        double pi = 3.14159;
//        System.out.printf("The value of pi is approximately %s \n", pi);
//
//        double dollars = 10.12345;
//        // the $%.2f assigns decimal amount to print
//        System.out.printf("The cost of a typical drink at Starbucks is $%.2f \n", dollars);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter something: ");
//        //.next captures one word, .nextLine() will capture sentence
//        String userInput = scanner.next();
//        System.out.println("You entered: --> \"" + userInput + "\" <-- \n");
//
//        Scanner userInt = new Scanner(System.in);
//        System.out.print("Enter a number here: ");
//        int userNumber = userInt.nextInt();
//        System.out.printf("Your number is %d \n", userNumber);
//
//        Scanner userWords = new Scanner(System.in);
//        System.out.print("Enter 3 words here: ");
//        String userWord1 = userWords.next();
//        String userWord2 = userWords.next();
//        String userWord3 = userWords.next();
//        System.out.printf("Your words are: \n%s \n%s\n%s", userWord1, userWord2, userWord3);

//        Scanner userString = new Scanner(System.in);
//        System.out.print("Enter a sentence here: ");
//        String userSentence = userString.nextLine();
//        System.out.printf("Your sentence was: \n%s", userSentence);

        Scanner lwInput = new Scanner(System.in);
        lwInput.useDelimiter("#");
        System.out.print("Enter Length, Width, and Height:");

//      Using .next Methods
//      nextFloats/Ints
        float userLength = lwInput.nextFloat();
        float userWidth = lwInput.nextFloat();
        float userHeight = lwInput.nextFloat();

//        parseInt/float next
//        String userLength = lwInput.next();
//        String userWidth = lwInput.next();
//        String userHeight = lwInput.next();
//        int userLength = parseInt(userLength);
//        int userLength = parseInt(userLength);
//        int userLength = parseInt(userLength);

//        Using array split method
//        String wholeLine = lwInput.nextLine();
//        String[] vwhArray = wholeLine.split(" ");
//        float userLength = parseFloat(vwhArray[0]);
//        float userWidth = parseFloat(vwhArray[1]);
//        float userHeight = parseFloat(vwhArray[2]);

        float perimeter = (userWidth*2) + (userLength*2);
        float area = (userWidth * userLength);
        float volume = (userLength * userWidth * userHeight);

        System.out.printf("Room Calculations: P = %.3f, A = %.3f, V = %.3f", perimeter, area, volume);
    }
}

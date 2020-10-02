import java.util.Scanner;

public class HighLow {

    public static int randomizer(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public static void guessCheck(int guessCount, int randomNumber, int guessCap) {
        int counter = guessCount;
        if(counter < guessCap) {
            System.out.print("Guess "+(counter+1)+": ");
            Scanner newGuess = new Scanner(System.in);
            int guessAgain = newGuess.nextInt();
            if (guessAgain == randomNumber) {
                System.out.println("GOOD GUESS!");
                System.out.println("Would you like to play again? [y/N]");
                newGuess.nextLine();
                if (newGuess.nextLine().equalsIgnoreCase("y")) {
                    guessingGame();
                }
            } else if (guessAgain >= randomNumber){
                System.out.println("LOWER");
                guessCheck((counter+1), randomNumber, guessCap);
            } else {
                System.out.println("HIGHER");
                guessCheck((counter+1), randomNumber, guessCap);
            }
        } else {
            System.out.println("You're all out guesses :( \nWould you like to play again? [y/N]");
            Scanner newGuess = new Scanner(System.in);
            if (newGuess.nextLine().equalsIgnoreCase("y")) {
                guessingGame();
            }
        }
    }

    public static void guessingGame() {
        int randomNumber = randomizer(1, 100);
        Scanner newGuess = new Scanner(System.in);
        System.out.print("How many guesses would you like? ");
        int guessCap = newGuess.nextInt();
        System.out.print("Guess a number 1 through 100: ");
        int userGuess = newGuess.nextInt();
        if (userGuess < 1 || userGuess > 100) {
            guessingGame();
        }
        if (userGuess == randomNumber) {
            System.out.println("WHAT A GUESS! NICE JOB!");
            System.out.println("Would you like to play again? [y/N]");
            newGuess.nextLine();
            if (newGuess.nextLine().equalsIgnoreCase("y")) {
                guessingGame();
            }
        } else {
            System.out.println("If at first you don't succeed...");
            guessCheck(1, randomNumber, guessCap);
        }

    }

    public static void main(String[] args) {
        guessingGame();
    }
}

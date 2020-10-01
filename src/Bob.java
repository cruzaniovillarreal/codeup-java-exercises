import java.util.Scanner;

public class Bob {
    public static void main(String[] args) {
        String toContinue = "";
        System.out.println("Hi, I'm Bob");
        do {
            System.out.print("Speak to Bob: ");
            Scanner userStatement = new Scanner(System.in);
            String newStatement = userStatement.nextLine();
            if (newStatement.equals("")) {
                System.out.println("Fine. Be that way!");
            } else if (newStatement.endsWith("?")) {
                System.out.println("Sure");
            } else if (newStatement.endsWith("!")) {
                System.out.println("Whoa, chill out!");
            } else{
                System.out.println("Whatever.");
            }

            Scanner keepGoing = new Scanner(System.in);
            System.out.println("Would you like to continue the conversation with Bob? [y/N]");
            toContinue = keepGoing.nextLine();

        } while (toContinue.equalsIgnoreCase("y"));

        }
    }

import java.util.Scanner;

public class ServerNameGenerator {

    public static String randomReturn(String[] array) {
        return array[(int) (Math.random() * 9)];
    }

//        String[] nouns = new String[10];

//        "Mountain Chicken";
//        "Ostrich";
//        "Pigeon";
//        "Wunderpus photogenicus";
//        "Spiny Lumpsucker";
//        "Pistol Shrimp";
//        "Pink Fairy Armadillo";
//        "Rasberry Crazy Ant";
//        "Chicken Turtle";
//        "Goblin Shark";

    public static void main(String[] args) {
        String[] adjectives = {
                "Grand",
                "Suspicious",
                "Elegant",
                "Nervous",
                "Scary",
                "Zealous",
                "Scruffy",
                "Muscular",
                "Polite",
                "Tiny"
        };

        String[] nouns = {
                "Mountain Chicken",
                "Ostrich",
                "Pigeon",
                "Wunderpus photogenicus",
                "Spiny Lumpsucker",
                "Pistol Shrimp",
                "Pink Fairy Armadillo",
                "Rasberry Crazy Ant",
                "Chicken Turtle",
                "Goblin Shark"
        };
        String toContinue;
        do {
            System.out.println("Your server name is: \n"+randomReturn(adjectives)+"-"+randomReturn(nouns));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to generate another server name? [y/n]");
            toContinue = scanner.nextLine();
        } while(toContinue.equalsIgnoreCase("y") || toContinue.equalsIgnoreCase("yes"));
    }

}

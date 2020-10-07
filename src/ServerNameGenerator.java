import util.Input;

import java.util.Scanner;

public class ServerNameGenerator {
    public static String[] adjectives = {
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

    public static String[] nouns = {
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

    public static String randomReturn(String[] array) {
        return array[(int) (Math.random() * array.length-1)];
    }


    public static void main(String[] args) {
        boolean toContinue;
        do {
            System.out.println("Your server name is: \n"+randomReturn(ServerNameGenerator.adjectives)+"-"+randomReturn(nouns));
            toContinue = new Input().yesNo("Return to directory? [y/N]");
        } while(toContinue);
    }
}

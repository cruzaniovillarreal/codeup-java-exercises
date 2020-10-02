import java.util.Scanner;

public class ConsoleAdventureGame {

    public static String userName() {
        Scanner newName = new Scanner(System.in);
        return newName.nextLine();
    }

    public static int randomizer(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public static String enemyRandomizer() {
        int randomNumber = randomizer(1, 5);
        String enemy;
        switch (randomNumber) {
            case 1:
                enemy = "Zombie";
                break;
            case 2:
                enemy = "Skeleton";
                break;
            case 3:
                enemy = "Troll";
                break;
            case 4:
                enemy = "Bat";
                break;
            case 5:
                enemy = "Wraith";
                break;
            default:
                enemy = "Vampire";
                break;
        }
        return enemy;
    }

    public static String landscapeRandomizer() {
        Scanner choice = new Scanner(System.in);
        int randomLand = randomizer(1, 3);
        String playerChoice;
        switch (randomLand) {
            case 1:
                System.out.println("You come upon 2 tunnel entrances...");
                System.out.println("Would you like to go left or right? [left/right]");
                playerChoice = choice.nextLine();
                break;
            case 2:
                System.out.println("You pass a locked door and luckily you have magic pocket fuzz...");
                System.out.println("Would you like to pick the lock? [y/N]");
                playerChoice = choice.nextLine();
                break;
            case 3:
                System.out.println("You stumble upon a large body of water with a boat sitting on shore. There's something glowing on the island in the center of the lake... ");
                System.out.println("Would you like to take the boat and check out the mysterious light? [y/N");
                playerChoice = choice.nextLine();
                break;
            default:
                playerChoice = "Nothing";
                break;
        }
        return playerChoice;
    }

    public static void playerLevels() {
        System.out.println(landscapeRandomizer());
    }

    public static void gameStart() {
        System.out.println("Welcome to Spell-Lunker!");
        System.out.print("Enter START to Begin:");
        Scanner toStart = new Scanner(System.in);
        String response = toStart.nextLine();
        if (response.equalsIgnoreCase("START")) {
            System.out.print("Enter your characters name: ");
            String name = userName();
            System.out.printf("%s enters the eerie cavern in search of fortune.\n", name);
            playerLevels();
        } else {
            gameStart();
        }

    }


    public static void main(String[] args) {
        gameStart();
    }
}



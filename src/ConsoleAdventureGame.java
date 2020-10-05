import java.util.Scanner;

public class ConsoleAdventureGame {

    public static String userName() {
        System.out.print("Enter your characters name: ");
        Scanner newName = new Scanner(System.in);
        return newName.nextLine();
    }

    public static int startingLife() {
        System.out.print("Enter your starting Life Total (Max-30): ");
        Scanner userLife = new Scanner(System.in);
        int life = userLife.nextInt();
        if (life > 30 || life < 1) {
            return startingLife();
        }
        return life;
    }

    public static int randomizer(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public static String enemyRandomizer() {
        int randomNumber = randomizer(1, 10);
        String enemy;
        switch (randomNumber) {
            case 1:
                enemy = "zombie!";
                break;
            case 2:
                enemy = "skeleton!";
                break;
            case 3:
                enemy = "troll!";
                break;
            case 4:
                enemy = "bat!";
                break;
            case 5:
                enemy = "wraith!";
                break;
            case 6:
                enemy = "vampire!";
                break;
            case 7:
                enemy = "werewolf!";
                break;
            case 8:
                enemy = "gremlin!";
                break;
            case 9:
                enemy = "spider!";
                break;
            case 10:
                enemy = "poor old man!";
                break;
            default:
                enemy = "Nothing";
                break;
        }
        return enemy;
    }

    public static int potionFinder(int potionCounter) {
        int randomNumber = randomizer(1, 3);
        int foundPotion = potionCounter;
        if (randomNumber == 2) {
            foundPotion++;
            System.out.print(ANSI_GREEN+"The enemy dropped a potion!\n"+ANSI_RESET);
        } else {
            System.out.print(ANSI_RED+"No potion was dropped.\n"+ANSI_RESET);
        }
        return foundPotion;
    }

    public static String landscapeRandomizer(String name) {
        Scanner choice = new Scanner(System.in);
        int randomLand = randomizer(1, 6);
        String playerChoice;
        String enemy = enemyRandomizer();
        switch (randomLand) {
            case 1:
                System.out.println("\nYou come upon 2 tunnel entrances...");
                System.out.println("Would you like to go left or right? [left/right]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter a tunnel " + enemy);
                break;
            case 2:
                System.out.println("\nYou pass a locked stone door, but luckily you have magic pocket fuzz...");
                System.out.println("Would you like to pick the lock? [y/N]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter a " + enemy);
                break;
            case 3:
                System.out.println("\nYou hear whispering escaping from a crack just big enough to squeeze through...");
                System.out.println("Investigate? [y/N]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter a " + enemy);
                break;
            case 4:
                System.out.println("\nThe walls tremble as someone cries out \""+name.toUpperCase()+"\"!");
                System.out.println("Hurry to their aid? [y/N]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter a " + enemy);
                break;
            case 5:
                System.out.println("\nAs you continue to walk you sense you're not alone...");
                System.out.println("Cast a spell to see what's there? [y/N]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter a " + enemy);
                break;
            case 6:
                System.out.println("\nYou stumble upon a large body of water with a boat sitting on shore.\nThere's something glowing on the island in the center of the lake... ");
                System.out.println("Would you like to take the boat and check out the mysterious light? [y/N]");
                playerChoice = choice.nextLine();
                if (playerChoice.equalsIgnoreCase("y")) {
                    enemy = "watery "+enemy;
                    System.out.println("You encounter a " + enemy);
                } else {
                    System.out.println("You encounter a " + enemy);
                }
                break;
            default:
                playerChoice = "Nothing";
                break;
        }
        return enemy;
    }

    public static int[] fighter(int playerlife, int enemyHealth, int potionCount) {
        Scanner scanner1 = new Scanner(System.in);
        int [] lifeAndPotions = {playerlife, potionCount};
        if (playerlife <= 0) {
            return lifeAndPotions;
        } else if (enemyHealth <= 0) {
            System.out.print(ANSI_GREEN+"Enemy Defeated!\n"+ANSI_RESET);
            return lifeAndPotions;
        } else {
            System.out.printf("You have %s HP. The enemy has %s HP.\n", playerlife, enemyHealth);
            System.out.printf("Potions: %s\n", potionCount);
            System.out.println("Attack(A) or Drink Potion(D)? [A/D]");
            String response = scanner1.nextLine();
            int playerHealth = playerlife;
            if (response.equalsIgnoreCase("A")) {
                int attackDamage = randomizer(1, 10);
                System.out.printf("\nYou deal %s damage!\n", attackDamage);
                enemyHealth -= attackDamage;
                if (enemyHealth > 0) {
                    int retaliationDamage = randomizer(1, 15);
                    playerHealth -= retaliationDamage;
                    System.out.printf("The enemy retaliates dealing %s damage!\n\n", retaliationDamage);
                    return fighter(playerHealth, enemyHealth, potionCount);
                } else {
                    return fighter(playerlife, enemyHealth, potionCount);
                }
            } else if (response.equalsIgnoreCase("D") && potionCount > 0) {
                int potionsLeft = potionCount--;
                playerHealth += 15;
                int retaliationDamage = randomizer(1, 13);
                System.out.printf("\nYou drink a potion restoring 15 health.\nThe enemy retaliates dealing %s damage!\n\n", retaliationDamage);
                playerHealth -= retaliationDamage;
                return fighter(playerHealth, enemyHealth, potionCount);
            } else if (response.equalsIgnoreCase("D") && potionCount <= 0) {
                System.out.print(ANSI_RED+"\nNo potions available\n"+ANSI_RESET);
                return fighter(playerHealth, enemyHealth, potionCount);
            }
            return lifeAndPotions;
        }
    }


    public static void playerLevels(int life, String name, int killCount, int potionCount) {
        String enemy = landscapeRandomizer(name);
        int enemyHealth = randomizer(1, 20);
        int [] lifeAndPotions = fighter(life, enemyHealth, potionCount);
        int lifeAfterFight = lifeAndPotions[0];
        int potionsAfterFight = lifeAndPotions[1];
        Scanner scanner = new Scanner(System.in);
        if (lifeAfterFight > 0) {
            int potionCounter = potionFinder(potionsAfterFight);
            System.out.print("\nEnter GO to continue: ");
            String readString = scanner.nextLine();
            if (readString.equalsIgnoreCase("GO")) {
                playerLevels(lifeAfterFight, name, killCount+1, potionCounter);
            }
        } else {
            System.out.print(ANSI_RED+"You have been killed.\n"+ANSI_RESET);
            System.out.printf(ANSI_YELLOW+"Enemies Vanquished: %s\n"+ANSI_RESET, killCount);
            System.out.print("Would you like to play again? [y/N]\n");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                gameStart();
            } else {
                System.out.print("Game Over. Seriously.");
            }
        }
    }

    public static void gameStart() {
        System.out.println(ANSI_BLUE+"Welcome to Spell-Lunker!"+ANSI_RESET);
        System.out.print("Enter "+ANSI_GREEN+"START"+ANSI_RESET+" to Begin: ");
        Scanner toStart = new Scanner(System.in);
        String response = toStart.nextLine();
        if (response.equalsIgnoreCase("START")) {
            String name = userName();
            int life = startingLife();
            System.out.printf("\n"+ANSI_CYAN+"%s enters the eerie cavern in search of fortune with %s HP.\n"+ANSI_RESET, name, life);
            playerLevels(life, name, 0, 5);
        } else {
            gameStart();
        }
    }

    public static void main(String[] args) {
        gameStart();
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
}




import java.util.Scanner;

public class ConsoleAdventureGame {

    public static String userName() {
        System.out.print("Enter your characters name: ");
        Scanner newName = new Scanner(System.in);
        return newName.nextLine();
    }

    public static int startingLife() {
        System.out.print("Enter your starting Life Total: ");
        Scanner userLife = new Scanner(System.in);
        int life = userLife.nextInt();
        if (life > 50 || life < 1) {
            return startingLife();
        }
        return life;
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

    public static String potionFinder() {
        int randomNumber = randomizer(1, 3);
        String foundPotion;
        if (randomNumber == 2) {
            foundPotion = ANSI_GREEN+"You found a potion!"+ANSI_RESET;
        } else {
            foundPotion = ANSI_RED+"No potions found."+ANSI_RESET;
        }
        return foundPotion;
    }

    public static String landscapeRandomizer() {
        Scanner choice = new Scanner(System.in);
        int randomLand = randomizer(1, 3);
        String playerChoice;
        String enemy = enemyRandomizer();
        switch (randomLand) {
            case 1:
                System.out.println("You come upon 2 tunnel entrances...");
                System.out.println("Would you like to go left or right? [left/right]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter a tunnel " + enemy);
                break;
            case 2:
                System.out.println("You pass a locked stone door, but luckily you have magic pocket fuzz...");
                System.out.println("Would you like to pick the lock? [y/N]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter a " + enemy);
                break;
            case 3:
                System.out.println("You stumble upon a large body of water with a boat sitting on shore. There's something glowing on the island in the center of the lake... ");
                System.out.println("Would you like to take the boat and check out the mysterious light? [y/N]");
                playerChoice = choice.nextLine();
                if (playerChoice.equalsIgnoreCase("y")) {
                    enemy = "Watery "+enemy;
                    System.out.println("You encounter a " + enemy);
                }
                break;
            default:
                playerChoice = "Nothing";
                break;
        }
        return enemy;
    }

    public static int fighter(int playerlife, int enemyHealth) {
        Scanner scanner1 = new Scanner(System.in);
        if (playerlife <= 0) {
            return playerlife;
        } else if (enemyHealth <= 0) {
            System.out.print("Enemy Defeated!\n");
            return playerlife;
        } else {
            System.out.printf("You have %s HP. The enemy has %s HP.\n", playerlife, enemyHealth);
            System.out.println("Attack(A) or Drink Potion(D)? [A/D]");
            String response = scanner1.nextLine();
            int playerHealth = playerlife;
            if (response.equalsIgnoreCase("A")) {
                int attackDamage = randomizer(1, 10);
                System.out.printf("You deal %s damage.\n", attackDamage);
                enemyHealth -= attackDamage;
                if (enemyHealth > 0) {
                    int retaliationDamage = randomizer(1, 15);
                    playerHealth -= retaliationDamage;
                    System.out.printf("The enemy retaliates dealing %s damage!\n", retaliationDamage);
                    return fighter(playerHealth, enemyHealth);
                } else {
                    return fighter(playerlife, enemyHealth);
                }
            } else if (response.equalsIgnoreCase("D")) {
                playerHealth += 5;
                int retaliationDamage = randomizer(1, 15);
                System.out.printf("You drink a potion restoring 5 health.\nThe enemy retaliates dealing %s damage!\n", retaliationDamage);
                playerHealth -= retaliationDamage;
                return fighter(playerHealth, enemyHealth);
            }
            return playerHealth;
        }
    }


    public static void playerLevels(int life) {
        int playerHealth = life;
        String enemy = landscapeRandomizer();
        int enemyHealth = randomizer(1, 20);
        int lifeAfterFight = fighter(playerHealth, enemyHealth);
        Scanner scanner = new Scanner(System.in);
        if (lifeAfterFight > 0) {
            System.out.println(potionFinder());
            System.out.print("Enter GO to continue: ");
            String readString = scanner.nextLine();
            if (readString.equalsIgnoreCase("GO")) {
                playerLevels(lifeAfterFight);
            }
        } else {
            System.out.print("You have been killed. Would you like to play again?");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                gameStart();
            } else {
                System.out.print("Game Over. Seriously.");
            }
        }

    }

    public static void gameStart() {
        System.out.println(ANSI_BLUE+"Welcome to Spell-Lunker!"+ANSI_RESET);
        System.out.print("Enter START to Begin: ");
        Scanner toStart = new Scanner(System.in);
        String response = toStart.nextLine();
        if (response.equalsIgnoreCase("START")) {
            String name = userName();
            int life = startingLife();
            System.out.printf("%s enters the eerie cavern in search of fortune with %s HP\n", name, life);
            playerLevels(life);
        } else {
            gameStart();
        }
    }


    public static void main(String[] args) {
        gameStart();
    }
//System.out.print(ANSI_BLUE + " Continue? [Y/n]: " + ANSI_RESET);
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





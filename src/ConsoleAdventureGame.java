import java.util.Scanner;

public class ConsoleAdventureGame {

    public static void gameStart() {
        System.out.println(ANSI_BLUE + "Welcome to Spell-Lunker!" + ANSI_RESET);
        System.out.print("Enter " + ANSI_GREEN + "START" + ANSI_RESET + " to Begin: ");
        Scanner toStart = new Scanner(System.in);
        String response = toStart.nextLine();
        if (response.equalsIgnoreCase("START")) {
            Character player = new Character(userName(), startingLife());
            System.out.printf("\n" + ANSI_CYAN + "%s enters the eerie cavern in search of fortune with %s HP.\n" + ANSI_RESET, player.name, player.health);
            playerLevels(player);
        } else {
            gameStart();
        }
    }

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

    public static void playerLevels(Character player) {
        String enemy = landscapeRandomizer(player.name, player.level);
        boolean atBossLevel;
        int enemyHealth;
        if (player.level % 5 == 0) {
            atBossLevel = true;
            enemyHealth = randomizer(30, 45) + player.level;
        } else {
            atBossLevel = false;
            enemyHealth = randomizer(1, 10) + (player.level * 2);
        }
        player = fighter(enemy, enemyHealth, player, atBossLevel);
        Scanner scanner = new Scanner(System.in);
        if (player.health > 0) {
            Character playerBuffed = PotionsGoldXPKills(player, atBossLevel, enemy);
            System.out.println("Level: " + playerBuffed.level);
            System.out.println("Gold: " + playerBuffed.gold);
            System.out.println("Potions: " + playerBuffed.potions);
            System.out.println("XP: " + playerBuffed.XP);
            System.out.print("\nEnter GO to continue: ");
            String readString = scanner.nextLine();
            if (readString.equalsIgnoreCase("GO")) {
                playerLevels(playerBuffed);
            }
        } else {
            System.out.print(ANSI_RED + "You have been slain!\n" + ANSI_RESET);
            System.out.printf(ANSI_YELLOW + "Enemies Vanquished: %s\n" + ANSI_RESET, player.kills);
            System.out.print("Would you like to play again? [y/N]\n");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                gameStart();
            } else {
                System.out.print("Game Over. Seriously.");
            }
        }
    }

    public static int randomizer(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public static String enemyRandomizer(int playerLevel) {
        String enemy = "";
        if (playerLevel % 5 == 0) {
            int randomNumber = randomizer(1, 10);
            switch (randomNumber) {
                case 1:
                    enemy = "Valik a Titan Prime!";
                    break;
                case 2:
                    enemy = "Scorn the Minotaur Warlord!";
                    break;
                case 3:
                    enemy = "THE BigFoot!";
                    break;
                case 4:
                    enemy = "Wilt, a Celestial Werebear!";
                    break;
                case 5:
                    enemy = "the Lich King DreamEater!";
                    break;
                case 6:
                    enemy = "Xilon The Undead Kraken!";
                    break;
                case 7:
                    enemy = "Inferno The Ancient Dragon!";
                    break;
                case 8:
                    enemy = "Grime, the Impeccable!";
                    break;
                case 9:
                    enemy = "the guardian Cerberus!";
                    break;
                case 10:
                    enemy = "Jack the Pumpkin King!";
                    break;
            }
            return enemy;
        } else {
            int randomNumber = randomizer(1, 10);
            switch (randomNumber) {
                case 1:
                    enemy = "a zombie!";
                    break;
                case 2:
                    enemy = "a skeleton!";
                    break;
                case 3:
                    enemy = "a troll!";
                    break;
                case 4:
                    enemy = "a bat!";
                    break;
                case 5:
                    enemy = "a wraith!";
                    break;
                case 6:
                    enemy = "a vampire!";
                    break;
                case 7:
                    enemy = "a werewolf!";
                    break;
                case 8:
                    enemy = "a gremlin!";
                    break;
                case 9:
                    enemy = "a spider!";
                    break;
                case 10:
                    enemy = "a poor old man!";
                    break;
                default:
                    enemy = "Nothing";
                    break;
            }
            return enemy;
        }
    }

    public static String landscapeRandomizer(String name, int playerLevel) {
        Scanner choice = new Scanner(System.in);
        int randomLand = randomizer(1, 6);
        String playerChoice;
        String enemy = enemyRandomizer(playerLevel);
        switch (randomLand) {
            case 1:
                System.out.println("\nYou come upon 2 tunnel entrances...");
                System.out.println("Would you like to go left or right? [left/right]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter " + enemy);
                break;
            case 2:
                System.out.println("\nYou pass a locked stone door, but luckily you have magic pocket fuzz...");
                System.out.println("Would you like to pick the lock? [y/N]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter " + enemy);
                break;
            case 3:
                System.out.println("\nYou hear whispering escaping from a crack just big enough to squeeze through...");
                System.out.println("Investigate? [y/N]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter " + enemy);
                break;
            case 4:
                System.out.println("\nThe walls tremble as someone cries out \"" + name.toUpperCase() + "\"!");
                System.out.println("Hurry to their aid? [y/N]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter " + enemy);
                break;
            case 5:
                System.out.println("\nAs you continue to walk you sense you're not alone...");
                System.out.println("Cast a spell to see what's there? [y/N]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter " + enemy);
                break;
            case 6:
                System.out.println("\nA small ball of light whips past you, illuminating a small passage.");
                System.out.println("Follow your new found friend? [y/N]");
                playerChoice = choice.nextLine();
                System.out.println("You encounter " + enemy);
                break;
            case 7:
                System.out.println("\nYou stumble upon a large body of water with a boat sitting on shore.\nThere's something glowing on the island in the center of the lake... ");
                System.out.println("Would you like to take the boat and check out the mysterious light? [y/N]");
                playerChoice = choice.nextLine();
                if (playerChoice.equalsIgnoreCase("y")) {
                    enemy = "watery " + enemy;
                    System.out.println("You encounter a " + enemy);
                } else {
                    System.out.println("You encounter " + enemy);
                }
                break;
            default:
                playerChoice = "Nothing";
                break;
        }
        return enemy;
    }

    public static Character fighter(String enemy, int enemyHealth,  Character player, boolean atBossLevel) {
        Scanner scanner1 = new Scanner(System.in);
        if (player.health <= 0) {
            return player;
        } else if (enemyHealth <= 0) {
            System.out.print(ANSI_GREEN + "Enemy Defeated!\n" + ANSI_RESET);
            return player;
        } else {
            System.out.printf("You have %s HP. The enemy has %s HP.\n", player.health, enemyHealth);
            System.out.printf("Potions: %s\n", player.potions);
            System.out.println("Attack(A) or Drink Potion(D)? [A/D]");
            String response = scanner1.nextLine();
            if (response.equalsIgnoreCase("A")) {
                int attackDamage = randomizer(1, 10);
                System.out.printf("\nYou deal %s damage!\n", attackDamage);
                enemyHealth -= attackDamage;
                if (enemyHealth > 0) {
                    int retaliationDamage;
                    if (atBossLevel) {
                        retaliationDamage = randomizer(5, 15);
                    } else {
                        retaliationDamage = randomizer(1, 5);
                    }
                    player.health -= retaliationDamage;
                    System.out.printf("The enemy retaliates dealing %s damage!\n\n", retaliationDamage);
                    return fighter(enemy, enemyHealth, player, atBossLevel);
                } else {
                    return fighter(enemy, enemyHealth, player, atBossLevel);
                }
            } else if (response.equalsIgnoreCase("D") && player.potions > 0) {
                player.potions--;
                player.health += 20;
                int retaliationDamage;
                if (atBossLevel) {
                    retaliationDamage = randomizer(5, 15);
                } else {
                    retaliationDamage = randomizer(1, 5);
                }
                System.out.printf("\nYou drink a potion restoring 15 health.\nThe enemy retaliates dealing %s damage!\n\n", retaliationDamage);
                player.health -= retaliationDamage;
                return fighter(enemy, enemyHealth, player, atBossLevel);
            } else if (response.equalsIgnoreCase("D") && player.potions <= 0) {
                System.out.print(ANSI_RED + "\nNo potions available\n" + ANSI_RESET);
                return fighter(enemy, enemyHealth, player, atBossLevel);
            } else if (!response.equalsIgnoreCase("D") && !response.equalsIgnoreCase("A")) {
                System.out.print(ANSI_RED + "\nInvalid input. Try Again.\n" + ANSI_RESET);
                return fighter(enemy, enemyHealth, player, atBossLevel);
            }
            return player;
        }
    }

    public static Character PotionsGoldXPKills(Character player, boolean wasBoss, String enemy) {
        player.kills += 1;
        int potionRoll = randomizer(1, 3);
        if (potionRoll == 2) {
            player.potions += 1;
            System.out.print(ANSI_GREEN + "The enemy dropped a potion!\n" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + "No potion was dropped.\n" + ANSI_RESET);
        }
        int xpRoll;
        int goldRoll;
        if (wasBoss) {
            xpRoll = randomizer(100, 125);
            player.XP += xpRoll;
            goldRoll = randomizer(35, 50);
            player.gold += goldRoll;
            System.out.print(ANSI_YELLOW + enemy + " dropped " + goldRoll + " gold!\n" + ANSI_RESET);
        } else {
            xpRoll = randomizer(40, 60);
            player.XP += xpRoll;
            goldRoll = randomizer(10, 20);
            player.gold += goldRoll;
            System.out.print(ANSI_YELLOW + "The enemy dropped " + goldRoll + " gold!\n" + ANSI_RESET);
        }
        System.out.print(ANSI_YELLOW + "Experience Gained: " + xpRoll + " XP!\n" + ANSI_RESET);
        return player;
    }

//    public static int potionFinder(int potionCounter) {
//        int randomNumber = randomizer(1, 3);
//        int foundPotion = potionCounter;
//        if (randomNumber == 2) {
//            foundPotion++;
//            System.out.print(ANSI_GREEN + "The enemy dropped a potion!\n" + ANSI_RESET);
//        } else {
//            System.out.print(ANSI_RED + "No potion was dropped.\n" + ANSI_RESET);
//        }
//        return foundPotion;
//    }
//
//    public static int goldFinder(int playerGold, boolean wasBoss, String enemy) {
//        int randomNumber;
//        if (wasBoss) {
//            randomNumber = randomizer(35, 50);
//            System.out.print(ANSI_YELLOW + enemy + " dropped " + randomNumber + " gold!\n" + ANSI_RESET);
//        } else {
//            randomNumber = randomizer(10, 20);
//                System.out.print(ANSI_YELLOW + "The enemy dropped " + randomNumber + " gold!\n" + ANSI_RESET);
//        }
//        return playerGold + randomNumber;
//    }
//
//    public static int xpGenerator(int playerXP, boolean wasBoss) {
//        int randomNumber;
//        if (wasBoss) {
//            randomNumber = randomizer(100, 125);
//        } else {
//            randomNumber = randomizer(40, 60);
//        }
//        System.out.print(ANSI_YELLOW + "Experience Gained: " + randomNumber + " XP!\n" + ANSI_RESET);
//        return randomNumber;
//    }

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





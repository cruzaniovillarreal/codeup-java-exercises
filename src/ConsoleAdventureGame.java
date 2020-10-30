import movies.Movie;
import movies.MoviesArray;
import util.Input;

import java.util.Scanner;

public class ConsoleAdventureGame {

    public static void gameStart() {
        System.out.println(ANSI_BLUE + "Welcome to Spell-Lunker!\n" + ANSI_RESET);
        System.out.println("Your journey begins as you walk up to the Cave of Lost Dreams. Many brave souls before you, in search of fame and fortune, have attempted to conquer the terror within." +
                "\nWhile some have lived, none have defeated The Guardians that lie in wait. Can you do what none have done before?" +
                "\nMake your way through the bowels of the cave, earning XP and gold. You can spend the gold on skill upgrades to give you an edge in combat by portaling to the Market.\n");
        System.out.print("Enter " + ANSI_GREEN + "START" + ANSI_RESET + " to Begin: ");
        Scanner toStart = new Scanner(System.in);
        String response = toStart.nextLine();
        if (response.equalsIgnoreCase("START")) {
            Character player = new Character(userName(), startingLife(), 5, 10, 10, 10);
            System.out.printf("\n" + ANSI_CYAN + "%s enters the eerie cavern with %s HP armed with 5 potions and a spell to teleport to the closest Market.\n" + ANSI_RESET, player.name, player.health);
            playerLevels(player);
        } else {
            gameStart();
        }
    }

    public static String userName() {
        return new Input().getString("\nEnter Hero Name: ");
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
        String enemy = landscapeRandomizer(player);
        boolean atBossLevel;
        int enemyHealth;
        if (player.level % 2 == 0) {
            atBossLevel = true;
            enemyHealth = randomizer(15, 20) * player.level;
        } else {
            atBossLevel = false;
            enemyHealth = randomizer(10, 20) + (player.level * 2);
        }
        player = fighter(enemy, enemyHealth, player, atBossLevel);
        Scanner scanner = new Scanner(System.in);
        if (player.health > 0) {
            Character playerBuffed = PotionsGoldXPKills(player, atBossLevel, enemy);
            questMenu(playerBuffed);
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
    public static void questMenu(Character playerBuffed) {
            Input scanner1 = new Input();
            int answer = scanner1.getInt(1, 3, "Quest choices:\n" +
                    "1. Continue your Quest\n" +
                    "2. Portal to Market\n" +
                    "3. View your Stats and Potions\n" +
                    "Choose your path: ");
            switch (answer) {
                case 1:
                    playerLevels(playerBuffed);
                    break;
                case 2:
                    System.out.println("\nCrystal activated. Teleporting to market.....\n");
                    System.out.println("As you enter the shop a ghastly figure appears before you and slowly gestures to the items on the table.\n");
                    marketMenu(playerBuffed);
                    questMenu(playerBuffed);
                    break;
                case 3:
                    String leftAlignFormat = "| %-10s | %-5d | %-11d | %-4d | %-7d | %-8d | %-6d | %-7d | %-7d | %-5d | %-6s |%n";
                    System.out.format("+------------+-------+-------------+------+---------+----------+--------+---------+---------+-------+--------+%n");
                    System.out.format("|    NAME    | LEVEL | XP TO LEVEL | GOLD | POTIONS | TOTAL XP | ATTACK | DEFENSE | AGILITY | KILLS | HEALTH |%n");
                    System.out.format("+------------+-------+-------------+------+---------+----------+--------+---------+---------+-------+--------+%n");
                    System.out.format(leftAlignFormat, playerBuffed.name, playerBuffed.level, ((150 * playerBuffed.level) - playerBuffed.xpToLevel), playerBuffed.gold, playerBuffed.potions, playerBuffed.totalXP, playerBuffed.attack, playerBuffed.defense, playerBuffed.agility, playerBuffed.kills, playerBuffed.health+"/"+playerBuffed.healthMax);
                    System.out.format("+------------+-------+-------------+------+---------+----------+--------+---------+---------+-------+--------+%n");
                    questMenu(playerBuffed);
                    break;
                default:
                    questMenu(playerBuffed);
                    break;
            }
    }

    public static Character marketMenu(Character playerBuffed) {
        Input scanner1 = new Input();
        System.out.println("\nGold: "+playerBuffed.gold);
        int answer = scanner1.getInt(1, 5, "Shop choices:\n" +
                "1. Attack upgrade - 50g \n" +
                "2. Defense upgrade - 35g \n" +
                "3. Agility upgrade - 30g \n" +
                "4. Potion - 20g\n" +
                "5. Exit\n" +
                "What would you like to purchase? (Select options 1,2,3,4,5) ");
        switch (answer) {
            case 1:
                if (playerBuffed.gold - 50 < 0) {
                    System.err.println("You have insufficient gold. The wraith screeches as you try to haggle, strongly rejecting your offer.");
                } else {
                    if (new Input().yesNo("Purchase attack upgrade? [y/N]")) {
                        playerBuffed.attack += 10;
                        playerBuffed.gold -= 50;
                    }
                }
                return marketMenu(playerBuffed);
            case 2:
                if (playerBuffed.gold - 35 < 0) {
                    System.err.println("You have insufficient gold. The wraith screeches as you try to haggle, strongly rejecting your offer.");
                } else {
                    if (new Input().yesNo("Purchase defense upgrade? [y/N]")) {
                        playerBuffed.defense += 10;
                        playerBuffed.gold -= 35;
                    }
                }
                return marketMenu(playerBuffed);
            case 3:
                if (playerBuffed.gold - 30 < 0) {
                    System.err.println("You have insufficient gold. The wraith screeches as you try to haggle, strongly rejecting your offer.");
                } else {
                    if (new Input().yesNo("Purchase agility upgrade? [y/N]")) {
                        playerBuffed.agility += 10;
                        playerBuffed.gold -= 30;
                    }
                }
                return marketMenu(playerBuffed);
            case 4:
                if (playerBuffed.gold - 20 < 0) {
                    System.err.println("You have insufficient gold. The wraith screeches as you try to haggle, strongly rejecting your offer.");
                } else {
                    if (new Input().yesNo("Purchase potion? [y/N]")) {
                        playerBuffed.potions += 1;
                        playerBuffed.gold -= 20;
                    }
                }
                return marketMenu(playerBuffed);
            case 5:
                System.out.println("\nThe figure disappears into nothing as you turn to leave....\n");
                return playerBuffed;
            default:
                return marketMenu(playerBuffed);
        }
    }

    public static int randomizer(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public static Character fighter(String enemy, int enemyHealth, Character player, boolean atBossLevel) {
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
                int attackDamage = randomizer(1, 5) + player.attack/2;
                System.out.printf("\nYou deal %s damage!\n", attackDamage);
                enemyHealth -= attackDamage;
                if (enemyHealth > 0) {
                    int retaliationDamage;
                    if (atBossLevel) {
                        retaliationDamage = randomizer(5, 15 + player.level) + player.level;
                    } else {
                        retaliationDamage = randomizer(1, 5) + (player.level * 2);
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
                    retaliationDamage = randomizer(5, 15 + player.level) + player.level;
                } else {
                    retaliationDamage = randomizer(1, 5) + (player.level * 2);
                }
                System.out.printf("\nYou drink a potion restoring 20 health.\nThe enemy retaliates dealing %s damage!\n\n", retaliationDamage);
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
        String potionOut = "";
        String goldOut = "";
        int potionRoll = randomizer(1, 3);
        if (potionRoll == 2) {
            player.potions += 1;
            potionOut = "Potion found! ";
        } else {
            potionOut = ANSI_RED + "No potion found" + ANSI_RESET + ". ";
        }
        int xpRoll;
        int goldRoll;
        if (wasBoss) {
//            xpRoll = randomizer(100, 125);
            xpRoll = 150 * player.level;
            player.totalXP += xpRoll;
            player.xpToLevel += xpRoll;
            goldRoll = randomizer(35, 50);
            player.gold += goldRoll;
            goldOut = ANSI_YELLOW + enemy + ANSI_RESET + " dropped " + ANSI_YELLOW + goldRoll + " gold!" + ANSI_RESET;
        } else {
            xpRoll = randomizer(50, 65);
            player.totalXP += xpRoll;
            player.xpToLevel += xpRoll;
            goldRoll = randomizer(10, 20);
            player.gold += goldRoll;
            goldOut = "The enemy dropped " + ANSI_YELLOW + goldRoll + " gold" + ANSI_RESET+"!";
        }
        System.out.println("\n"+potionOut + goldOut + " Experience Gained: " + ANSI_CYAN + xpRoll + " XP" + ANSI_RESET +"!\n");
        if (player.xpToLevel > (150 * player.level)) {
            System.out.println(player.name + " shivers as a new found power is felt." + ANSI_BLUE + " You Level Up!\n" + ANSI_RESET);
            player.xpToLevel -= 150 * player.level;
            player.level += 1;
        }
        return player;
    }

    public static String enemyRandomizer(int playerLevel) {
        String enemy = "";
        int randomNumber = randomizer(1, 10);
        if (playerLevel % 2 == 0) {
            switch (randomNumber) {
                case 1:
                    enemy = "Valik a Titan Prime";
                    break;
                case 2:
                    enemy = "Scorn the Minotaur Warlord";
                    break;
                case 3:
                    enemy = "THE BigFoot";
                    break;
                case 4:
                    enemy = "Wilt, a Celestial Werebear";
                    break;
                case 5:
                    enemy = "the Lich King DreamEater";
                    break;
                case 6:
                    enemy = "Xilon The Undead Kraken";
                    break;
                case 7:
                    enemy = "Inferno The Ancient Dragon";
                    break;
                case 8:
                    enemy = "Grime, the Impeccable";
                    break;
                case 9:
                    enemy = "the guardian Cerberus";
                    break;
                case 10:
                    enemy = "Jack the Pumpkin King";
                    break;
            }
        } else {
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
        }
        return enemy;
    }

    public static String landscapeRandomizer(Character player) {
        Scanner choice = new Scanner(System.in);
        int randomLand = randomizer(1, 6);
        String playerChoice;
        String enemy = enemyRandomizer(player.level);
        switch (randomLand) {
            case 1:
                System.out.println("\nYou come upon 2 tunnel entrances...");
                System.out.println("Would you like to go left or right? [left/right]");
                playerChoice = choice.nextLine();
                if (player.level % 3 == 0) {
                    System.out.println("\nYou encounter " + colorRandomizer()+enemy+ANSI_RESET+"!");
                } else {
                    System.out.println("\nYou encounter " + enemy);
                }

                break;
            case 2:
                System.out.println("\nYou pass a locked stone door, but luckily you have magic pocket fuzz...");
                System.out.println("Would you like to pick the lock? [y/N]");
                playerChoice = choice.nextLine();
                if (player.level % 3 == 0) {
                    System.out.println("\nYou encounter " + colorRandomizer()+enemy+ANSI_RESET+"!");
                } else {
                    System.out.println("\nYou encounter " + enemy);
                }
                break;
            case 3:
                System.out.println("\nYou hear whispering escaping from a crack just big enough to squeeze through...");
                System.out.println("Investigate? [y/N]");
                playerChoice = choice.nextLine();
                if (player.level % 3 == 0) {
                    System.out.println("\nYou encounter " + colorRandomizer()+enemy+ANSI_RESET+"!");
                } else {
                    System.out.println("\nYou encounter " + enemy);
                }
                break;
            case 4:
                System.out.println("\nThe walls tremble as someone cries out \"" + player.name.toUpperCase() + "\"!");
                System.out.println("Hurry to their aid? [y/N]");
                playerChoice = choice.nextLine();
                if (player.level % 3 == 0) {
                    System.out.println("\nYou encounter " + colorRandomizer()+enemy+ANSI_RESET+"!");
                } else {
                    System.out.println("\nYou encounter " + enemy);
                }
                break;
            case 5:
                System.out.println("\nAs you continue to walk you sense you're not alone...");
                System.out.println("Cast a spell to see what's there? [y/N]");
                playerChoice = choice.nextLine();
                if (player.level % 3 == 0) {
                    System.out.println("\nYou encounter " + colorRandomizer()+enemy+ANSI_RESET+"!");
                } else {
                    System.out.println("\nYou encounter " + enemy);
                }
                break;
            case 6:
                System.out.println("\nA small ball of light whips past you, illuminating a small passage.");
                System.out.println("Follow your new found friend? [y/N]");
                playerChoice = choice.nextLine();
                if (player.level % 3 == 0) {
                    System.out.println("\nYou encounter " + colorRandomizer()+enemy+ANSI_RESET+"!");
                } else {
                    System.out.println("\nYou encounter " + enemy);
                }
                break;
            case 7:
                System.out.println("\nYou stumble upon a large body of water with a boat sitting on shore.\nThere's something glowing on the island in the center of the lake... ");
                System.out.println("Would you like to take the boat and check out the mysterious light? [y/N]");
                playerChoice = choice.nextLine();
                if (playerChoice.equalsIgnoreCase("y")) {
                    enemy = "watery " + enemy;
                    System.out.println("\nYou encounter a " + enemy);
                } else {
                    System.out.println("\nYou encounter " + enemy);
                }
                break;
            default:
                playerChoice = "Nothing";
                break;
        }
        return enemy;
    }

    public static String colorRandomizer() {
        String color = "";
        int randomNumber = randomizer(1, 7);
            switch (randomNumber) {
                case 1:
                    color = "\u001B[30m";
                    break;
                case 2:
                    color = "\u001B[32m";
                    break;
                case 3:
                    color = "\u001B[31m";
                    break;
                case 4:
                    color = "\u001B[33m";
                    break;
                case 5:
                    color = "\u001B[34m";
                    break;
                case 6:
                    color = "\u001B[35m";
                    break;
                case 7:
                    color = "\u001B[36m";
                    break;
            }
        return color;
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





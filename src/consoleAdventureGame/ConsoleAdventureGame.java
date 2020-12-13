package consoleAdventureGame;

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
            System.out.printf("\n" + ANSI_CYAN + "%s enters the eerie cavern with %s HP armed with 5 potions and a spell to teleport to the closest Market.\n" + ANSI_RESET, player.getName(), player.getHealth());
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
        if (enemy.equalsIgnoreCase("No Enemy")) {
            lootGenerator(player);
            questMenu(player);
        } else {
            boolean atBossLevel;
            int enemyHealth;
            if (player.getLevel() % 2 == 0) {
                atBossLevel = true;
                enemyHealth = randomizer(15, 20) * player.getLevel();
            } else {
                atBossLevel = false;
                enemyHealth = randomizer(10, 20) + (player.getLevel() * 2);
            }
            Enemy enemyToFight = new Enemy(enemy, enemyHealth, 10, 10, 10, 10, atBossLevel);
            player = fighter(enemyToFight, player);
            Scanner scanner = new Scanner(System.in);
            if (player.getHealth() > 0) {
                Character playerBuffed = PotionsGoldXPKills(player, enemyToFight);
                questMenu(playerBuffed);
            } else {
                System.out.print(ANSI_RED + "You have been slain!\n" + ANSI_RESET);
                System.out.printf(ANSI_YELLOW + "Enemies Vanquished: %s\n" + ANSI_RESET, player.getKills());
                System.out.print("Would you like to play again? [y/N]\n");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    gameStart();
                } else {
                    System.out.print("Game Over. Seriously.");
                }
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
                    System.out.println("As you enter the shop a ghastly figure appears before you and slowly gestures to the items on the table.");
                    marketMenu(playerBuffed);
                    questMenu(playerBuffed);
                    break;
                case 3:
                    String leftAlignFormat = "| %-10s | %-5d | %-11d | %-4d | %-7d | %-8d | %-6d | %-7d | %-7d | %-5d | %-6s |%n";
                    System.out.format("+------------+-------+-------------+------+---------+----------+--------+---------+---------+-------+--------+%n");
                    System.out.format("|    NAME    | LEVEL | XP TO LEVEL | GOLD | POTIONS | TOTAL XP | ATTACK | DEFENSE | AGILITY | KILLS | HEALTH |%n");
                    System.out.format("+------------+-------+-------------+------+---------+----------+--------+---------+---------+-------+--------+%n");
                    System.out.format(leftAlignFormat, playerBuffed.getName(), playerBuffed.getLevel(), ((150 * playerBuffed.getLevel()) - playerBuffed.getXpToLevel()), playerBuffed.getGold(), playerBuffed.getPotions(), playerBuffed.getTotalXP(), playerBuffed.getAttack(), playerBuffed.getDefense(), playerBuffed.getAgility(), playerBuffed.getKills(), playerBuffed.getHealth()+"/"+playerBuffed.getHealthMax());
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
        System.out.println("\nGold: "+playerBuffed.getGold());
        int answer = scanner1.getInt(1, 5, "Shop choices:\n" +
                "1. Attack upgrade - 50g \n" +
                "2. Defense upgrade - 35g \n" +
                "3. Agility upgrade - 30g \n" +
                "4. Potion - 20g\n" +
                "5. Exit\n" +
                "What would you like to purchase? (Select options 1,2,3,4,5) ");
        switch (answer) {
            case 1:
                if (playerBuffed.getGold() - 50 < 0) {
                    System.err.println("You have insufficient gold. The wraith screeches as you try to haggle, strongly rejecting your offer.");
                } else {
                    if (new Input().yesNo("Purchase attack upgrade? [y/N]")) {
                        playerBuffed.setAttack(playerBuffed.getAttack() + 10);
                        playerBuffed.setGold(playerBuffed.getGold() - 50);
                    }
                }
                return marketMenu(playerBuffed);
            case 2:
                if (playerBuffed.getGold() - 35 < 0) {
                    System.err.println("You have insufficient gold. The wraith screeches as you try to haggle, strongly rejecting your offer.");
                } else {
                    if (new Input().yesNo("Purchase defense upgrade? [y/N]")) {
                        playerBuffed.setDefense(playerBuffed.getDefense() + 10);
                        playerBuffed.setGold(playerBuffed.getGold() - 35);
                    }
                }
                return marketMenu(playerBuffed);
            case 3:
                if (playerBuffed.getGold() - 30 < 0) {
                    System.err.println("You have insufficient gold. The wraith screeches as you try to haggle, strongly rejecting your offer.");
                } else {
                    if (new Input().yesNo("Purchase agility upgrade? [y/N]")) {
                        playerBuffed.setAgility(playerBuffed.getAgility() + 10);
                        playerBuffed.setGold(playerBuffed.getGold() - 30);
                    }
                }
                return marketMenu(playerBuffed);
            case 4:
                if (playerBuffed.getGold() - 20 < 0) {
                    System.err.println("You have insufficient gold. The wraith screeches as you try to haggle, strongly rejecting your offer.");
                } else {
                    if (new Input().yesNo("Purchase potion? [y/N]")) {
                        playerBuffed.setPotions(playerBuffed.getPotions() + 1);
                        playerBuffed.setGold(playerBuffed.getGold() - 20);
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

    public static Character fighter(Enemy enemy, Character player) {
        Scanner scanner1 = new Scanner(System.in);
        if (player.getHealth() <= 0) {
            return player;
        } else if (enemy.getHealth() <= 0) {
            System.out.print(ANSI_GREEN + "Enemy Defeated!\n" + ANSI_RESET);
            return player;
        } else {
            System.out.printf("You have %s HP. The enemy has %s HP.\n", player.getHealth(), enemy.getHealth());
            System.out.printf("Potions: %s\n", player.getPotions());
            System.out.println("Attack(A) or Drink Potion(D)? [A/D]");
            String response = scanner1.nextLine();
            if (response.equalsIgnoreCase("A")) {
                int attackDamage = randomizer(1, 5) + player.getAttack()/2;
                System.out.printf("\nYou deal %s damage!\n", attackDamage);
                enemy.setHealth(enemy.getHealth() - attackDamage);
                if (enemy.getHealth() > 0) {
                    int retaliationDamage;
                    if (enemy.boss) {
                        retaliationDamage = randomizer(5, 15 + player.getLevel()) + player.getLevel();
                    } else {
                        retaliationDamage = randomizer(1, 5) + (player.getLevel() * 2);
                    }
                    player.setHealth(player.getHealth() - retaliationDamage);
                    System.out.printf("The enemy retaliates dealing %s damage!\n\n", retaliationDamage);
                }
                return fighter(enemy, player);
            } else if (response.equalsIgnoreCase("D") && player.getPotions() > 0) {
                player.setPotions(player.getPotions() - 1);
                player.setHealth(player.getHealth() + 20);
                int retaliationDamage;
                if (enemy.boss) {
                    retaliationDamage = randomizer(5, 15 + player.getLevel()) + player.getLevel();
                } else {
                    retaliationDamage = randomizer(1, 5) + (player.getLevel() * 2);
                }
                System.out.printf("\nYou drink a potion restoring 20 health.\nThe enemy retaliates dealing %s damage!\n\n", retaliationDamage);
                player.setHealth(player.getHealth() - retaliationDamage);
                return fighter(enemy, player);
            } else if (response.equalsIgnoreCase("D") && player.getPotions() <= 0) {
                System.out.print(ANSI_RED + "\nNo potions available\n" + ANSI_RESET);
                return fighter(enemy, player);
            } else if (!response.equalsIgnoreCase("D") && !response.equalsIgnoreCase("A")) {
                System.out.print(ANSI_RED + "\nInvalid input. Try Again.\n" + ANSI_RESET);
                return fighter(enemy, player);
            }
            return player;
        }
    }

    public static Character PotionsGoldXPKills(Character player, Enemy enemy) {
        player.setKills(player.getKills() + 1);
        String potionOut = "";
        String goldOut = "";
        int potionRoll = randomizer(1, 3);
        if (potionRoll == 2) {
            player.setPotions(player.getPotions() + 1);
            potionOut = "Potion found! ";
        } else {
            potionOut = ANSI_RED + "No potion found" + ANSI_RESET + ". ";
        }
        int xpRoll;
        int goldRoll;
        if (enemy.boss) {
//            xpRoll = randomizer(100, 125);
            xpRoll = 150 * player.getLevel();
            player.setTotalXP(player.getTotalXP() + xpRoll);
            player.setXpToLevel(player.getXpToLevel() + xpRoll);
            goldRoll = randomizer(35, 50);
            player.setGold(player.getGold() + goldRoll);
            goldOut = ANSI_YELLOW + enemy.getName() + ANSI_RESET + " dropped " + ANSI_YELLOW + goldRoll + " gold!" + ANSI_RESET;
        } else {
            xpRoll = randomizer(50, 65);
            player.setTotalXP(player.getTotalXP() + xpRoll);
            player.setXpToLevel(player.getXpToLevel() + xpRoll);
            goldRoll = randomizer(10, 20);
            player.setGold(player.getGold() + goldRoll);
            goldOut = "The enemy dropped " + ANSI_YELLOW + goldRoll + " gold" + ANSI_RESET+"!";
        }
        System.out.println("\n"+potionOut + goldOut + " Experience Gained: " + ANSI_CYAN + xpRoll + " XP" + ANSI_RESET +"!\n");
        if (player.getXpToLevel() > (100 * player.getLevel())) {
            System.out.println(player.getName() + " shivers as a new found power is felt." + ANSI_BLUE + " You Level Up!\n" + ANSI_RESET);
            player.setHealthMax(player.getHealthMax() + 10);
            player.setHealth(player.getHealthMax());
            player.setXpToLevel(player.getXpToLevel() - (100 * player.getLevel()));
            player.setLevel(player.getLevel() + 1);
        }
        return player;
    }

    public static String enemyRandomizer(int playerLevel) {
        String enemy = "";
        int randomNumber = randomizer(1, 15);
        if (playerLevel % 2 == 0) {
            switch (randomNumber) {
                case 1:
                    enemy = "Valik, The Titan Prime";
                    break;
                case 2:
                    enemy = "Scorn, The Minotaur Warlord";
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
                    enemy = "Xilon, The Undead Kraken";
                    break;
                case 7:
                    enemy = "Inferno The Ancient Dragon";
                    break;
                case 8:
                    enemy = "Grime, The Impeccable";
                    break;
                case 9:
                    enemy = "Malkov, The Shapeshifter";
                    break;
                case 10:
                    enemy = "Jack the Pumpkin King";
                    break;
                case 11:
                    enemy = "Malnir, The Exiled King";
                    break;
                case 12:
                    enemy = "Varkliv, The Defiler";
                    break;
                case 13:
                    enemy = "Suzo, The BladeMaster";
                    break;
                case 14:
                    enemy = "Talon, The Phoenix";
                    break;
                case 15:
                    enemy = "Carvos, The Torturer";
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
                case 11:
                    enemy = "a hellhound!";
                    break;
                case 12:
                    enemy = "a draugr!";
                    break;
                case 13:
                    enemy = "a morphed leech!";
                    break;
                case 14:
                    enemy = "a goblin!";
                    break;
                case 15:
                    enemy = "a cursed beggar!";
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
        int encounter = randomizer(1, 2);
        int randomLand = randomizer(1, 10);
        String playerChoice;
        switch (randomLand) {
            case 1:
                System.out.println("\nYou come upon 2 tunnel entrances...");
                System.out.println("Would you like to go left or right? [left/right]");
                playerChoice = choice.nextLine();
                break;
            case 2:
                System.out.println("\nYou pass a locked stone door, but luckily you have magic pocket fuzz...");
                System.out.println("Would you like to pick the lock? [y/N]");
                playerChoice = choice.nextLine();
                break;
            case 3:
                System.out.println("\nYou hear whispering escaping from a crack just big enough to squeeze through...");
                System.out.println("Investigate? [y/N]");
                playerChoice = choice.nextLine();
                break;
            case 4:
                System.out.println("\nThe walls tremble as someone cries out \"" + player.getName().toUpperCase() + "\"!");
                System.out.println("Hurry to their aid? [y/N]");
                playerChoice = choice.nextLine();
                break;
            case 5:
                System.out.println("\nAs you continue to walk you sense you're not alone...");
                System.out.println("Cast a spell to see what's there? [y/N]");
                playerChoice = choice.nextLine();
                break;
            case 6:
                System.out.println("\nA small ball of light whips past you, illuminating a small passage.");
                System.out.println("Follow your new found friend? [y/N]");
                playerChoice = choice.nextLine();
                break;
            case 7:
                System.out.println("\nYou stumble upon a large body of water with a boat sitting on shore.\nThere's something glowing on the island in the center of the lake... ");
                System.out.println("Would you like to take the boat and check out the mysterious light? [y/N]");
                playerChoice = choice.nextLine();
//                if (playerChoice.equalsIgnoreCase("y")) {
//                    enemy = "watery " + enemy;
//                }
                break;
            case 8:
                System.out.println("\nYou stumble and grab the wall to steady yourself, your hand sinks into the stone and the wall splits to your left. A stairwell is revealed...");
                System.out.println("Take the uncovered passage? [y/N]");
                playerChoice = choice.nextLine();
                break;
            case 9:
                System.out.println("\nYour mind wanders as the path continues, a warm voice beckons you to stray into the darkness.\n");
                System.out.println("Resist against the voice? [y/N]");
                playerChoice = choice.nextLine();
                break;
            case 10:
                System.out.println("\nYou stiffen as you hear something rush towards you from behind.");
                System.out.println("Turn around to see what's there? [y/N]");
                playerChoice = choice.nextLine();
                break;
            default:
                playerChoice = "Nothing";
                break;
        }
        if (encounter == 1) {
            String enemy = enemyRandomizer(player.getLevel());
            if (player.getLevel() % 2 == 0) {
                System.out.println("\nYou encounter " + colorRandomizer()+enemy+ANSI_RESET+"!");
            } else {
                System.out.println("\nYou encounter " + enemy);
            }
            return enemy;
        } else {
            return "No Enemy";
        }

    }

    public static Character lootGenerator(Character player) {
        int randomNumber = randomizer(1, 5);
        int randomGold = randomizer(5, 20);
        int randomXP = randomizer(10, 35);
        switch (randomNumber) {
            case 1:
                System.out.println("\nSurge Potion Found!\n");
                player.setSurgePotions(player.getSurgePotions() + 1);
                break;
            case 2:
                System.out.println("\nYou found "+randomGold+" gold!\n");
                player.setGold(player.getGold() + randomGold);
                break;
            case 3:
                System.out.println("\nYou continue on your quests unperturbed.\n");
                break;
            case 4:
                System.out.println("\nSomething quickly skitters across the ground as you feel something around you waist. The creature vanishes before you can see what it is.\n");
                if (player.getPotions() == 0) {
                    System.out.println("You check your belongings, nothing seems to be missing...\n");
                } else {
                    System.out.println("Checking your health potions you notice one has been stolen!\n");
                }
                player.setPotions(player.getPotions() - 1);
                break;
            case 5:
                System.out.println("\nYou found a Knowledge Crystal! You gained "+randomXP+" XP!\n");
                player.setXpToLevel(player.getXpToLevel() + randomXP);
                break;
            default:
                break;
        }
        return player;

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





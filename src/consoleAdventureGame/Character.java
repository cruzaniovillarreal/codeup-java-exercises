package consoleAdventureGame;

public class Character {
    private String name;
    private int health;
    private int healthMax;
    private int potions;
    private int surgePotions;
    private int kills;
    private int totalXP;
    private int xpToLevel;
    private int level;
    private int gold;
    private int attack;
    private int defense;
    private int agility;

    public Character(String name, int health, int potions, int attack, int defense, int agility) {
        this.name = name;
        this.health = health;
        this.healthMax = health;
        this.potions = potions;
        this.kills = 0;
        this.level = 1;
        this.gold = 0;
        this.totalXP = 0;
        this.xpToLevel = 0;
        this.attack = attack;
        this.defense = defense;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public void setHealthMax(int healthMax) {
        this.healthMax = healthMax;
    }

    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public int getSurgePotions() {
        return surgePotions;
    }

    public void setSurgePotions(int surgePotions) {
        this.surgePotions = surgePotions;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getTotalXP() {
        return totalXP;
    }

    public void setTotalXP(int totalXP) {
        this.totalXP = totalXP;
    }

    public int getXpToLevel() {
        return xpToLevel;
    }

    public void setXpToLevel(int xpToLevel) {
        this.xpToLevel = xpToLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
}

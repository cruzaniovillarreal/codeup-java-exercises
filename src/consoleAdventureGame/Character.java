package consoleAdventureGame;

public class Character {
    protected String name;
    protected int health;
    protected int healthMax;
    protected int potions;
    protected int surgePotions;
    protected int kills;
    protected int totalXP;
    protected int xpToLevel;
    protected int level;
    protected int gold;
    protected int attack;
    protected int defense;
    protected int agility;

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
}

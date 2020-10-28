public class Character {
    protected String name;
    protected int health;
    protected int potions;
    protected int kills;
    protected int totalXP;
    protected int xpToLevel;
    protected int level;
    protected int gold;
    protected int attack;
    protected int defense;
    protected int agility;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.potions = 5;
        this.kills = 0;
        this.level = 1;
        this.gold = 0;
        this.totalXP = 0;
        this.xpToLevel = 0;
        this.attack = 1;
        this.defense = 1;
        this.agility = 1;

    }
}

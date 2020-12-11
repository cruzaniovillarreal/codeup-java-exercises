package consoleAdventureGame;

public class Enemy {
    private String name;
    private int health;
    private int maxHealth;
    private int heal;
    private int attack;
    private int defense;
    private int damage;
    boolean boss = false;

    public Enemy(String name, int maxHealth, int heal, int attack, int defense, int damage, boolean isBoss) {
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.heal = heal;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.boss = isBoss;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHeal() {
        return heal;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getDamage() {
        return damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void heal() {
        this.health += this.heal;
    }
}

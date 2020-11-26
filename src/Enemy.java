public class Enemy {
    private int health;
    private int maxHealth;
    private int heal;
    private int attack;
    private int defense;
    private int damage;

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
}

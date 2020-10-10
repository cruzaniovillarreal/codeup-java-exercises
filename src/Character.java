public class Character {
    protected String name;
    protected int health;
    protected int potions;
    protected int kills;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.potions = 5;
        this.kills = 0;
    }
}

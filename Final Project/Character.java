public abstract class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected int defense;
    protected int speed;
    protected String specialMoveName;
    protected int specialMovePower;
    protected int turnsTaken;
    protected boolean specialUsedLastTurn;

    public Character(String name, int maxHealth, int attackPower, int defense, int speed,
                     String specialMoveName, int specialMovePower) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackPower = attackPower;
        this.defense = defense;
        this.speed = speed;
        this.specialMoveName = specialMoveName;
        this.specialMovePower = specialMovePower;
        this.turnsTaken = 0;
        this.specialUsedLastTurn = false;
    }

    public abstract String attack(Character target);
    public abstract String specialMove(Character target);

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - defense);
        health = Math.max(0, health - actualDamage);
    }

    public String getStatus() {
        return name + " HP: " + health + "/" + maxHealth;
    }
    public void heal(int amount) {
    health = Math.min(maxHealth, health + amount);
}
}
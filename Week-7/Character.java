public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = Math.max(0, maxHealth);
        this.health = this.maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        System.out.println("Character created with maxHealth: " + c.getMaxHealth() + ", initial health: " + c.getHealth());

        c.takeDamage(30);
        System.out.println("c.takeDamage(30) -> health = " + c.getHealth());

        c.heal(50);
        System.out.println("c.heal(50) -> health = " + c.getHealth() + " (capped)");

        c.takeDamage(150);
        System.out.println("c.takeDamage(150) -> health = " + c.getHealth() + " (floored)");
    }
}

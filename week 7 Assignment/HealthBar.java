public class HealthBar {

    private int health;
    private final int maxHealth;

    public HealthBar(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {

        if (amount > 0) {
            health = health - amount;

            if (health < 0) {
                health = 0;
            }
        }
    }

    public void heal(int amount) {

        if (amount > 0) {
            health = health + amount;

            if (health > maxHealth) {
                health = maxHealth;
            }
        }
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {

        HealthBar c = new HealthBar(100);

        c.takeDamage(30);
        System.out.println("Health after damage: " + c.getHealth());

        c.heal(50);
        System.out.println("Health after healing: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("Health after extra damage: " + c.getHealth());
    }
}
package components;

public class Living {
    private float maxHealth;
    private float health;

    public Living(float maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void damage(float damage) {
        float health = getHealth();
        health -= damage;

        if (isDead()) health = 0;
    }

    public float getHealth() {
        return health;
    }

    public boolean isDead() {
        return health <= 0;
    }
}

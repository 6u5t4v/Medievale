package components;

public class Attributes {
    private int strength;
    private int movementSpeed;

    public Attributes() {
        this.strength = 1;
        this.movementSpeed = 1;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
}

package character;

import core.GameEngine;

public abstract class Character {

    // Attributes all characters have
    public String name;
    public int maxHealth, health, xp;
    Alignment alignment;

    // Enum to set up alignment
    public enum Alignment {
        MAAT("Order, harmony, and balance"),
        APEP("Chaos, destruction, and imbalance"),
        NONE("Default Enemy Alignment");

        private final String description;

        // Constructor
        Alignment(String description) {
            this.description = description;
        }

        // Getter to output description
        public String getDescription() {
            return description;
        }
    }

    // Constructor
    public Character(String name, int maxHealth, int xp, Alignment alignment){
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;  // health starts as maxHealth
        this.xp = xp;
        this.alignment = alignment;
    }

    // Methods every character has
    public abstract int attack();
    public abstract int defend();

    // Getter methods for attributes
    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getXp() {
        return xp;
    }

    public Alignment getAlignment() {
        return alignment;
    }
}



package character;

import static character.Character.Alignment.NONE;

public class Enemy extends Character {

    // Integer to store player's current xp
    int playerXP;


    public Enemy(String name, int playerXP) {
        // name, maxHealth, XP
        super(name, (int) (Math.random()*playerXP + (double) playerXP /3 + 5), (int) (Math.random()*((double) playerXP /4 + 2) + 1), NONE);

        // Assigning variable
        this.playerXP = playerXP;
    }

    @Override
    public int attack() {
        return (int) (Math.random() * ((double) playerXP /4 + 1) + (double) xp /4 + 6);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * ((double) playerXP /4 + 1) + (double) xp /4 + 3);
    }
}

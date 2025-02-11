package character;

import core.GameEngine;

public class Player extends Character {

    // Integers to store # of attack/defense upgrades
    public int numAtkUpgrades, numDefUpgrades;

    // Additional player stats
    public int gold, restsLeft, pots;

    // Player attack upgrades
    public String[] atkUpgrades = {
            "Bladed Momentum: Hit your target twice in one turn!",
            "Razor Edge Strike: A precision strike that cuts deeper, causing extra damage!",
            "Savage Precision: Attack with deadly accuracy, dealing critical damage!",
            "Sands of Agony: Unleash a flurry of strikes that leave the target in pain, lowering their defense!"
    };

    public String[] defUpgrades = {
            "Fortress Wall: Summon an impenetrable stone barrier that shields you from all incoming attacks for one turn!",
            "Iron Hide: Your skin hardens like iron, reducing all incoming damage by half!",
            "Desert Resilience: Absorb the harshest blows, gaining temporary resistance to all attacks!",
            "Toughened Skin: Your body becomes tougher, reducing physical damage taken by 25%!"
    };


    // Player specific constructor
    public Player(String name, Alignment align){
        super(name, 100, 0, align);

        // Setting # of attack/defense upgrades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;

        // Set additional stats
        this.gold = 5;
        this.restsLeft = 1;
        this.pots = 0;

        // Let player choose which atk/def trait they want
        chooseTrait();
    }


    // Player specific methods

    @Override
    public int attack() {
        return (int) (Math.random()*((double) xp /4 + numAtkUpgrades*3 + 3) + (double) xp /10 + numAtkUpgrades*2 + numAtkUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*((double) xp /4 + numDefUpgrades*3 + 3) + (double) xp /10 + numDefUpgrades*2 + numDefUpgrades + 1);
    }

    // Function to allow player to choose trait for new character
    public void chooseTrait(){
        GameEngine.clearConsole();
        GameEngine.printHeader("Choose a trait:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);

        // Get player choice
        int input = GameEngine.readIn("->", 2);
        GameEngine.clearConsole();

        // Deal with both cases
        if(input == 1){
            GameEngine.printHeader("You chose " + atkUpgrades[numAtkUpgrades]);
            numAtkUpgrades++;
        } else {
            GameEngine.printHeader("You chose " + defUpgrades[numDefUpgrades]);
            numDefUpgrades++;
        }
        GameEngine.waitAnything();
    }

    // only player has mana
}

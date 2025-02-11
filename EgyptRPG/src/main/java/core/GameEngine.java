package core;

import java.util.Scanner;
import character.*;
import character.Character;

public class GameEngine {

    // Player object
    static Player player;

    // Scanner object to handle inputs
    static Scanner scanner = new Scanner(System.in);

    // Boolean to handle game loop
    public static boolean isRunning;

    // Random encounters
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};

    // Enemy names
    public static String[] enemies = {"Bandit", "Bandit", "Rebel", "Rebel", "Scorched Serpent"};

    // Story elements
    public static int place = 0, act = 1;
    public static String[] places = {"The Arena", "Thebes", "Desert Temple", "Memphis", "Stronghold"};

    // Method to read in input
    public static int readIn(String prompt, int userChoices){
        int input; // Integer input

        // Loop until the user provides a valid input within the specified range
        do {
            System.out.println(prompt); // Display prompt to the user

            try {
                String userInput = scanner.next(); // Read the user's input
                input = Integer.parseInt(userInput); // Attempt to convert input to integer

                // Check if the input is within the valid range
                if (input < 1 || input > userChoices) {
                    throw new IllegalArgumentException("Please enter a valid input");
                }
            } catch (Exception e) {
                input = -1; // Set input to -1 to re-enter the loop
                System.out.println("Please enter a valid input"); // Prompt user for valid input
            }
        } while (input < 1 || input > userChoices); // Loop will continue until valid input is provided
        return input;
    }

    // Function to simulate clearing the console
    public static void clearConsole() {
        // Print empty lines to clear the console screen
        for (int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
    }

    // Function to print a line break with length n
    public static void printBreak(int n){
        for (int i = 0; i <= n; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    // Function to print a header
    public static void printHeader(String title){
        printBreak(30);
        System.out.println(title);
        printBreak(30);
    }

    // Function to wait for user input
    public static void waitAnything(){
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }

    // Function to start the game
    public static void startGame(){
        boolean nameSet = false;
        boolean alignSet = false;
        String name;
        Character.Alignment align = null;

        // Print title screen
        clearConsole();
        printBreak(50);
        System.out.println("SANDS OF DAWN");
        System.out.println("TEXT RPG BY SHAIKH HAMID");
        printBreak(50);
        waitAnything();

        // Loop to set name
        do{
            clearConsole();
            printHeader("What's your name?");
            name = scanner.next();

            // Confirming choice
            clearConsole();
            System.out.println("Your name is: " + name + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            int input = readIn("-> ", 2);
            if(input == 1){
                nameSet = true;
            }
        }while(!nameSet);

        // Loop to set alignment
        do{
            clearConsole();
            printHeader("Which god would you like to align with?");
            System.out.println("(1) APEP: " + Character.Alignment.APEP.getDescription());
            System.out.println("(2) MAAT: " + Character.Alignment.MAAT.getDescription());
            int input = readIn("-> ", 2);
            if(input == 1){ // Aligned with Apep
                System.out.println("Your fate is sealed. Go forth, " + name + ", with Apep--god of chaos.");
                align = Character.Alignment.APEP;
                waitAnything();
                alignSet = true;
            } else if (input == 2) { // Aligned with Maat
                System.out.println("Your fate is sealed. Go forth, " + name + ", with Maat--goddess of order.");
                align = Character.Alignment.MAAT;
                waitAnything();
                alignSet = true;
            }
        }while(!alignSet);

        // Print story intro
        Story.printIntro(player);
        // Create player object with that name
        player = new Player(name, align);
        // Print first story act intro
        Story.printFirstActIntro();
        // Set isRunning to true
        isRunning = true;
        // Start main game loop
        gameLoop();
    }

    // Function to change game's values based on player xp
    public static void checkAct(){
        if(player.xp >= 10 && act == 1){
            // Update location
            act = 2;
            place = 1; // Thebes
            // Update story
            Story.printFirstActOutro();
            // Player level up
            player.chooseTrait();
            // Update story
            Story.printSecondActIntro();
            // Assign new values to enemies
            enemies[0] = "Bandit";
            enemies[1] = "Thief";
            enemies[2] = "Bandit Chief";
            enemies[3] = "Militia Guard";
            enemies[4] = "Priest of Ra";
            // Assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
            // Fully heal the player
            player.health = player.maxHealth;
        } else if (player.xp >= 50 && act == 2){
            // Update location
            act = 3;
            place = 2; // Temple
            // Update story
            Story.printSecondActOutro();
            // Player level up
            player.chooseTrait();
            // Update story
            Story.printThirdActIntro();
            // Assign new values to enemies
            enemies[0] = "Desert Warrior";
            enemies[1] = "Cursed Priest";
            enemies[2] = "Temple Guardian";
            enemies[3] = "Scorpion King";
            enemies[4] = "Sand Demon";
            // Assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Rest";
            encounters[3] = "Shop";
            encounters[4] = "Battle";
            // Fully heal the player
            player.health = player.maxHealth;
        } else if (player.xp >= 75 && act == 3) {
            // Update location
            act = 4;
            place = 3; // Memphis
            // Update story
            Story.printThirdActOutro();
            // Player level up
            player.chooseTrait();
            // Update story
            Story.printFourthActIntro();
            // Assign new values to enemies
            enemies[0] = "Rebel Leader";
            enemies[1] = "Mummy Warrior";
            enemies[2] = "Slave Rebel";
            enemies[3] = "High Priest of Set";
            enemies[4] = "Memphis Warlord";
            // Assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Shop";
            encounters[4] = "Battle";
            // Fully heal the player
            player.health = player.maxHealth;
        } else if (player.xp >= 125 && act == 4){
            // Update location
            act = 5;
            place = 4; // Final Stronghold

            //Calling the final battle
            finalBattle();
        }
    }

    // Method to calculate a random encounter
    public static void randomEncounter(){
        // Random number between 0 and the length of the encounters array
        int encounter = (int) (Math.random() * encounters.length);

        if(encounters[encounter].equals("Battle")){
            randomBattle();
        } else if (encounters[encounter].equals("Rest")){
            takeRest();
        } else if (encounters[encounter].equals("Shop")){
            shop();
        }
    }

    // Function to continue journey (main menu option 1)
    public static void continueJourney(){
        // Check if the act must be increased
        checkAct();

        // Check if the player is in the final act
        if(act != 4){
           randomEncounter();
        }
    }

    // Function to print out player information
    public static void characterInfo(){
        GameEngine.clearConsole();
        GameEngine.printHeader("CHARACTER INFO");
        System.out.println(GameEngine.player.getName() + "\tHP: " + GameEngine.player.getHealth() + "/" + GameEngine.player.getMaxHealth());
        GameEngine.printBreak(20);
        System.out.println("XP: " + GameEngine.player.getXp() + "\tGold: " + player.gold);
        System.out.println("# of potions: " + player.pots);
        printBreak(20);

        // Printing the chosen traits
        if(GameEngine.player.numAtkUpgrades > 0){
            System.out.println("Offensive trait: " + GameEngine.player.atkUpgrades[GameEngine.player.numAtkUpgrades - 1]);
            GameEngine.printBreak(20);
        }
        if(GameEngine.player.numDefUpgrades > 0){
            System.out.println("Defensive trait: " + GameEngine.player.defUpgrades[GameEngine.player.numDefUpgrades - 1]);
            GameEngine.printBreak(20);
        }
        GameEngine.waitAnything();
    }

    // Shopping
    public static void shop(){
        clearConsole();
        printHeader("You meet a stranger with offerings.");
        int price = (int) (Math.random() *(10+player.pots*3) + 10 + player.pots);
        System.out.println("- Magic Potion: " + price + " gold.");
        printBreak(20);
        // Ask player to buy
        System.out.println("Do you want to buy one? \n (1) Yes. \n (2) No.");
        int input = readIn("->", 2);
        // If player buys
        if(input==1){
            clearConsole();
            // Check if player has gold
            if(player.gold >= price){
                System.out.println("You purchased 1 Magic Potion.");
                player.pots++;
                player.gold -= price;
            } else if (player.gold < price){
                System.out.println("You do not have sufficient funds.");
                waitAnything();
            }
        }
    }

    // Taking a rest
    public static void takeRest(){
        clearConsole();
        if(player.restsLeft >= 1){
            printHeader("Do you want to take a rest? " + player.restsLeft + " rests left");
            System.out.println("(1) Yes.\n(2) No, not now.");
            int input = readIn("->", 2);
            if(input == 1){
                // Take rest
                clearConsole();
                if(player.health < player.maxHealth){
                    int hpRestored = (int) (Math.random() * (player.xp/4 + 1) + 10);
                    player.health += hpRestored;
                    player.restsLeft--;
                    System.out.println("You have taken a rest. " + player.restsLeft + " remain.");
                    waitAnything();
                } else {
                    player.health = player.maxHealth;
                    System.out.println("You are already at full health. No rest taken. " + player.restsLeft + " rests remain.");
                    waitAnything();
                }
            }
        }
    }

    // Function for random battles
    public static void randomBattle(){
        clearConsole();
        System.out.println("You have encountered an evil minded enemy. You will have to defeat it!");
        waitAnything();
        // Create new enemy with a random name -- the array is updated based on location so no need to change anything
        battle(new Enemy(enemies[(int) (Math.random()*enemies.length)], player.xp));
    }

    // Main battle method
    public static void battle(Enemy enemy){
        while(true) { // Main battle loop
            clearConsole();
            printHeader(enemy.name + "\n HP: " + enemy.health + "/" + enemy.maxHealth);
            printHeader(player.name + "\n HP: " + player.health + "/" + player.maxHealth);
            System.out.println("Choose an action: ");
            printBreak(20);
            System.out.println("(1) Attack\n(2) Use Potion\n (3) Run Away");
            int input = readIn("->", 3);
            if(input == 1){
                // Fight
                // Calculate player and enemy damage dealt/taken
                int dmg = player.attack() - enemy.defend();
                int dmgTaken = enemy.attack() - player.defend();

                player.health -= dmgTaken;
                enemy.health -= dmg;

                // Check if damage taken is negative
                if (dmgTaken < 0){
                    // Make sure player is still damaged in any case
                    dmg -= dmgTaken/2;
                    dmgTaken = 0;
                }

                // Check if damage dealt by player is negative
                if (dmg < 0){
                    // Deal damage to both parties
                    player.health -= dmgTaken;
                    enemy.health -= dmg;
                }

                // Print out the info of this round
                clearConsole();
                printHeader("BATTLE");
                System.out.println("You dealt " + dmg + " damage to " + enemy.name + "!");
                printBreak(15);
                System.out.println(enemy.name + " dealt " + dmgTaken + " damage to you!");
                waitAnything();

                // Check if battle is over
                if (player.health <= 0){
                    playerDied();
                    break;
                } else if(enemy.health <= 0) {
                    // Tell player he won
                    clearConsole();
                    printHeader("You have defeated the " + enemy.name + "!");
                    // Increase player xp
                    player.xp += enemy.xp;
                    System.out.println("You have earned " + enemy.xp + " experience points!");
                    waitAnything();
                    // Random drops
                    boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                    int goldEarned = (int) (Math.random() * enemy.xp);
                    if(addRest){
                        player.restsLeft++;
                        System.out.println("You have earned the chance to get another rest!");
                    }
                    if(goldEarned > 0){
                        player.gold++;
                        System.out.println("You loot " + goldEarned + " gold from the " + enemy.name + "'s corpse!");
                    }
                    break;
                }
            } else if (input == 2) {
                // Use potion
                clearConsole();
                if(player.pots > 1 && player.health < player.maxHealth){
                    // Can take
                    printHeader("Are you sure you want to take a potion? " + player.pots + " remain.");
                    System.out.println("(1) Yes \n(2) No");
                    input = readIn("->", 2);
                    if(input == 1){
                        // Took
                        player.health = player.maxHealth;
                        printHeader("You have taken a magic potion. It has restored your health to " + player.maxHealth);
                        waitAnything();
                    }
                } else {
                    // Can't take
                    System.out.println("Cannot take potion. No potions remain OR already at full health.");
                    waitAnything();
                }
            } else if (input == 3) {
                if (act != 4){
                    // Cowards way out
                    clearConsole();
                    if(Math.random()*10 + 1 <= 3.5){
                        printHeader("You ran away from the " + enemy.name +"!");
                        waitAnything();
                        break;
                    } else {
                        printHeader("You didn't manage to escape.");
                        // Calculate damage taken
                        int dmgTaken = enemy.attack();
                        System.out.println("In your hurry you took " + dmgTaken + " damage!");
                        waitAnything();
                    }
                } else {
                    printHeader("YOU CANNOT ESCAPE THIS BATTLE!!!");
                    waitAnything();
                }
            }
        }

    }

    // Function to print the main menu
    public static void printMenu(){
        GameEngine.clearConsole();
        GameEngine.printHeader(places[place]);
        System.out.println("Choose an action:");
        GameEngine.printBreak(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }

    // Final battle method
    public static void finalBattle(){
        // Creating the rival god and letting player fight against him
        battle(new Enemy("RIVAL GOD", 300));
        // Printing final ending
        Story.printEnd(player);
        isRunning = false;
    }

    // Method to call when player died
    public static void playerDied(){
        clearConsole();
        printHeader("You died...");
        printHeader("You earned " + player.xp + " experience points on your journey.");
        System.out.println("Try to earn more next time!");
        isRunning = false;
    }

    // Main game loop function
    public static void gameLoop(){
        while(GameEngine.isRunning){
            printMenu();
            int input = GameEngine.readIn("-> ", 3);
            if(input == 1){
                continueJourney();
            } else if(input == 2){
                characterInfo();
            } else {
                GameEngine.isRunning = false;
            }
        }
    }
}

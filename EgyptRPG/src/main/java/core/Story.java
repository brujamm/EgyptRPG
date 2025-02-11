package core;

import character.Player;

// Class that stores methods to print out every part of the story
public class Story {

    public static void printIntro(Player player){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("STORY");
        GameEngine.printBreak(30);
        System.out.println("You are the champion of one of the gods.");
        System.out.println("A war is raging between Maat and Apep.");
        System.out.println("As champion, you must fight on one of their behalf in the mortal realm.");
        GameEngine.waitAnything();
    }

    public static void printFirstActIntro(){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("ACT I INTRO");
        GameEngine.printBreak(30);
        System.out.println("Your first quest is to enter The Arena and prove your worth.");
        System.out.println("You've heard many things about The Arena, about how dangerous it is--many enter, few exit.");
        System.out.println("Disregarding any doubts, you force your way through the crowd into The Arena.");
        System.out.println("\nOnce you have fought your way through, your true path will be revealed.");
        GameEngine.waitAnything();
    }

    public static void printFirstActOutro(){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("ACT I OUTRO");
        GameEngine.printBreak(30);
        System.out.println("You did it! You defeated your enemies in The Arena and exited victorious.");
        System.out.println("Now, the next step has been revealed: continue through Egypt to exterminate the rival god's threats to the world.");
        System.out.println("\nAfter a long day of walking around, you find yourself in the city of Thebes.");
        System.out.println("A grand, sprawling city, it is the capital of the desert kingdom. However, it is currently overrun by bandits and militias.");
        System.out.println("");
        GameEngine.waitAnything();
    }

    public static void printSecondActIntro(){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("ACT II INTRO");
        GameEngine.printBreak(30);
        System.out.println("After your victory in The Arena, whispers of trouble in Thebes reach your ears.");
        System.out.println("Thebes, the great city, is plagued by a growing bandit force that threatens its people and resources.");
        System.out.println("As a champion, you decide to march to Thebes and bring order back to the city.");
        System.out.println("\nYour journey begins with crossing the desert and preparing for the unexpected challenges Thebes holds.");
        GameEngine.waitAnything();
    }

    public static void printSecondActOutro(){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("ACT II OUTRO");
        GameEngine.printBreak(30);
        System.out.println("Thebes stands tall once more under your protection. The bandits have been eradicated, and the city's streets are safe again.");
        System.out.println("Your reputation as a champion of the gods grows, and the people of Thebes hail you as their savior.");
        System.out.println("\nHowever, your journey is far from over. Whispers of more significant threats linger, and your path takes you deeper into Egypt's mysteries.");
        GameEngine.waitAnything();
    }

    public static void printThirdActIntro(){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("ACT III INTRO");
        GameEngine.printBreak(30);
        System.out.println("You've successfully cleared Thebes of the bandit menace. But the true battle lies ahead.");
        System.out.println("The city whispers of a sacred temple deep in the desert, where powerful enemies gather to challenge the gods themselves.");
        System.out.println("You must venture out, defeat the desert beasts, and reach the temple to confront these vile threats.");
        System.out.println("\nOnly by doing so will you earn the favor of the gods and advance your cause.");
        GameEngine.waitAnything();
    }

    public static void printThirdActOutro(){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("ACT III OUTRO");
        GameEngine.printBreak(30);
        System.out.println("The temple has been cleansed. The desert beasts have fallen before you, and your name spreads as a symbol of power.");
        System.out.println("In the heart of the desert, you have earned a powerful relic, and now the rival god's forces tremble.");
        System.out.println("\nReturning to Thebes, you receive news of a rebellion rising in the distant city of Memphis. You must quell this rebellion.");
        GameEngine.waitAnything();
    }

    public static void printFourthActIntro(){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("ACT IV INTRO");
        GameEngine.printBreak(30);
        System.out.println("Memphis is in chaos. Rebellions have torn the city apart, and the rival god's followers are pushing back against your efforts.");
        System.out.println("You must infiltrate the city, eliminate the rebellion's leaders, and restore order before the rival god gains full control.");
        System.out.println("\nThe streets are filled with danger, but your mission is clear. Only by overcoming this challenge will you secure your place in the battle for Egypt.");
        GameEngine.waitAnything();
    }

    public static void printFourthActOutro(){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("ACT IV OUTRO");
        GameEngine.printBreak(30);
        System.out.println("The rebellion in Memphis has been crushed. Your name is now feared and respected across Egypt.");
        System.out.println("The rival god's influence in the city is destroyed, but there are still more threats to face.");
        System.out.println("\nAs you stand over the ruins of the rebellion, you receive a vision—a final showdown awaits at the rival god's stronghold in the heart of Egypt.");
        GameEngine.waitAnything();
    }

    public static void printFifthActIntro(){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("ACT V INTRO");
        GameEngine.printBreak(30);
        System.out.println("You've reached the rival god's stronghold. The final battle for Egypt's future is at hand.");
        System.out.println("Inside the dark temple, the rival god waits for you, surrounded by their most loyal followers and fiercest warriors.");
        System.out.println("\nThe gods will decide who is worthy. You must defeat them all if you are to claim your rightful place as the ruler of Egypt.");
        GameEngine.waitAnything();
    }

    public static void printFifthActOutro(){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("ACT V OUTRO");
        GameEngine.printBreak(30);
        System.out.println("The rival god has fallen. With their defeat, Egypt is once again at peace.");
        System.out.println("Your strength and determination have proven you worthy of divine power, and now, you rule as the god of Egypt.");
        System.out.println("\nThe people of Egypt kneel before you, their new ruler. The gods themselves acknowledge your reign.");
        GameEngine.waitAnything();
    }

    public static void printEnd(Player player){
        GameEngine.clearConsole();
        GameEngine.printBreak(30);
        System.out.println("Thank you for playing this game!");
        System.out.println("This game was developed by Shaikh Hamid");
        System.out.println("I hope you enjoyed it!");
    }
}

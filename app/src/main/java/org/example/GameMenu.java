
package org.example;

import java.util.Scanner;

public class GameMenu {
    public void displayMenu() {
        System.out.println("1. Purchase Ingredients");
        System.out.println("2. Tweak the Recipe");
        System.out.println("3. Set the Price");
        System.out.println("4. Make Pitchers of Lemonade");
        System.out.println("5. Move Onto the Selling Phase");
        System.out.println("6. Quit");
    }

    public int getChoice(Scanner scanner) {
        System.out.print("What would you like to do? ");
        return scanner.nextInt();
    }
}

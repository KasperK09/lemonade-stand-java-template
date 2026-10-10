package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = 100.00;
        int lemons = 0;
        int sugar = 0;
        int pitchers = 0;
        int day = 1;

        System.out.println("Welcome to My Lemonade Stand!");

        boolean playing = true;

        while (playing) {
            System.out.println("\nDay " + day + ": Preparation Phase");
            System.out.println("Cash: $" + money);
            System.out.println("Lemons: " + lemons);
            System.out.println("Sugar: " + sugar);
            System.out.println("Pitchers: " + pitchers);

            System.out.println("1. Purchase Ingredients");
            System.out.println("2. Tweak the Recipe");
            System.out.println("3. Set the Price");
            System.out.println("4. Make Pitchers");
            System.out.println("5. Start Selling");
            System.out.println("6. Quit");

            System.out.print("What would you like to do? ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Ingredient purchasing goes here.");
            } else if (choice == 2) {
                System.out.println("Recipe settings go here.");
            } else if (choice == 3) {
                System.out.println("Price settings go here.");
            } else if (choice == 4) {
                System.out.println("Making lemonade goes here.");
            } else if (choice == 5) {
                System.out.println("Selling lemonade goes here.");
                day++;
            } else if (choice == 6) {
                playing = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
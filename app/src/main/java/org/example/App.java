
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

        // Recipe for one pitcher
        int lemonsPerPitcher = 0;
        int sugarPerPitcher = 0;
        int waterPerPitcher = 0;

        System.out.println("Welcome to My Lemonade Stand!");

        boolean playing = true;

        while (playing) {
            System.out.println("\nDay " + day + ": Preparation Phase");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Lemons: " + lemons);
            System.out.println("Sugar (Cups): " + sugar);
            System.out.println("Water (Cups): Infinity");
            System.out.println("Current Pitchers: " + pitchers);
            System.out.printf("Cash: $%.2f%n", money);

            System.out.println("1. Purchase Ingredients");
            System.out.println("2. Tweak the Recipe");
            System.out.println("3. Set the Price");
            System.out.println("4. Make Pitchers of Lemonade");
            System.out.println("5. Move Onto the Selling Phase");
            System.out.println("6. Quit");

            System.out.print("What would you like to do? ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Lemons are $1 each");
                System.out.println("Sugar is $0.50 per cup");

                System.out.print("How many lemons do you want to buy? ");
                int lemonsToBuy = scanner.nextInt();

                System.out.print("How many cups of sugar do you want to buy? ");
                int sugarToBuy = scanner.nextInt();

                if (lemonsToBuy < 0 || sugarToBuy < 0) {
                    System.out.println("You cannot buy negative ingredients!");
                } else {
                    double cost = lemonsToBuy + (sugarToBuy * 0.50);

                    if (cost > money) {
                        System.out.println("You do not have enough money!");
                    } else {
                        lemons = lemons + lemonsToBuy;
                        sugar = sugar + sugarToBuy;
                        money = money - cost;

                        System.out.println("Great! Transaction complete!");
                    }
                }

            } else if (choice == 2) {
                // Set the recipe for one pitcherr
                System.out.print("How many lemons do you want per pitcher? ");
                int newLemons = scanner.nextInt();

                System.out.print("How many cups of sugar do you want per pitcher? ");
                int newSugar = scanner.nextInt();

                System.out.print("How many cups of water do you want per pitcher? ");
                int newWater = scanner.nextInt();

                if (newLemons < 0 || newSugar < 0 || newWater < 0) {
                    System.out.println("Recipe amounts cannot be negative!");
                } else {
                    lemonsPerPitcher = newLemons;
                    sugarPerPitcher = newSugar;
                    waterPerPitcher = newWater;

                    System.out.println("Great! Your recipe is set!");
                }

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

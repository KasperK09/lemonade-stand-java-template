
package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LemonadeStand stand = new LemonadeStand();
        Recipe recipe = new Recipe();
        IngredientShop shop = new IngredientShop();
        GameMenu menu = new GameMenu();

        boolean playing = true;

        System.out.println("Welcome to My Lemonade Stand!");

        while (playing) {
            stand.displayStatus();
            menu.displayMenu();

            int choice = menu.getChoice(scanner);

            if (choice == 1) {
                shop.purchaseIngredients(scanner, stand);

            } else if (choice == 2) {
                System.out.print(
                        "How many lemons per pitcher? ");
                int lemons = scanner.nextInt();

                System.out.print(
                        "How many cups of sugar per pitcher? ");
                int sugar = scanner.nextInt();

                System.out.print(
                        "How many cups of water per pitcher? ");
                int water = scanner.nextInt();

                recipe.setRecipe(lemons, sugar, water);

            } else if (choice == 3) {
                System.out.println("Price settings go here.");

            } else if (choice == 4) {
                System.out.println("Making lemonade goes here.");

            } else if (choice == 5) {
                System.out.println("Selling lemonade goes here.");
                stand.nextDay();

            } else if (choice == 6) {
                playing = false;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}

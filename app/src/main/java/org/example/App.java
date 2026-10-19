
package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LemonadeStand stand = new LemonadeStand();
        Recipe recipe = new Recipe();
        IngredientShop shop = new IngredientShop();
        GameMenu menu = new GameMenu();
        PriceManager priceManager = new PriceManager();
        SellingPhase sellingPhase = new SellingPhase();
        LemonadeMaker lemonadeMaker = new LemonadeMaker();

        boolean playing = true;

        System.out.println("Welcome to My Lemonade Stand!");

        while (playing) {
            stand.displayStatus(priceManager.getPrice());
            menu.displayMenu();

            int choice = menu.getChoice(scanner);

            if (choice == 1) {
                shop.purchaseIngredients(scanner, stand);

            } else if (choice == 2) {
                System.out.print("How many lemons do you want per pitcher? ");
                int lemons = scanner.nextInt();

                System.out.print("How many cups of sugar do you want per pitcher? ");
                int sugar = scanner.nextInt();

                System.out.print("How many cups of water do you want per pitcher? ");
                int water = scanner.nextInt();

                recipe.setRecipe(lemons, sugar, water);

            } else if (choice == 3) {
                priceManager.setPrice(scanner);

            } else if (choice == 4) {
                lemonadeMaker.makePitchers(scanner, stand, recipe);

            } else if (choice == 5) {
                sellingPhase.sellLemonade(stand, priceManager);
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

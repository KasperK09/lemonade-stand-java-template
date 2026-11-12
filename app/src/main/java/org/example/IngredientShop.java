
package org.example;

import java.util.Scanner;

public class IngredientShop {
    public void purchaseIngredients(
            Scanner scanner, LemonadeStand stand, PriceManager priceManager) {

        System.out.printf("Lemons are $%.2f each%n", priceManager.getLemonPrice());
        System.out.printf("Sugar is $%.2f per cup%n", priceManager.getSugarPrice());

        System.out.print("How many lemons do you want to buy? ");
        int lemonsToBuy = scanner.nextInt();

        System.out.print("How many cups of sugar do you want to buy? ");
        int sugarToBuy = scanner.nextInt();

        if (lemonsToBuy < 0 || sugarToBuy < 0) {
            System.out.println(
                    "You cannot buy negative ingredients!");
            return;
        }

        double cost = (lemonsToBuy * priceManager.getLemonPrice()) + (sugarToBuy * priceManager.getSugarPrice());

        if (cost > stand.getMoney()) {
            System.out.println("You do not have enough money!");
        } else {
            stand.addIngredients(lemonsToBuy, sugarToBuy);
            stand.spendMoney(cost);

            System.out.printf("Great! Transaction complete! Totla cost: $%.2f%n", cost);
        }
    }
}

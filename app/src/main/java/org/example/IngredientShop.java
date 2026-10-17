
package org.example;

import java.util.Scanner;

public class IngredientShop {
    public void purchaseIngredients(
            Scanner scanner, LemonadeStand stand) {

        System.out.println("Lemons are $1 each");
        System.out.println("Sugar is $0.50 per cup");

        System.out.print("How many lemons do you want to buy? ");
        int lemonsToBuy = scanner.nextInt();

        System.out.print("How many cups of sugar do you want to buy? ");
        int sugarToBuy = scanner.nextInt();

        if (lemonsToBuy < 0 || sugarToBuy < 0) {
            System.out.println(
                    "You cannot buy negative ingredients!");
            return;
        }

        double cost = lemonsToBuy + (sugarToBuy * 0.50);

        if (cost > stand.getMoney()) {
            System.out.println("You do not have enough money!");
        } else {
            stand.addIngredients(lemonsToBuy, sugarToBuy);
            stand.spendMoney(cost);

            System.out.println("Great! Transaction complete!");
        }
    }
}

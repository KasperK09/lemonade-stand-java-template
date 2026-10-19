
package org.example;

import java.util.Random;

public class SellingPhase {
    private Random random = new Random();

    public void sellLemonade(
            LemonadeStand stand, PriceManager priceManager) {

        System.out.println("\nDay " + stand.getDay() + ": Selling Phase");
        System.out.println("The customers are coming!");

        int customers = random.nextInt(500) + 1;

        int availableCups = stand.getPitchers() * 8;

        int cupsSold = Math.min(customers, availableCups);

        double earnings = cupsSold * priceManager.getPrice();
        stand.addMoney(earnings);

        System.out.println(customers + " customers visited your stand today!");

        System.out.printf("You sold %d cups of lemonade for $%.2f.%n", cupsSold, earnings);

        int leftoverCups = availableCups - cupsSold;

        if (leftoverCups > 0) {
            int leftoverPitchers = leftoverCups / 8;
            int extraCups = leftoverCups % 8;

            System.out.println("Unfortunately, you did not sell the remaining " + leftoverPitchers + " pitchers + " + extraCups + " cups of lemonade.");
            System.out.println("That lemonade got thrown onto a potted plant. " + "The potted plant died :(");
        }

        stand.discardPitchers();

        System.out.println("Lets get a good night sleep and try again tomorrow!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}

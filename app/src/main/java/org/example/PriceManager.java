
package org.example;

import java.util.Random;
import java.util.Scanner;

public class PriceManager {
    private double price;
    private int lemonPrice;
    private int sugarPrice;

    private Random random = new Random();

    public PriceManager() {
        price = 0.00;

        lemonPrice = 100;
        sugarPrice = 50;
    }

    public void setPrice(Scanner scanner) {
        while (true) {
            System.out.print("How much will you sell one cup of lemonade for? Remember, one pitcher is 8 cups: $" );

            if (!scanner.hasNextDouble()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }

            double newPrice = scanner.nextDouble();

            if (!Double.isFinite(newPrice) || newPrice < 0) {
                System.out.println("Price must be a non-negative amount.");
            } else if (Math.abs(
                newPrice - Math.round(newPrice * 100) / 100.0) > 0.000001) {
                System.out.println("price cannot have fractions of a penny.");
            } else {
                price = newPrice;
                break;
            }
        }
        System.out.printf("Each cup of lemonade is now $%.2f and each pitcher is 8 x $%.2f = $%.2f total.%n", price, price, price * 8);
    }

    public double getPrice() {
        return price;
    }

    public double getLemonPrice() {
        return lemonPrice / 100.0;
    }

    public double getSugarPrice() {
        return sugarPrice / 100.0;
    }

    public void updateDailyPrices() {
        int oldLemonPrice = lemonPrice;
        int oldSugarPrice = sugarPrice;

        int minimumLemonPrice = (int) Math.ceil(lemonPrice * 0.95);
        int maximumLemonPrice = (int) Math.floor(lemonPrice * 1.05);

        int minimumSugarPrice = (int) Math.ceil(sugarPrice * 0.95);
        int maximumSugarPrice = (int) Math.floor(sugarPrice * 1.05);

        lemonPrice = random.nextInt(maximumLemonPrice - minimumLemonPrice + 1) + minimumLemonPrice;
        sugarPrice = random.nextInt(maximumSugarPrice - minimumSugarPrice + 1) + minimumSugarPrice;

        System.out.printf("Todays price of lemons is $%.2f per lemon. ", getLemonPrice());
        
        if (lemonPrice > oldLemonPrice) {
            System.out.printf("This price is up from yesterdays price of $%.2f.%n", oldSugarPrice / 100.0);
        } else if (sugarPrice < oldSugarPrice) {
            System.out.printf("This is down from yesterday's price of $%.2f.%n", oldSugarPrice / 100.0);
        } else {
            System.out.printf("This is the same as yesterday's price of $%.2f.%n", oldSugarPrice / 100.0);
        }
    }
}

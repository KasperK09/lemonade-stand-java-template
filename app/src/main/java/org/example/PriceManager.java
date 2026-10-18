
package org.example;

import java.util.Scanner;

public class PriceManager {
    private double price;

    public PriceManager() {
        price = 0.00;
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
}

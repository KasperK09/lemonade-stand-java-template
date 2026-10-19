
package org.example;

import java.util.Scanner;

public class LemonadeMaker {

    public void makePitchers(Scanner scanner, LemonadeStand stand, Recipe recipe) {

        System.out.print("How many pitchers of lemonade do you want to make? ");

        if (!scanner.hasNextInt()) {
            System.out.println("Please enter a whole number.");
            scanner.next();
            return;
        }

        int pitchersToMake = scanner.nextInt();

        if (pitchersToMake <= 0) {
            System.out.println("You must make at least one pitcher.");
            return;
        }

        long lemonsNeeded = (long) pitchersToMake * recipe.getLemonsPerPitcher();

        long sugarNeeded = (long) pitchersToMake * recipe.getSugarPerPitcher();

        if (lemonsNeeded > stand.getLemons()) {
            System.out.println("You do not have enough lemons!");
            return;
        }

        if (sugarNeeded > stand.getSugar()) {
            System.out.println(
                    "You do not have enough sugar!");
            return;
        }

        if ((long) stand.getPitchers() + pitchersToMake > Integer.MAX_VALUE) {
            System.out.println("You cannot make that many pitchers!");
            return;
        }

        stand.useIngredients(
                (int) lemonsNeeded, (int) sugarNeeded);

        stand.addPitchers(pitchersToMake);

        System.out.println("Fantastic! You used " + lemonsNeeded + " lemons, " + sugarNeeded + " cups of sugar, and " + ((long) pitchersToMake* recipe.getWaterPerPitcher()) + " cups of water to make " + pitchersToMake + " pitchers.");
    }
}

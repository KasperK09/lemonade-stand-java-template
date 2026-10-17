
package org.example;

public class Recipe {
    private int lemonsPerPitcher;
    private int sugarPerPitcher;
    private int waterPerPitcher;

    public Recipe() {
        lemonsPerPitcher = 0;
        sugarPerPitcher = 0;
        waterPerPitcher = 0;
    }

    public void setRecipe(int lemons, int sugar, int water) {
        if (lemons < 0 || sugar < 0 || water < 0) {
            System.out.println("Recipe amounts cannot be negative!");
        } else {
            lemonsPerPitcher = lemons;
            sugarPerPitcher = sugar;
            waterPerPitcher = water;

            System.out.println("Great! Your recipe is set!");
        }
    }

    public int getLemonsPerPitcher() {
        return lemonsPerPitcher;
    }

    public int getSugarPerPitcher() {
        return sugarPerPitcher;
    }

    public int getWaterPerPitcher() {
        return waterPerPitcher;
    }
}

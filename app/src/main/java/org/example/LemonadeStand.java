
package org.example;

public class LemonadeStand {
    private double money;
    private int lemons;
    private int sugar;
    private int pitchers;
    private int day;

    public LemonadeStand() {
        money = 100.00;
        lemons = 0;
        sugar = 0;
        pitchers = 0;
        day = 1;
    }

    public double getMoney() {
        return money;
    }

    public int getLemons() {
        return lemons;
    }

    public int getSugar() {
        return sugar;
    }

    public int getPitchers() {
        return pitchers;
    }

    public int getDay() {
        return day;
    }

    public void addIngredients(int lemons, int sugar) {
        this.lemons += lemons;
        this.sugar += sugar;
    }

    public void spendMoney(double amount) {
        money -= amount;
    }

    public void addMoney(double amount) {
        money += amount;
    }

    public void addPitchers(int amount) {
        pitchers += amount;
    }

    public void useIngredients(int lemons, int sugar) {
        this.lemons -= lemons;
        this.sugar -= sugar;
    }

    public void nextDay() {
        day++;
    }

    public void discardPitchers() {
        pitchers = 0;
    }
    


    public void displayStatus(double price) {
        System.out.println("\nDay " + day + ": Preparation Phase");
        System.out.println("Let's prepare for the day!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Lemons: " + lemons);
        System.out.println("Sugar (Cups): " + sugar);
        System.out.println("Water (Cups): Infinity");
        System.out.println("Current Pitchers: " + pitchers);
        System.out.printf("Price per Cup: $%.2f%n", price);
        System.out.printf("Cash: $%.2f%n", money);
    }
}

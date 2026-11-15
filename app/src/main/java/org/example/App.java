
    package org.example;

    import java.util.Scanner;

    public class App {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            PriceManager priceManager = new PriceManager();
            LemonadeStand stand = new LemonadeStand();
            Recipe recipe = new Recipe();
            LemonadeMaker lemonadeMaker = new LemonadeMaker();
            SellingPhase sellingPhase = new SellingPhase();

            double rent = 15.00;

            System.out.println("Welcome to My Lemonade Stand!");

            boolean playing = true;
            boolean newDay = true;

            while (playing) {

                if (newDay) {
                    System.out.println("\nDay " + stand.getDay() + ": Rent is due!");
                    stand.payRent();

                    System.out.printf("You paid $%.2f in rent.%n", rent);
                    System.out.printf("Money remaining: $%.2f%n", stand.getMoney());

                    if (stand.isGameOver()) {
                        System.out.println("\nGame over! You made it to day "
                                + stand.getDay() + " before going bankrupt!");
                        playing = false;
                        break;
                    }
                    newDay = false;
                }

                stand.displayStatus(priceManager.getPrice());

                System.out.println("1. Purchase Ingredients");
                System.out.println("2. Tweak the Recipe");
                System.out.println("3. Set the Price");
                System.out.println("4. Make Pitchers of Lemonade");
                System.out.println("5. Move Onto the Selling Phase");
                System.out.println("6. Quit");

                System.out.print("What would you like to do? ");

                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.printf("Lemons are $%.2f each%n", priceManager.getLemonPrice());
                    System.out.printf("Sugar is $%.2f per cup%n", priceManager.getSugarPrice());

                    System.out.print("How many lemons do you want to buy? ");
                    int lemonsToBuy = scanner.nextInt();

                    System.out.print("How many cups of sugar do you want to buy? ");
                    int sugarToBuy = scanner.nextInt();

                    if (lemonsToBuy < 0 || sugarToBuy < 0) {
                        System.out.println("You cannot buy negative ingredients!");
                    } else {
                        double cost = (lemonsToBuy * priceManager.getLemonPrice())+ (sugarToBuy * priceManager.getSugarPrice());

                        if (cost > stand.getMoney()) {
                            System.out.println("You do not have enough money!");
                        } else {
                            stand.addIngredients(lemonsToBuy, sugarToBuy);
                            stand.spendMoney(cost);

                            System.out.println("Great! Transaction complete!");
                        }
                    }

                } else if (choice == 2) {
                    System.out.print("How many lemons do you want per pitcher? ");
                    int newLemons = scanner.nextInt();

                    System.out.print("How many cups of sugar do you want per pitcher? ");
                    int newSugar = scanner.nextInt();

                    System.out.print("How many cups of water do you want per pitcher? ");
                    int newWater = scanner.nextInt();

                    recipe.setRecipe(newLemons, newSugar, newWater);

                    // System.out.println("debug lemons  " + recipe.getLemonsPerPitcher());
                    // System.out.println("debug sugar  " + recipe.getSugarPerPitcher());
                    // System.out.println("debug water  " + recipe.getWaterPerPitcher());

                } else if (choice == 3) {
                    priceManager.setPrice(scanner);

                } else if (choice == 4) {
                    lemonadeMaker.makePitchers(scanner, stand, recipe);

                } else if (choice == 5) {
                    sellingPhase.sellLemonade(stand, priceManager);

                    //Move to the next day
                    stand.nextDay();
                    newDay = true;

                    priceManager.updateDailyPrices();

                } else if (choice == 6) {
                    playing = false;

                } else {
                    System.out.println("Invalid choice.");
                }
            }

            scanner.close();
        }
    }

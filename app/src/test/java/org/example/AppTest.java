
package org.example;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    //seperate into seperate files later

    @Test
    public void testStartingMoney() {
        LemonadeStand stand = new LemonadeStand();

        assertEquals(100.00, stand.getMoney(), 0.001);
        assertEquals(0, stand.getLemons());
        assertEquals(0, stand.getSugar());
        assertEquals(0, stand.getPitchers());
        assertEquals(1, stand.getDay());
    }

    @Test
    public void testPurchaseIngredients() {
        LemonadeStand stand = new LemonadeStand();
        IngredientShop shop = new IngredientShop();

        Scanner scanner = new Scanner("10\n4\n");
        shop.purchaseIngredients(scanner, stand);

        assertEquals(10, stand.getLemons());
        assertEquals(4, stand.getSugar());
        assertEquals(88.00, stand.getMoney(), 0.001);

        scanner.close();
    }

    @Test
    public void testPurchaseWithoutEnoughMoney() {
        LemonadeStand stand = new LemonadeStand();
        IngredientShop shop = new IngredientShop();

        Scanner scanner = new Scanner("101\n0\n");
        shop.purchaseIngredients(scanner, stand);

        assertEquals(100.00, stand.getMoney(), 0.001);
        assertEquals(0, stand.getLemons());
        assertEquals(0, stand.getSugar());

        scanner.close();
    }

    @Test
    public void testPurchaseNegativeIngredients() {
        LemonadeStand stand = new LemonadeStand();
        IngredientShop shop = new IngredientShop();

        Scanner scanner = new Scanner("-5\n2\n");
        shop.purchaseIngredients(scanner, stand);

        assertEquals(100.00, stand.getMoney(), 0.001);
        assertEquals(0, stand.getLemons());
        assertEquals(0, stand.getSugar());

        scanner.close();
    }

    @Test
    public void testSetRecipe() {
        Recipe recipe = new Recipe();

        recipe.setRecipe(5, 2, 6);

        assertEquals(5, recipe.getLemonsPerPitcher());
        assertEquals(2, recipe.getSugarPerPitcher());
        assertEquals(6, recipe.getWaterPerPitcher());
    }

    @Test
    public void testNegativeRecipeIsRejected() {
        Recipe recipe = new Recipe();

        recipe.setRecipe(5, 2, 6);
        recipe.setRecipe(-1, 3, 4);

        assertEquals(5, recipe.getLemonsPerPitcher());
        assertEquals(2, recipe.getSugarPerPitcher());
        assertEquals(6, recipe.getWaterPerPitcher());
    }

    @Test
    public void testSetPrice() {
        PriceManager priceManager = new PriceManager();

        Scanner scanner = new Scanner("1.25\n");
        priceManager.setPrice(scanner);

        assertEquals(1.25, priceManager.getPrice(), 0.001);

        scanner.close();
    }

    @Test
    public void testInvalidPriceIsRejected() {
        PriceManager priceManager = new PriceManager();

        Scanner scanner = new Scanner("-1\n1.005\n1.50\n");
        priceManager.setPrice(scanner);

        assertEquals(1.50, priceManager.getPrice(), 0.001);

        scanner.close();
    }

    @Test
    public void testMakePitchers() {
        LemonadeStand stand = new LemonadeStand();
        Recipe recipe = new Recipe();
        LemonadeMaker maker = new LemonadeMaker();

        stand.addIngredients(50, 40);
        recipe.setRecipe(5, 2, 6);

        Scanner scanner = new Scanner("8\n");
        maker.makePitchers(scanner, stand, recipe);

        assertEquals(10, stand.getLemons());
        assertEquals(24, stand.getSugar());
        assertEquals(8, stand.getPitchers());
        assertEquals(100.00, stand.getMoney(), 0.001);

        scanner.close();
    }

    @Test
    public void testCannotMakePitchersWithoutEnoughLemons() {
        LemonadeStand stand = new LemonadeStand();
        Recipe recipe = new Recipe();
        LemonadeMaker maker = new LemonadeMaker();

        stand.addIngredients(4, 20);
        recipe.setRecipe(5, 2, 6);

        Scanner scanner = new Scanner("1\n");
        maker.makePitchers(scanner, stand, recipe);

        assertEquals(4, stand.getLemons());
        assertEquals(20, stand.getSugar());
        assertEquals(0, stand.getPitchers());

        scanner.close();
    }

    @Test
    public void testCannotMakePitchersWithoutEnoughSugar() {
        LemonadeStand stand = new LemonadeStand();
        Recipe recipe = new Recipe();
        LemonadeMaker maker = new LemonadeMaker();

        stand.addIngredients(20, 1);
        recipe.setRecipe(5, 2, 6);

        Scanner scanner = new Scanner("1\n");
        maker.makePitchers(scanner, stand, recipe);

        assertEquals(20, stand.getLemons());
        assertEquals(1, stand.getSugar());
        assertEquals(0, stand.getPitchers());

        scanner.close();
    }

    @Test
    public void testSellingLemonade() {
        LemonadeStand stand = new LemonadeStand();
        PriceManager priceManager = new PriceManager();
        SellingPhase sellingPhase = new SellingPhase();

        stand.addPitchers(1);

        Scanner scanner = new Scanner("2.00\n");
        priceManager.setPrice(scanner);
        scanner.close();

        sellingPhase.sellLemonade(stand, priceManager);

        //between 1 and 8 cups can be sold
        assertTrue(stand.getMoney() >= 102.00);
        assertTrue(stand.getMoney() <= 116.00);

        //all left over lemonade is thrown out
        assertEquals(0, stand.getPitchers());
    }

    @Test
    public void testAdvanceToNextDay() {
        LemonadeStand stand = new LemonadeStand();

        stand.nextDay();

        assertEquals(2, stand.getDay());
    }

    @Test
    public void testDiscardPitchers() {
        LemonadeStand stand = new LemonadeStand();

        stand.addPitchers(5);
        stand.discardPitchers();

        assertEquals(0, stand.getPitchers());
    }

    @Test
    public void testGameMenuReadsChoice() {
        GameMenu menu = new GameMenu();
        Scanner scanner = new Scanner("3\n");

        assertEquals(3, menu.getChoice(scanner));

        scanner.close();
    }
}

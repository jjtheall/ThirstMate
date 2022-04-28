package edu.quinnipiac.ser210.thirstmate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DrinkTest {

    private Drink drink;
    private Ingredient[] ingredients = new Ingredient[3];

    @Before
    public void setUp() throws Exception {
        ingredients[0] = new Ingredient("ing1",1.0);
        ingredients[1] = new Ingredient("ing2",2.0);
        ingredients[2] = new Ingredient("ing3",3.0);

        drink = new Drink("testName",ingredients,1);
    }

    @Test
    public void getName() {
        assertSame("testName",drink.getName());
    }

    @Test
    public void getIngredients() {
        assertArrayEquals(ingredients,drink.getIngredients());
    }

    @Test
    public void getImageResourceId() {
        assertEquals(1,drink.getImageResourceId(),0);
    }

    @Test
    public void setName() {
        String newName = "newName";
        drink.setName(newName);
        assertSame(newName,drink.getName());
    }

    @Test
    public void setIngredients() {
        Ingredient[] newIngredients = {
                new Ingredient("newIng1",4.0),
                new Ingredient("newIng2",5.0),
                new Ingredient("newIng3",6.0),
        };
        drink.setIngredients(newIngredients);
        assertArrayEquals(newIngredients,drink.getIngredients());
    }
}
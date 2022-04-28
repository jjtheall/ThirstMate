package edu.quinnipiac.ser210.thirstmate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() throws Exception {
        ingredient = new Ingredient("test",1.0);
    }

    @Test
    public void getName() {
        assertSame("test",ingredient.getName());
    }

    @Test
    public void getQuantity() {
        assertEquals(1.0,ingredient.getQuantity(),0);
    }

    @Test
    public void setName() {
        String newName = "newName";
        ingredient.setName(newName);
        assertSame(newName,ingredient.getName());
    }

    @Test
    public void setQuantity() {
        double newQuantity = 2.0;
        ingredient.setQuantity(newQuantity);
        assertEquals(2.0,ingredient.getQuantity(),0);
    }
}
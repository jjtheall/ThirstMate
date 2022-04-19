package edu.quinnipiac.ser210.thirstmate;

public class Drink {

    private String name;
    private Ingredient[] ingredients;

    public Drink(String name){
        this.name = name;
        ingredients = new Ingredient[]{
                new Ingredient("testIng1", 0.0),
                new Ingredient("testIng2", 0.0),
                new Ingredient("testIng3", 0.0)
        };
    }

    public Drink(String name, Ingredient[] ingredients){
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName(){
        return this.name;
    }

    public Ingredient[] getIngredients(){
        return this.ingredients;
    }

    public Ingredient getIngredientAtIndex(int index){
        return this.ingredients[index];
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIngredients(Ingredient[] ingredients){
        this.ingredients = ingredients;
    }
}

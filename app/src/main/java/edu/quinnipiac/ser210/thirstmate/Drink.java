package edu.quinnipiac.ser210.thirstmate;

public class Drink {

    private String name;
    private Ingredient[] ingredients;
    private int imageResourceId;

    public static Drink[] drinks = {
            new Drink("Rum and Coke"),
            new Drink("Blue Hawaiian"),
            new Drink("Vodka Cranberry"),
            new Drink("Vodka Sour"),
            new Drink("Tequila Sunrise"),
            new Drink("Margarita")
    };

    public Drink(String name){
        this.name = name;
        ingredients = new Ingredient[]{
                new Ingredient("testIng1", 0.0),
                new Ingredient("testIng2", 0.0),
                new Ingredient("testIng3", 0.0)
        };
    }

    public Drink(String name, Ingredient[] ingredients, int imageResourceId){
        this.name = name;
        this.ingredients = ingredients;
        this.imageResourceId = imageResourceId;
    }

    public String getName(){
        return this.name;
    }

    public Ingredient[] getIngredients(){
        return this.ingredients;
    }

    public int getImageResourceId(){
        return this.imageResourceId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIngredients(Ingredient[] ingredients){
        this.ingredients = ingredients;
    }

    public String toString(){
        return this.name;
    }
}

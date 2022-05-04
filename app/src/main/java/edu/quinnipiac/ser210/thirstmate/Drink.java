/*
 * ThirstMate App
 * @author: Jack Theall, MacArthur Mills
 * Developed Spring '22
 */

package edu.quinnipiac.ser210.thirstmate;

public class Drink {

    private String name;
    private Ingredient[] ingredients;
    private int imageResourceId;

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

package edu.quinnipiac.ser210.thirstmate;

public class Ingredient {

    private String name;
    private double quantity;

    public static Ingredient[] data = {new Ingredient("Vodka", 750), new Ingredient("Ginger Beer", 355),
            new Ingredient("Lime Juice", 125), new Ingredient("Simple Syrup", 375),
            new Ingredient("Ice")};

    public Ingredient(String name, double quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public Ingredient(String name){
        this.name = name;
        quantity = 0;
    }

    public String getName(){
        return name;
    }

    public double getQuantity(){ return quantity; }

    public void setName(String name){
        this.name = name;
    }

    public void setQuantity(double quantity){
        this.quantity = quantity;
    }
}

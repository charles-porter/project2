package com.example.charles.project2;

/**
 * Created by Charles on 11/13/2017.
 */

public class Recipe {
    private String name;
    private String description;
    private String[] ingredients;
    private String[] tools;
    private double time;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String[] getIngredients() {
        return new String[10];
    }

    public void setIngredients(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j){

    this.ingredients = new String[]{a, b, c, d, e, f, g, h, i, j};
    }

    public String[] getTools() {
        return new String[5];
    }

    public void setTools(String a, String b, String c, String d, String e){
        this.tools = new String[]{a, b, c, d, e};
    }

    public double getTime(){
        return time;
    }

    public void setTime(double time){
        this.time = time;
    }
}



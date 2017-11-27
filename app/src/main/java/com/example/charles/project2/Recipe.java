package com.example.charles.project2;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by Charles on 11/13/2017.
 */

public class Recipe extends RealmObject {
    private String id;
    private String name;
    private String description;
    private List <String> ingredients;
    private List <String> tools;
    private double time;

    Recipe(String id, String name, String description, List<String> ingredients, List<String> tools, double time)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.tools = tools;
        this.time = time;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients){
        this.ingredients = ingredients;
    }

    public void addIngredient(String ingredient)
    {
        ingredients.add(ingredient);
    }

    public List<String> getTools() {
        return tools;
    }

    public void setTools(List<String> tools){
        this.tools = tools;
    }

    public void addTool(String tool)
    {
        tools.add(tool);
    }

    public double getTime(){
        return time;
    }

    public void setTime(double time){
        this.time = time;
    }
}



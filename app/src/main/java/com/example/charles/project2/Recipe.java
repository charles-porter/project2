package com.example.charles.project2;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Charles on 11/13/2017.
 */

public class Recipe extends RealmObject {
    private String id;
    private String name;
    private String description;
    private RealmList <RealmString> ingredients;
    private RealmList <RealmString> tools;
    private double time;

    public Recipe()
    {
        id = "Eh";
        name = "Deadcells";
        description = "Not an actual recipe";
        ingredients = new RealmList<RealmString>();
        tools = new RealmList<RealmString>();
        time = 9001;
    }

    public Recipe(String id, String name, String description, RealmList<RealmString> ingredients, RealmList<RealmString> tools, double time)
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

    public RealmList<RealmString> getIngredients() {
        return ingredients;
    }

    public void setIngredients(RealmList<RealmString> ingredients){
        this.ingredients = ingredients;
    }

    public void addIngredient(RealmString ingredient)
    {
        ingredients.add(ingredient);
    }

    public RealmList<RealmString> getTools() {
        return tools;
    }

    public void setTools(RealmList<RealmString> tools){
        this.tools = tools;
    }

    public void addTool(RealmString tool)
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


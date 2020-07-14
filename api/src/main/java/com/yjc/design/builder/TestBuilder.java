package com.yjc.design.builder;

public class TestBuilder {
    public static void main(String[] args) {
        BuilderMeal builderMeal = new BuilderMeal();
        Meal vegMeal = builderMeal.prepareVegMeal();
        System.out.println("veg meal");
        vegMeal.showItems();


        Meal nonMeal = builderMeal.prepareNonMeal();
        System.out.println("non meal");
        nonMeal.showItems();

    }
}

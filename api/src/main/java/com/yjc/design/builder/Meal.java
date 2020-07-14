package com.yjc.design.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }


    public Integer getPrice() {
        int allPrice = 0;
        for (Item item : items) {
            allPrice += item.price();
        }
        return allPrice;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("Item:" + item.name());
            System.out.println("，Packing:" + item.packing().pack());
            System.out.println(",Price:" + item.price());
        }
    }
}

package com.codecool.servlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderableItItems {

    private static List<Item> items = new ArrayList<>();

    public static List<Item> getItems() {
        return items;
    }

    public static void clearItems(){
        items.clear();
    }
    public static void initializeOrderableItems(){
        items.add(new Item("Wooden leg", 130));
        items.add(new Item("Hook", 87));
        items.add(new Item("Speaking Parrot", 200));
        items.add(new Item("Barrel of good rum", 500));
        items.add(new Item("Barrel of cheap rum", 99));
        items.add(new Item("Double barrel gun",400));
    }


}

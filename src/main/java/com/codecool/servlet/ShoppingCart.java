package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    static List<Item> store = new ArrayList<>();

    public static void add(Item item){
        store.add(item);
    }

    public static void remove(int id){
        for (int i=0; i<store.size();i++){
            if (id==store.get(i).getId()){
                store.remove(i);
                return;
            }
        }
    }

    public static List<Item> getStore() {
        return store;
    }
}

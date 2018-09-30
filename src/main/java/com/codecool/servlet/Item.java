package com.codecool.servlet;

public class Item {
    private String name;
    private int id;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.id = OrderableItItems.getItems().size();
    }

    public Item(Item item){
        this.name=item.getName();
        this.price=item.getPrice();
        this.id=ShoppingCart.getStore().size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}

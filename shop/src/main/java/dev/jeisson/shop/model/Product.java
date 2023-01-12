package dev.jeisson.shop.model;

public class Product {
    private String Id, Name;
    private double Price;
    private int Amount;
    public Product(String id, String name, double price, int amount){
        this.Id = id;
        this.Name = name;
        this.Price = price;
        this.Amount = amount;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }

    public String getId() {
        return Id;
    }
    public double getPrice() {
        return Price;
    }
    public void setPrice(double price) {
        Price = price;
    }
    public int getAmount() {
        return Amount;
    }
    public void setAmount(int amount) {
        Amount = amount;
    }
}

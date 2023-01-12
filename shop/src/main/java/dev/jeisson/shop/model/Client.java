package dev.jeisson.shop.model;

public class Client {

    private String Id, Name;
    private double Coins;

    public Client(String id, String name, double coins){
        this.Id = id;
        this.Name =  name;
        this.Coins = coins;
    }
    public double getCoins() {
        return Coins;
    }
    public String getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
    public void setCoins(double coins) {
        Coins = coins;
    }
    public void setId(String id) {
        Id = id;
    }
    public void setName(String name) {
        Name = name;
    }
}

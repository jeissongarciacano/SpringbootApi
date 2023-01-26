package dev.jeisson.shop.model;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private int id;
    private double coins;
    private List<String> buys = new ArrayList<String>();
    public double getCoins() {
        return coins;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCoins(double coins) {
        this.coins = coins;
    }
    public List<String> getBuys() {
        return buys;
    }
    public void setBuys(List<String> buys) {
        this.buys = buys;
    }
    public String BuystoString(){
        String mss = "::Lastbuys";
        for (int i = 0; i < getBuys().size(); i++) {
            mss = mss + ":::" + getBuys().get(i);
        }
        return mss;
    }
    @Override
    public String toString() {
        return id + "::" + name + "::" + coins + BuystoString();
    }
    public void Buy(Buy buy){
        setCoins(getCoins() - buy.getPrice());
        getBuys().add(buy.getDescriptionP());
    }
    public void Morecoins(double coin){
        setCoins(getCoins() + coin);
    }
}

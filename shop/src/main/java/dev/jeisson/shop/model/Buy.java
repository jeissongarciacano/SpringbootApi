package dev.jeisson.shop.model;

public class Buy {
    private String descriptionP;
    private int clientID;
    private double price;
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public int getClientID() {
        return clientID;
    }
    public String getDescriptionP() {
        return descriptionP;
    }
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    public void setDescriptionP(String description) {
        this.descriptionP = description;
    }
}

package dev.jeisson.shop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Buy {
    private String Id;
    private Client Buyer;
    private LocalDateTime Buydate;
    private List<Product> Buylist = new ArrayList<Product>();

    public Buy(String id, Client buyer, LocalDateTime buydate) {
        Id = id;
        Buyer = buyer;
        Buydate = buydate;
    }

    public void setId(String id) {
        Id = id;
    }
    public Client getBuyer() {
        return Buyer;
    }
    public LocalDateTime getBuydate() {
        return Buydate;
    }
    public String getId() {
        return Id;
    }
    public void setBuydate(LocalDateTime buydate) {
        Buydate = buydate;
    }
    public void setBuyer(Client buyer) {
        Buyer = buyer;
    }

    public void setBuylist(List<Product> buylist) {
        Buylist = buylist;
    }
    public List<Product> getBuylist() {
        return Buylist;
    }
    public void Addproduct(String id, String name, double price, int amount){
        Product product = new Product(id, name, price, amount);
        getBuylist().add(product);
    }
    public void Deleteproduct(String id){
        int i = 0;
        while(i<getBuylist().size() && !getBuylist().get(i).getId().equals(id)) i++;
        if(i >= getBuylist().size()) System.out.println("no existe");
        else getBuylist().remove(i);
    }
    public void Changeamount(String id, int newamount){
        int i = 0;
        while(i<getBuylist().size() && !getBuylist().get(i).getId().equals(id)) i++;
        getBuylist().get(i).setAmount(newamount);
    }
    public double TotalPrice(){
        double total = 0;
        for (int i = 0; i < getBuylist().size(); i++) {
            total += getBuylist().get(i).getPrice() * getBuylist().get(i).getAmount();
        }
        return total;
    }
    public void Endbuy(){
        double totalprice = TotalPrice();
        if(getBuyer().getCoins() >= totalprice) getBuyer().setCoins(getBuyer().getCoins() - totalprice);
        else System.out.println("Fondos insuficientes");
    }
}

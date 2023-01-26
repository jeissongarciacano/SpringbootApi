package dev.jeisson.shop.service;

import dev.jeisson.shop.model.Client;
import dev.jeisson.shop.model.Response;
import dev.jeisson.shop.model.Buy;
import dev.jeisson.shop.model.ClientTemp;

import java.util.List;

public interface ClientService {
    public Response addClient(ClientTemp clientTemp);
    public Response deleteClient(int id);
    public Response addClientCoins(int id, int coin);
    public Response ClientBuy(Buy buy);
    public Client getClient(int id);
    public String getClientBuys(int id);
    public List<Client> getAllClients();

}

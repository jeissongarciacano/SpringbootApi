package dev.jeisson.shop.service;

import dev.jeisson.shop.model.Client;
import dev.jeisson.shop.model.Response;
public interface ClientService {
    public Response addClient(Client client);
    public Response deleteClient(int id);
    public Response addClientCoins(int id, double coins);
    public Response ClientBuy(int id, double price);
    public Client getClient(int id);
    public Client[] getAllClients();

}

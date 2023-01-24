package dev.jeisson.shop.service;

import dev.jeisson.shop.model.Client;
import dev.jeisson.shop.model.Response;

public class ClientServiceImpl implements ClientService{

    @Override
    public Response addClient(Client client) {
        return null;
    }

    @Override
    public Response deleteClient(int id) {
        return null;
    }

    @Override
    public Response addClientCoins(int id, double coins) {
        return null;
    }

    @Override
    public Response ClientBuy(int id, double price) {
        return null;
    }

    @Override
    public Client getClient(int id) {
        return null;
    }

    @Override
    public Client[] getAllClients() {
        return new Client[0];
    }
}

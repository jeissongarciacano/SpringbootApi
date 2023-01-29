package dev.jeisson.shop.service;
import dev.jeisson.shop.model.Buy;
import dev.jeisson.shop.model.ClientTemp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import dev.jeisson.shop.model.Client;
import dev.jeisson.shop.model.Response;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/Client")
public class ClientServiceImpl implements ClientService{
    private List<Client> Clients = new ArrayList<Client>();
    private int Clientcount = 0;
    public List<Client> getClients() {
        return Clients;
    }
    public void setClients(List<Client> clients) {
        Clients = clients;
    }
    public void setClientcount(int clientcount) {
        Clientcount = clientcount;
    }
    public int getClientcount() {
        return Clientcount;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/POSTCreateClient")
    @Override
    public Response addClient(@RequestBody ClientTemp clientTemp) {
        Response response = new Response();
        Client client = new Client();
        client.setName(clientTemp.getName());
        client.setCoins(0);
        client.setId(getClientcount());
        setClientcount(getClientcount()+1);
        getClients().add(client);
        response.setMessage("Cliente Creado exitosamente: " + client.toString());
        response.setStatus(true);
        return response;
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/DELETEClient/{id}")
    @Override
    public Response deleteClient(@PathVariable int id) {
        Response response = new Response();
        int i = 0;
        while (i < getClients().size() && getClients().get(i).getId() != id) i++;
        if (i >= getClients().size()){
            response.setStatus(false);
            response.setMessage("Error: Cliente no encontrado");
        }
        else{
            getClients().remove(i);
            response.setMessage("Se borro exitosamente");
            response.setStatus(true);
        }
        return response;
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/PUTAddCoins/{id}/{coin}")
    @Override
    public Response addClientCoins(@PathVariable int id, @PathVariable int coin) {
        Response response = new Response();
        int i = 0;
        while (i < getClients().size() && getClients().get(i).getId() != id) i++;
        if (i >= getClients().size()){
            response.setStatus(false);
            response.setMessage("Error: Cliente no encontrado");
        }
        else{
            getClients().get(i).Morecoins(Double.valueOf(coin));
            response.setMessage("Su sueldo actual es: " + getClients().get(i).getCoins());
            response.setStatus(true);
        }
        return response;
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/POSTBuy")
    @Override
    public Response ClientBuy(@RequestBody Buy buy) {
        Response response = new Response();
        int i = 0;
        while (i < getClients().size() && getClients().get(i).getId() != buy.getClientID()) i++;
        if(i >= getClients().size()){
            response.setStatus(false);
            response.setMessage("Error: Cliente no encontrado");
        }
        else{
            if(getClients().get(i).getCoins() >= buy.getPrice()){
                getClients().get(i).Buy(buy);
                response.setMessage(getClients().get(i).toString());
                response.setStatus(true);
            }
            else{
                response.setStatus(false);
                response.setMessage("Error: Saldo insuficiente");
            }
        }
        return response;
    }
    @GetMapping("/GETclient/{id}")
    @Override
    public Client getClient(@PathVariable int id) {
        int i = 0;
        while (i < getClients().size() && getClients().get(i).getId() != id) i++;
        if (i >= getClients().size()) return null;
        else return getClients().get(i);
    }
    @GetMapping("/GETclientbuys/{id}")
    @Override
    public String getClientBuys(@PathVariable int id){
        int i = 0;
        while (i < getClients().size() && getClients().get(i).getId() != id) i++;
        if (i >= getClients().size()) return "no existe el Cliente";
        else return getClients().get(i).BuystoString();
    }
    @GetMapping("/GETall")
    @Override
    public List<Client> getAllClients() {
        return getClients();
    }

}

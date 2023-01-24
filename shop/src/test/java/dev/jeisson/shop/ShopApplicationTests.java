package dev.jeisson.shop;

import dev.jeisson.shop.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import dev.jeisson.shop.model.Client;

@SpringBootTest
class ShopApplicationTests {

    @Test
    void contextLoads() {
        Client client = new Client();
        client.setCoins(400);
        client.setId(2);
        client.setName("amorcito");
        client.getBuys().add("Leche");
        client.getBuys().add("algodon");
        System.out.println(client.toString());
    }

}

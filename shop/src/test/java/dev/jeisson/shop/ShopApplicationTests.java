package dev.jeisson.shop;

import dev.jeisson.shop.model.Buy;
import dev.jeisson.shop.model.Client;
import dev.jeisson.shop.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;

@SpringBootTest
class ShopApplicationTests {

    @Test
    void contextLoads() {
        Client c1 = new Client("123", "jeisson", 5000);
        Buy b1 = new Buy("374", c1, LocalDateTime.of(2023,1, 12,2,50));
        b1.Addproduct("341", "Pan", 40, 2);
        b1.Addproduct("351", "Queso", 400, 1);
        b1.Addproduct("354", "Galletas", 50, 10);
        b1.Deleteproduct("351");
        b1.Changeamount("341", 2000);
        System.out.println(b1.TotalPrice());
        b1.Endbuy();
        System.out.println(c1.getCoins());
        System.out.println(b1.getBuyer().getCoins());

    }

}

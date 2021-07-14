package gr.advantage.testing;

import gr.advantage.testing.model.Item;
import gr.advantage.testing.service.CartService;
import gr.advantage.testing.service.CartServiceImpl;
import gr.advantage.testing.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApplication {
    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        PaymentService paymentService = null;
        CartService cartService = new CartServiceImpl(paymentService);

        cartService.addItem(new Item("Apple", 1, 1));
        cartService.addItem(new Item("Banana", 2, 5));
        cartService.addItem(new Item("Apple", 1, 2));
        cartService.addItem(new Item("Chocolate", 1, 2));

        cartService.getCartItems().forEach(i -> logger.info("{}", i));
        logger.info("The total price of products is:{}", cartService.getTotalPrice());
        cartService.removeItem(new Item("Chocolate", 1, 2));
        cartService.getCartItems().forEach(i -> logger.info("{}", i));
        logger.info("The total price of products is:{}", cartService.getTotalPrice());



    }
}

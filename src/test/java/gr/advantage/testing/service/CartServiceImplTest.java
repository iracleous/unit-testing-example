package gr.advantage.testing.service;



import gr.advantage.testing.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CartServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImplTest.class);

    private CartServiceImpl cartService;


    @BeforeEach
    void initialize() {
        cartService = new CartServiceImpl(null);
        cartService.addItem(new Item("RAM", 120, 2));
    }



    @Test
    @DisplayName("Add correct item in cart")
    void addItem() {
        boolean result = cartService.addItem(new Item("SSD", 80, 2));
        assertTrue(result);
    }


    @Test
    @DisplayName("Add incorrect item in cart")
    void addItemError() {
        boolean result = cartService.addItem(new Item("SSD", 80, 0));
        assertFalse(result);
    }

    @Test
    @DisplayName("Remove incorrect item from cart")
    void removeItem() {
        boolean result = cartService.removeItem(new Item("CPU", 300, 1));
        assertFalse(result);
    }

}
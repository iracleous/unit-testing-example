package gr.advantage.testing.service;



import gr.advantage.testing.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImplTest.class);

    private CartServiceImpl cartService;

    @Mock
    private PaymentService mockedPaymentService;

    @BeforeEach
    void initialize() {
        cartService = new CartServiceImpl(mockedPaymentService);
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

    @Test
    @DisplayName("Get all cart items")
    void getCartItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("RAM", 120, 2));
        assertIterableEquals(items, cartService.getCartItems());
    }


    @Test
    @DisplayName("Calculate total cart price")
    void getTotalPrice() {
        assertEquals(240, cartService.getTotalPrice());
    }



    @Test
    @DisplayName("Successfull checkout test")
    void checkout(){
         when(mockedPaymentService.balance()).thenReturn(300.0);
        boolean isCompleted = cartService.checkout();
        int numOfCartItems = cartService.getCartItems().size();

        assertTrue(isCompleted);
        assertEquals(0, numOfCartItems);
        verify(mockedPaymentService).withdraw(240);
    }



    @Test
    @DisplayName("Testing the payment service")
    void checkPaymentService(){
        when(mockedPaymentService.deposit(any())).thenReturn(true);
        boolean returnValue = mockedPaymentService.deposit(100.0);
        assertTrue(returnValue);
    }

}
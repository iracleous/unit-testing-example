package gr.advantage.testing;


import gr.advantage.testing.service.CartService;
import gr.advantage.testing.service.CartServiceImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

public class GeneralTest {

    private static final Logger logger = LoggerFactory.getLogger(GeneralTest.class);


    @Test
    @DisplayName("Always true test")

    void shouldBeTrue() {
        assertTrue(true);
    }

    @Test
    void Example2() {
        int expected = 1;
        int actual = 0 + 1;
        //assert equality
        assertEquals(expected, actual, "The test failed");
    }
    @Test
    void Example5() {
        String string = "hello";
        assertTrue(string.length()>3);
    }

    @Test
    void Example7() {

        CartService cartService = new CartServiceImpl(null);


        //assert that it throws an exception
        assertThrows(ArithmeticException.class, ()-> cartService.getTotalPrice() );
    }

    @Test
    void Example9() {

        CartService cartService = null;
        //assert that it throws an exception
        assertNull(    cartService  );
    }


    @Test
    void Example11() {
        //assert that a functionality will
        //not exceed the specified amount of time
        assertTimeout(ofMillis(1), () -> {
            //some time consuming tasks
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100);
            int[] myArray = new int[randomInt];
            for (int i = 0; i < randomInt; i++) {
                myArray[i] = randomGenerator.nextInt(100);
            }
            String myString = "Hello World";
            for (int i = 0; i < 100; i++) {
                myString += " Hello World";
            }
            String myStringModified = myString.replace("World", "World!!!");
            logger.info("{} ", myStringModified);
        });
    }





}

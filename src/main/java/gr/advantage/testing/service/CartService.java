package gr.advantage.testing.service;

import gr.advantage.testing.model.Item;

import java.util.List;

public interface CartService {

    boolean addItem(Item item);

    boolean removeItem(Item item);

    List<Item> getCartItems();

    double getTotalPrice();

    boolean checkout();
}

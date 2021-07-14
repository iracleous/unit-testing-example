package gr.advantage.testing.service;

import gr.advantage.testing.model.Item;

import java.util.List;

public class CartServiceImpl implements  CartService{
    @Override
    public boolean addItem(Item item) {
        return false;
    }

    @Override
    public boolean removeItem(Item item) {
        return false;
    }

    @Override
    public List<Item> getCartItems() {
        return null;
    }

    @Override
    public double getTotalPrice() {
        int a =1;
        int b = 2;
        return a/b;
    }

    @Override
    public boolean checkout() {
        return false;
    }
}

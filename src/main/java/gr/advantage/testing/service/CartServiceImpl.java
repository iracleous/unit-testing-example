package gr.advantage.testing.service;

import gr.advantage.testing.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements  CartService{

    private List<Item> cart;
    private PaymentService paymentService;


    public CartServiceImpl(PaymentService paymentService) {
        cart = new ArrayList<>();
        this.paymentService = paymentService;
    }

    @Override
    public boolean addItem(Item item) {
        return item.getQuantity() <= 0 ? false : addAndIncrementQuantityIfExists(item);

    }

    private boolean addAndIncrementQuantityIfExists(Item item) {
        for (Item cartItem : cart) {
            if (cartItem.equals(item)) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                return true;
            }
        }
        return cart.add(item);
    }


    @Override
    public boolean removeItem(Item item) {
        return cart.remove(item);
    }

    @Override
    public List<Item> getCartItems() {
        return cart;
    }

    @Override
    public double getTotalPrice() {
        return cart.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
    }

    @Override
    public boolean checkout() {
        if (getTotalPrice() <= paymentService.balance()) {
            paymentService.withdraw(getTotalPrice());
            cart.clear();
            return true;
        } else return false;
    }
}

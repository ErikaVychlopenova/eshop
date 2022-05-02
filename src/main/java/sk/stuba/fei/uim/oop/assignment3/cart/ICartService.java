package sk.stuba.fei.uim.oop.assignment3.cart;

import sk.stuba.fei.uim.oop.assignment3.shoppingList.ShoppingListRequest;

public interface ICartService {
    Cart createNewCart();
    Cart getCart(Integer id);
    void deleteCart(Integer id);
    Cart addToCart(Integer id, ShoppingListRequest request);
    String payCart(Integer id);
}

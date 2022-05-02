package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.shoppingList.Item;

import java.util.List;


@Getter
public class CartResponse {
    private final Integer id;
    private final List<Item> shoppingList;
    private final boolean payed;

    public CartResponse(Cart cart){
        this.id = cart.getId();
        this.shoppingList = cart.getShoppingList();
        this.payed = cart.isPayed();
    }
}

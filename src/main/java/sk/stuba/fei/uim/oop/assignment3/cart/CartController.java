package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.shoppingList.ShoppingListRequest;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService service;

    @PostMapping
    public ResponseEntity<CartResponse> createNewCart(){
        return new ResponseEntity<>(new CartResponse(this.service.createNewCart()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable("id") Integer id){
        return this.service.getCart(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") Integer id){
        this.service.deleteCart(id);
    }

    @PostMapping("/{id}/add")
    public Cart addToCart(@PathVariable("id") Integer id, @RequestBody ShoppingListRequest request){
        return this.service.addToCart(id, request);
    }

    @GetMapping("/{id}/pay")
    public String payCart(@PathVariable("id") Integer id) {
        return this.service.payCart(id);
    }
}

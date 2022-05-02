package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exceptions.BadRequestException;
import sk.stuba.fei.uim.oop.assignment3.product.Product;
import sk.stuba.fei.uim.oop.assignment3.product.ProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.ProductService;
import sk.stuba.fei.uim.oop.assignment3.shoppingList.Item;
import sk.stuba.fei.uim.oop.assignment3.shoppingList.ItemRepository;
import sk.stuba.fei.uim.oop.assignment3.shoppingList.ShoppingListRequest;


@Service
public class CartService implements ICartService {

    @Autowired
    private final CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart createNewCart() {
        Cart cart = new Cart();
        cart.setPayed(false);
        return this.cartRepository.save(cart);
    }

    @Override
    public Cart getCart(Integer id){
        return this.cartRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteCart(Integer id) {
        Cart delete = getCart(id);
        this.cartRepository.delete(delete);
    }

    @Override
    public Cart addToCart(Integer id, ShoppingListRequest request) {
        Cart cart = this.getCart(id);
        Product product = this.productService.getById(request.getProductId());

        if((product.getAmount() < request.getAmount()) || (cart.isPayed()))
            throw new BadRequestException();

        boolean isItemInCart = false;
        for(Item item : cart.getShoppingList()){
            if(item.getProductId().equals(request.getProductId())){
                item.addAmount(request.getAmount());
                isItemInCart = true;
            }
        }
        if(!isItemInCart){
            Item item = new Item(request.getProductId(), request.getAmount());
            item = this.itemRepository.save(item);
            cart.getShoppingList().add(item);
        }
        product.setAmount(product.getAmount() - request.getAmount());
        this.productRepository.save(product);
        this.cartRepository.save(cart);
        return getCart(id);
    }

    @Override
    public String payCart(Integer id) {
        Cart cart = getCart(id);
        Product product;
        double sum = 0;
        if(cart.isPayed())
            throw new BadRequestException();
        else
            cart.setPayed(true);

        for (Item item : cart.getShoppingList()){
            product = productService.getById(item.getProductId());
            double price = (double)product.getPrice();
            sum += price * (double)item.getAmount();
        }
        return ""+sum;
    }
}

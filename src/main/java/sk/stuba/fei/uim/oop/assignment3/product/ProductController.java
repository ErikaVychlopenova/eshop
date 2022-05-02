package sk.stuba.fei.uim.oop.assignment3.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;


    @GetMapping
    public List<ProductResponse> getAllProducts(){
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest request){
        return new ProductResponse(this.service.createNewProduct(request));
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Integer id){
        return this.service.getById(id);
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable("id") Integer id, @RequestBody ProductRequest request ){
        return this.service.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Integer id){
        this.service.delete(id);
    }

    @GetMapping("/{id}/amount")
    public AmountResponse getProductAmount(@PathVariable("id") Integer id){
        return new AmountResponse(this.service.getProductAmount(id));
    }

    @PostMapping("/{id}/amount")
    public AmountResponse addProductAmount(@PathVariable("id") Integer id,@RequestBody ProductRequest request){
        return new AmountResponse(this.service.addProductAmount(id, request));
    }
}

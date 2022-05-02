package sk.stuba.fei.uim.oop.assignment3.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public ArrayList<Product> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Product createNewProduct(ProductRequest request) {
        Product newProduct = new Product();
        newProduct.setName(request.getName());
        newProduct.setDescription(request.getDescription());
        newProduct.setAmount(request.getAmount());
        newProduct.setUnit(request.getUnit());
        newProduct.setPrice(request.getPrice());
        return this.repository.save(newProduct);
    }

    @Override
    public Product getById(Integer Id) {
        return this.repository.findById(Id).orElseThrow();
    }

    @Override
    public Product update(Integer id, ProductRequest request) {
        Product update = getById(id);
        if(request.getName() != null)
            update.setName(request.getName());
        if(request.getDescription() != null)
            update.setDescription(request.getDescription());
        return this.repository.save(update);
    }

    @Override
    public void delete(Integer id) {
        Product delete = getById(id);
        this.repository.delete(delete);
    }

    @Override
    public Integer getProductAmount(Integer id) {
        return getById(id).getAmount();
    }

    @Override
    public Integer addProductAmount(Integer id, ProductRequest request) {
        Product update = getById(id);
        Integer amount;
        amount = update.getAmount();
        amount += request.getAmount();
        update.setAmount(amount);
        this.repository.save(update);
        return amount;
    }
}

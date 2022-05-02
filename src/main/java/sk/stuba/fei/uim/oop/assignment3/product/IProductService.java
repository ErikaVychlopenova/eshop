package sk.stuba.fei.uim.oop.assignment3.product;


import java.util.ArrayList;

public interface IProductService {
    ArrayList<Product> getAll();
    Product createNewProduct(ProductRequest request);
    Product getById(Integer Id);
    Product update(Integer id, ProductRequest request);
    void delete(Integer id);
    Integer getProductAmount(Integer id);
    Integer addProductAmount(Integer id, ProductRequest request);
}

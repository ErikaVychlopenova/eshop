package sk.stuba.fei.uim.oop.assignment3.product;

import lombok.Getter;

@Getter
public class ProductResponse {
    private final Integer id;
    private final String name;
    private final String description;
    private final Integer amount;
    private final String unit;
    private final Number price;

    public ProductResponse(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.amount = product.getAmount();
        this.unit = product.getUnit();
        this.price = product.getPrice();
    }
}

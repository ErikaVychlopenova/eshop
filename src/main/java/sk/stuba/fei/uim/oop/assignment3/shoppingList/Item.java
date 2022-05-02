package sk.stuba.fei.uim.oop.assignment3.shoppingList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"id"})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer productId;
    private Integer amount;

    public Item(Integer productId, Integer amount){
        this.productId = productId;
        this.amount = amount;
    }

    public void addAmount(int addAmount){
        this.amount += addAmount;
    }
}

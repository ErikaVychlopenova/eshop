package sk.stuba.fei.uim.oop.assignment3.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmountResponse {

    private Integer amount;

    public AmountResponse(Integer productAmount) {
        this.amount = productAmount;
    }
}

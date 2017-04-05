package product;

import java.math.BigDecimal;

import static product.ProductEnum.COKE;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Coke extends Product {

    public Coke(BigDecimal price) {
        super();
        this.name = COKE.getValue();
        this.price = price;
    }

}

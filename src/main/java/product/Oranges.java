package product;

import java.math.BigDecimal;

import static product.ProductEnum.ORANGES;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Oranges extends Product {

    public Oranges(BigDecimal price) {
        super();
        this.name = ORANGES.getValue();
        this.price = price;
    }

}

package product;

import java.math.BigDecimal;

import static product.ProductEnum.BEANS;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Beans extends Product {

    public Beans(BigDecimal price) {
        super();
        this.name = BEANS.getValue();
        this.price = price;
    }

}

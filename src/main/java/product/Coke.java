package product;

import java.math.BigDecimal;

import static product.ProductEnum.COKE;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
class Coke extends Product {

    Coke(BigDecimal price) {
        super(COKE.getValue(), price);
    }

}

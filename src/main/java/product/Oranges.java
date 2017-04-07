package product;

import java.math.BigDecimal;

import static product.ProductEnum.ORANGES;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
class Oranges extends Product {

    Oranges(BigDecimal price) {
        super(ORANGES.getValue(), price);
    }

}

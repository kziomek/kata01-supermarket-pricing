package product;

import java.math.BigDecimal;

import static product.ProductEnum.BEANS;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
class Beans extends Product {

    Beans(BigDecimal price) {
        super(BEANS.getValue(), price);
    }

}

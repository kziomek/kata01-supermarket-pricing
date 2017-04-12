package product.pasta;

import product.Product;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 12/04/2017.
 */
public abstract class Pasta extends Product {

    Pasta(String name, BigDecimal price) {
        super(name, price);
    }

}

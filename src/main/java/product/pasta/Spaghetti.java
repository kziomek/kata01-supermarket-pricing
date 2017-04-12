package product.pasta;

import java.math.BigDecimal;

import static product.ProductEnum.SPAGHETTI;

/**
 * @author Krzysztof Ziomek
 * @since 12/04/2017.
 */
public class Spaghetti extends Pasta {

    public Spaghetti(BigDecimal price) {
        super(SPAGHETTI.getValue(), price);
    }

}

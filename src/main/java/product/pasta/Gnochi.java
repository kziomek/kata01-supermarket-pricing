package product.pasta;

import java.math.BigDecimal;

import static product.ProductEnum.GNOCHI;

/**
 * @author Krzysztof Ziomek
 * @since 12/04/2017.
 */
public class Gnochi extends Pasta {

    public Gnochi(BigDecimal price) {
        super(GNOCHI.getValue(), price);
    }

}

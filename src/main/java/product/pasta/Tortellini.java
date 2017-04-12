package product.pasta;

import java.math.BigDecimal;

import static product.ProductEnum.TORTELINNI;

/**
 * @author Krzysztof Ziomek
 * @since 12/04/2017.
 */
public class Tortellini extends Pasta {

    public Tortellini(BigDecimal price) {
        super(TORTELINNI.getValue(), price);
    }
}

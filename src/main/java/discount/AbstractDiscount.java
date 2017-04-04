package discount;

import basket.Item;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class AbstractDiscount implements Discount {

    @Override
    public BigDecimal calculateDiscount(Item item) {
        return BigDecimal.ZERO;
    }

}

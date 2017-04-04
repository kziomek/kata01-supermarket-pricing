package discount;

import basket.Item;

import java.math.BigDecimal;

/**
 * This class is to make sure that discount is ZERO until method in subclass is overridden
 *
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class BaseDiscount implements Discount {

    @Override
    public BigDecimal calculateDiscount(Item item) {
        return BigDecimal.ZERO;
    }

}

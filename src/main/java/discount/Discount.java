package discount;

import basket.Item;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public interface Discount {

    public BigDecimal calculateDiscount(Item item);

}

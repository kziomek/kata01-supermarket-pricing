package discount;

import basket.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Beans3For2Discount extends AbstractDiscount {

    private BigDecimal BASE_DISCOUNT_VALUE = new BigDecimal("0.50");
    private BigDecimal NUMBER_OF_ITEMS_ELIGIBLE_FOR_DISCOUNT = new BigDecimal("3");

    @Override
    public BigDecimal calculateDiscount(Item item) {
        BigDecimal discountValue;

        if (!"Beans".equals(item.getProduct().getName())) {
            discountValue = BigDecimal.ZERO;
        } else {
            BigDecimal numberOfDiscounts = item.getQuantity().divide(NUMBER_OF_ITEMS_ELIGIBLE_FOR_DISCOUNT, 0, RoundingMode.DOWN);
            discountValue = BASE_DISCOUNT_VALUE.multiply(numberOfDiscounts);
        }
        return discountValue;
    }

}

package discount.rule;

import basket.Item;
import discount.Discount;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public interface DiscountRule {

    Discount calculateDiscount(Item item);

}

package discount.rule;

import basket.Item;
import discount.Saving;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public interface DiscountRule {

    Saving calculateDiscount(Item item);

}

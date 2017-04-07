package discount.rule;

import basket.Item;
import discount.Discount;

import java.util.Optional;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public interface DiscountRule {

    Optional<Discount> calculateDiscount(Item item);

}

package discount;

import discount.rule.DiscountRule;

import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public interface DiscountRepository {

    List<DiscountRule> findAllDiscounts();

}

package discount;

import discount.rule.Beans3For2DiscountRule;
import discount.rule.Coke2For1PoundDiscountRule;
import discount.rule.DiscountRule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class InMemoryDiscountRepository implements DiscountRepository {

    @Override
    public List<DiscountRule> findAllDiscounts() {
        List<DiscountRule> discountStrategies = new ArrayList<>();
        discountStrategies.add(new Beans3For2DiscountRule());
        discountStrategies.add(new Coke2For1PoundDiscountRule());
        return discountStrategies;
    }

}

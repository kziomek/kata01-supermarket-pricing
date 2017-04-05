package discount;

import basket.Item;
import discount.rule.DiscountRule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class DiscountService {

    private DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<Discount> calculateDiscount(Item item) {
        List<Discount> discounts = new ArrayList<>();
        List<DiscountRule> allDiscountStrategies = discountRepository.findAllDiscounts();

        for (DiscountRule discountRule : allDiscountStrategies) {
            Discount discount = discountRule.calculateDiscount(item);
            if (discount != null) {
                discounts.add(discount);
            }
        }
        return discounts;
    }

}

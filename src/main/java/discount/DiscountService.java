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

    public List<Saving> calculateDiscount(Item item) {
        List<Saving> savings = new ArrayList<>();
        List<DiscountRule> allDiscountStrategies = discountRepository.findAllDiscounts();

        for (DiscountRule discountRule : allDiscountStrategies) {
            Saving saving = discountRule.calculateDiscount(item);
            if (saving != null) {
                savings.add(saving);
            }
        }
        return savings;
    }

}

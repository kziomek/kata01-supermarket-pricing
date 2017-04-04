package discount;

import basket.Item;

import java.math.BigDecimal;
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

    public BigDecimal calculateDiscount(Item item) {

        BigDecimal discountSum = BigDecimal.ZERO;

        List<Discount> allDiscounts = discountRepository.findAllDiscounts();
        for (Discount discount : allDiscounts) {
            discountSum = discountSum.add(discount.calculateDiscount(item));
        }
        return discountSum;
    }

}

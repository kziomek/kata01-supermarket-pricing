package discount;

import basket.Item;
import pricing.Saving;

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
        List<Discount> allDiscounts = discountRepository.findAllDiscounts();

        for (Discount discount : allDiscounts) {
            Saving saving = discount.calculateDiscount(item);
            if (saving != null) {
                savings.add(saving);
            }
        }
        return savings;
    }

}

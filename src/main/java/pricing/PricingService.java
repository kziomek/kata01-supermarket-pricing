package pricing;

import basket.Basket;
import basket.Item;
import discount.DiscountService;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class PricingService {

    private DiscountService discountService;

    public PricingService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public Receipt calculate(Basket basket) {

        BigDecimal subTotal = calculateSubTotal(basket);

        return new Receipt(basket, subTotal, null, null, null);

    }

    protected BigDecimal calculateSubTotal(Basket basket) {
        BigDecimal subTotal = BigDecimal.ZERO;
        for (Item item : basket.getItems()) {
            // todo move calculation to Item
            subTotal = subTotal.add(item.getQuantity().multiply(item.getProduct().getPrice()));
        }
        subTotal = subTotal.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        return subTotal;
    }

    protected BigDecimal calculateTotalSavings(Basket basket) {
        BigDecimal totalSavings = BigDecimal.ZERO;
        for (Item item : basket.getItems()) {
            totalSavings = totalSavings.add(discountService.calculateDiscount(item));
        }
        return totalSavings;
    }
}

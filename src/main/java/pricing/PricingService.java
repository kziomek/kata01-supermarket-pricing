package pricing;

import basket.Basket;
import basket.Item;
import discount.Discount;
import discount.DiscountService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class PricingService {

    private DiscountService discountService;

    public PricingService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public Pricing calculate(Basket basket) {

        BigDecimal subTotal = calculateSubTotal(basket);
        List<Discount> discounts = calculateAllSavings(basket);
        BigDecimal totalSavings = calculateTotalSavings(discounts);
        BigDecimal totalToPay = calculateTotalToPay(subTotal, totalSavings);

        return new Pricing(basket, subTotal, totalSavings, totalToPay, discounts);

    }

    protected BigDecimal calculateSubTotal(Basket basket) {
        BigDecimal subTotal = BigDecimal.ZERO;
        for (Item item : basket.getItems()) {
            subTotal = subTotal.add(item.getItemPrice());
        }
        subTotal = subTotal.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        return subTotal;
    }

    protected List<Discount> calculateAllSavings(Basket basket) {
        List<Discount> allDiscounts = new ArrayList<>();
        for (Item item : basket.getItems()) {
            allDiscounts.addAll(discountService.collectDiscounts(item));
        }
        return allDiscounts;
    }

    protected BigDecimal calculateTotalSavings(List<Discount> discounts) {
        BigDecimal totalSavings = BigDecimal.ZERO;
        for (Discount discount : discounts) {
            totalSavings = totalSavings.add(discount.getValue());
        }
        return totalSavings;
    }

    protected BigDecimal calculateTotalToPay(BigDecimal subTotal, BigDecimal totalSavings) {
        return subTotal.subtract(totalSavings);
    }

}

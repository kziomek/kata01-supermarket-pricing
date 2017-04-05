package pricing;

import basket.Basket;
import basket.Item;
import discount.DiscountService;
import discount.Saving;

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

    public Receipt calculate(Basket basket) {

        BigDecimal subTotal = calculateSubTotal(basket);
        List<Saving> savings = calculateAllSavings(basket);
        BigDecimal totalSavings = calculateTotalSavings(savings);
        BigDecimal totalToPay = calculateTotalToPay(subTotal, totalSavings);

        return new Receipt(basket, subTotal, totalSavings, totalToPay, savings);

    }

    protected BigDecimal calculateSubTotal(Basket basket) {
        BigDecimal subTotal = BigDecimal.ZERO;
        for (Item item : basket.getItems()) {
            subTotal = subTotal.add(item.getItemPrice());
        }
        subTotal = subTotal.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        return subTotal;
    }

    protected List<Saving> calculateAllSavings(Basket basket) {
        List<Saving> allSavings = new ArrayList<>();
        for (Item item : basket.getItems()) {
            allSavings.addAll(discountService.calculateDiscount(item));
        }
        return allSavings;
    }

    protected BigDecimal calculateTotalSavings(List<Saving> savings) {
        BigDecimal totalSavings = BigDecimal.ZERO;
        for (Saving saving : savings) {
            totalSavings = totalSavings.add(saving.getValue());
        }
        return totalSavings;
    }

    protected BigDecimal calculateTotalToPay(BigDecimal subTotal, BigDecimal totalSavings) {
        return subTotal.subtract(totalSavings);
    }

}

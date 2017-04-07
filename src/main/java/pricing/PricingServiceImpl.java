package pricing;

import basket.Basket;
import basket.Item;
import discount.Discount;
import discount.DiscountService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class PricingServiceImpl implements PricingService {

    private final DiscountService discountService;

    public PricingServiceImpl(DiscountService discountService) {
        this.discountService = discountService;
    }

    public Pricing calculate(Basket basket) {

        BigDecimal subTotal = calculateSubTotal(basket);
        List<Discount> discounts = calculateAllSavings(basket);
        BigDecimal totalSavings = calculateTotalSavings(discounts);
        BigDecimal totalToPay = calculateTotalToPay(subTotal, totalSavings);

        return new Pricing(basket, subTotal, totalSavings, totalToPay, discounts);

    }

    BigDecimal calculateSubTotal(Basket basket) {
        return basket.getItems().stream()
                .map(Item::getItemPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }

    List<Discount> calculateAllSavings(Basket basket) {
        return basket.getItems().stream()
                .map(discountService::collectDiscounts)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    BigDecimal calculateTotalSavings(List<Discount> discounts) {
        return discounts.stream()
                .map(Discount::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateTotalToPay(BigDecimal subTotal, BigDecimal totalSavings) {
        return subTotal.subtract(totalSavings);
    }

}

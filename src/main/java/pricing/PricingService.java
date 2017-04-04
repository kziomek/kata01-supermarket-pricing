package pricing;

import basket.Basket;
import basket.Item;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class PricingService {


    public Receipt calculate(Basket basket) {

        BigDecimal subTotal = calculateSubTotal(basket);

        return new Receipt(basket, subTotal, null, null, null);

    }

    protected BigDecimal calculateSubTotal(Basket basket) {
        BigDecimal subTotal = BigDecimal.ZERO;
        for (Item item : basket.getItems()) {
            subTotal = subTotal.add(item.getQuantity().multiply(item.getProduct().getPrice()));
        }
        subTotal = subTotal.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        return subTotal;
    }

    protected BigDecimal calculateTotalSavings(Basket basket) {
        return null;
    }
}

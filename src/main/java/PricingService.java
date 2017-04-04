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

    private BigDecimal calculateSubTotal(Basket basket) {
        BigDecimal subTotal = BigDecimal.ZERO;
        for (Item item : basket.getItems()) {
            subTotal = subTotal.add(item.getQuantity().multiply(item.getProduct().getPrice()));
        }
        return subTotal;
    }

}

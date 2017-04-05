package pricing;

import basket.Basket;
import discount.Saving;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Pricing {

    private final Basket basket;

    private final BigDecimal subTotal;

    private final BigDecimal totalSavings;

    private final BigDecimal totalToPay;

    private final List<Saving> savings;


    public Pricing(Basket basket, BigDecimal subTotal, BigDecimal totalSavings, BigDecimal totalToPay, List<Saving> savings) {
        this.basket = basket;
        this.subTotal = subTotal;
        this.totalSavings = totalSavings;
        this.totalToPay = totalToPay;
        this.savings = savings;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public BigDecimal getTotalSavings() {
        return totalSavings;
    }

    public BigDecimal getTotalToPay() {
        return totalToPay;
    }

    public List<Saving> getSavings() {
        return savings;
    }

    public Basket getBasket() {
        return basket;
    }
}

package pricing;

import basket.Basket;
import discount.Discount;

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

    private final List<Discount> discounts;


    public Pricing(Basket basket, BigDecimal subTotal, BigDecimal totalSavings, BigDecimal totalToPay, List<Discount> discounts) {
        this.basket = basket;
        this.subTotal = subTotal;
        this.totalSavings = totalSavings;
        this.totalToPay = totalToPay;
        this.discounts = discounts;
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

    public List<Discount> getSavings() {
        return discounts;
    }

    public Basket getBasket() {
        return basket;
    }
}

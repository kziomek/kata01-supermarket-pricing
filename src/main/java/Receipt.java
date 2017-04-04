import java.math.BigDecimal;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Receipt {

    private Basket basket;

    private BigDecimal subTotal;

    private BigDecimal totalSavings;

    private BigDecimal totalToPay;

    private List<Saving> savings;


    public Receipt(Basket basket, BigDecimal subTotal, BigDecimal totalSavings, BigDecimal totalToPay, List<Saving> savings) {
        this.basket = basket;
        this.subTotal = subTotal;
        this.totalSavings = totalSavings;
        this.totalToPay = totalToPay;
        this.savings = savings;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public Basket getBasket() {
        return basket;
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

}

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


    public BigDecimal getSubTotal() {
        return subTotal;
    }

}

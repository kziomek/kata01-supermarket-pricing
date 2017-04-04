package discount;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Coke2For1PoundDiscount extends BunchDiscount {

    @Override
    protected String getProductNameForDiscount() {
        return "Coke";
    }

    @Override
    protected BigDecimal getSingleDiscountValue() {
        return new BigDecimal("0.40");
    }

    @Override
    protected BigDecimal getNumberOfItemsRequiredForSingleDiscount() {
        return new BigDecimal("2");
    }

}

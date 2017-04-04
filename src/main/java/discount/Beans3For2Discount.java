package discount;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Beans3For2Discount extends BunchDiscount {

    @Override
    protected String getProductNameForDiscount() {
        return "Beans";
    }

    @Override
    protected BigDecimal getSingleDiscountValue() {
        return new BigDecimal("0.50");
    }

    @Override
    protected BigDecimal getNumberOfItemsRequiredForSingleDiscount() {
        return new BigDecimal("3");
    }

}

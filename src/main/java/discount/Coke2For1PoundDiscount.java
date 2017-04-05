package discount;

import java.math.BigDecimal;

import static product.ProductEnum.COKE;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Coke2For1PoundDiscount extends BunchDiscount {

    @Override
    protected String getDiscountDescription() {
        return "Coke 2 for £1";
    }

    @Override
    protected String getProductNameForDiscount() {
        return COKE.getValue();
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

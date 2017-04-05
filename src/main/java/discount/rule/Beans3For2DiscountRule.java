package discount.rule;

import java.math.BigDecimal;

import static product.ProductEnum.BEANS;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Beans3For2DiscountRule extends BunchDiscountRule {

    @Override
    protected String getDiscountDescription() {
        return "Beans 3 for 2";
    }

    @Override
    protected String getProductNameForDiscount() {
        return BEANS.getValue();
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

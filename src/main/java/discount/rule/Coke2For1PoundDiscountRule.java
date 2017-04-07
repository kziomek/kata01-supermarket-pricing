package discount.rule;

import product.Product;

import java.math.BigDecimal;

import static product.ProductEnum.COKE;
import static product.ProductFactory.getProduct;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Coke2For1PoundDiscountRule extends BunchDiscountRule {

    private static final BigDecimal ONE_POUND = BigDecimal.ONE;

    private final Product coke;

    public Coke2For1PoundDiscountRule() {
        this.coke = getProduct(COKE);
    }

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
        return coke.getPrice().multiply(new BigDecimal(2)).subtract(ONE_POUND);
    }

    @Override
    protected BigDecimal getNumberOfItemsRequiredForSingleDiscount() {
        return new BigDecimal("2");
    }

}

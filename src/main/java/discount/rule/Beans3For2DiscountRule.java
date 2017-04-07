package discount.rule;

import product.Product;

import java.math.BigDecimal;

import static product.ProductEnum.BEANS;
import static product.ProductFactory.getProduct;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Beans3For2DiscountRule extends BunchDiscountRule {

    private final Product beans;

    public Beans3For2DiscountRule() {
        this.beans = getProduct(BEANS);
    }

    @Override
    protected String getDiscountDescription() {
        return "Beans 3 for 2";
    }

    @Override
    protected String getProductNameForDiscount() {
        return beans.getName();
    }

    @Override
    protected BigDecimal getSingleDiscountValue() {
        return beans.getPrice();
    }

    @Override
    protected BigDecimal getNumberOfItemsRequiredForSingleDiscount() {
        return new BigDecimal("3");
    }

}

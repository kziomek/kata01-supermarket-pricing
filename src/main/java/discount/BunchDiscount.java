package discount;

import basket.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public abstract class BunchDiscount extends BaseDiscount {

    @Override
    public BigDecimal calculateDiscount(Item item) {
        BigDecimal discountValue;

        if (!getProductNameForDiscount().equals(item.getProduct().getName())) {
            discountValue = BigDecimal.ZERO;
        } else {
            BigDecimal numberOfDiscounts = item.getQuantity().divide(getNumberOfItemsRequiredForSingleDiscount(), 0, RoundingMode.DOWN);
            discountValue = getSingleDiscountValue().multiply(numberOfDiscounts);
        }
        return discountValue;
    }

    protected abstract String getProductNameForDiscount();

    protected abstract BigDecimal getSingleDiscountValue();

    protected abstract BigDecimal getNumberOfItemsRequiredForSingleDiscount();


}

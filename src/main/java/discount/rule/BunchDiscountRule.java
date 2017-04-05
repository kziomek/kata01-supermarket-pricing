package discount.rule;

import basket.Item;
import discount.Saving;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public abstract class BunchDiscountRule implements DiscountRule {

    @Override
    public Saving calculateDiscount(Item item) {

        if (!isApplicable(item)) {
            return null;
        }

        BigDecimal numberOfDiscounts = item.getQuantity().divide(getNumberOfItemsRequiredForSingleDiscount(), 0, RoundingMode.DOWN);
        BigDecimal discountValue = getSingleDiscountValue().multiply(numberOfDiscounts);

        return new Saving(getDiscountDescription(), discountValue);

    }

    private boolean isApplicable(Item item){
        return getProductNameForDiscount().equals(item.getProduct().getName());
    }

    protected abstract String getDiscountDescription();

    protected abstract String getProductNameForDiscount();

    protected abstract BigDecimal getSingleDiscountValue();

    protected abstract BigDecimal getNumberOfItemsRequiredForSingleDiscount();


}

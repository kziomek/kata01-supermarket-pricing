package discount;

import basket.Item;
import pricing.Saving;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public abstract class BunchDiscount implements Discount {

    @Override
    public Saving calculateDiscount(Item item) {

        if (!getProductNameForDiscount().equals(item.getProduct().getName())) {
            return null;
        }

        BigDecimal numberOfDiscounts = item.getQuantity().divide(getNumberOfItemsRequiredForSingleDiscount(), 0, RoundingMode.DOWN);
        BigDecimal discountValue = getSingleDiscountValue().multiply(numberOfDiscounts);

        return new Saving(getDiscountDescription(), discountValue);

    }

    protected abstract String getDiscountDescription();

    protected abstract String getProductNameForDiscount();

    protected abstract BigDecimal getSingleDiscountValue();

    protected abstract BigDecimal getNumberOfItemsRequiredForSingleDiscount();


}

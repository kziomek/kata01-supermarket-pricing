package discount.rule;

import basket.Item;
import discount.Discount;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public abstract class BunchDiscountRule implements DiscountRule {

    @Override
    public final Optional<Discount> calculateDiscount(Item item) {

        if (!isApplicable(item)) {
            return Optional.empty();
        }

        BigDecimal numberOfDiscounts = item.getQuantity().divide(getNumberOfItemsRequiredForSingleDiscount(), 0, RoundingMode.DOWN);
        BigDecimal discountValue = getSingleDiscountValue().multiply(numberOfDiscounts);

        return Optional.of(new Discount(getDiscountDescription(), discountValue));

    }

    private boolean isApplicable(Item item) {
        return getProductNameForDiscount().equals(item.getProductName());
    }

    protected abstract String getDiscountDescription();

    protected abstract String getProductNameForDiscount();

    protected abstract BigDecimal getSingleDiscountValue();

    protected abstract BigDecimal getNumberOfItemsRequiredForSingleDiscount();


}

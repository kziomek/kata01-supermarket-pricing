package discount.rule;

import basket.Basket;
import basket.Item;
import discount.Discount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Krzysztof Ziomek
 * @since 12/04/2017.
 */
public class Any2ProductFor2PoundsDiscountRule {

    BigDecimal PRICE_FOR_2_PRODUCTS = new BigDecimal("2");
    List<String> productNames;

    public Any2ProductFor2PoundsDiscountRule(List<String> productGroup) {
        this.productNames = productGroup;
    }


    public final Optional<Discount> calculateDiscount(Basket basket) {
        BigDecimal discountValue = BigDecimal.ZERO;
        boolean borrowed = false;

        List<Item> itemList = basket.getItems().stream()
                .filter(item -> productNames.contains(item.getProductName()))
                .sorted((itemA, itemB) -> itemB.getProductPrice().compareTo(itemA.getProductPrice()))
                .collect(Collectors.toList());

        for (int i = 0; i < itemList.size(); i++) {
            Item itemI = itemList.get(i);
            BigDecimal tmpQuantity = itemI.getQuantity();
            if (borrowed) {
                borrowed = false;
                tmpQuantity = tmpQuantity.subtract(BigDecimal.ONE);
            }

            while (tmpQuantity.compareTo(new BigDecimal("2")) >= 0) {
                BigDecimal sum = new BigDecimal("2").multiply(itemI.getProductPrice());
                discountValue = discountValue.add(sum.subtract(PRICE_FOR_2_PRODUCTS));
                tmpQuantity = tmpQuantity.subtract(new BigDecimal("2"));
            }

            if (tmpQuantity.compareTo(BigDecimal.ONE) == 0 && i < itemList.size() - 1) {
                BigDecimal sum = itemI.getProductPrice().add(itemList.get(i + 1).getProductPrice());
                discountValue = discountValue.add(sum.subtract(PRICE_FOR_2_PRODUCTS));
                borrowed = true;

            }

        }

        return Optional.of(new Discount("Any2ProductFor2PoundsDiscountRule", discountValue));

    }

}

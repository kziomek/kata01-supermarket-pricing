package discount.rule;

import basket.Basket;
import basket.Item;
import discount.Discount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

/**
 * @author Krzysztof Ziomek
 * @since 12/04/2017.
 */
public class Any2ProductFor2PoundsDiscountRule {

    BigDecimal TWO = new BigDecimal("2");
    BigDecimal PRICE_FOR_2_PRODUCTS = TWO;
    List<String> discountableProducts;

    public Any2ProductFor2PoundsDiscountRule(List<String> productGroup) {
        this.discountableProducts = productGroup;
    }


    public final Optional<Discount> calculateDiscount(Basket basket) {
        List<Item> items = extractDiscountableDescSortedItems(basket, discountableProducts);
        BigDecimal totalDiscount = ZERO;

        BigDecimal leftValue = ZERO;
        for (Item item : items) {
            BigDecimal currQuantity = item.getQuantity();

            if (ZERO.compareTo(leftValue) < 0) {
                BigDecimal discountValue = item.getProductPrice().add(leftValue).subtract(PRICE_FOR_2_PRODUCTS);
                totalDiscount = totalDiscount.add(discountValue);
                leftValue = ZERO;
                currQuantity = currQuantity.subtract(ONE);
            }

            while (currQuantity.compareTo(TWO) >= 0) {
                BigDecimal discountValue = TWO.multiply(item.getProductPrice()).subtract(PRICE_FOR_2_PRODUCTS);
                totalDiscount = totalDiscount.add(discountValue);
                currQuantity = currQuantity.subtract(TWO);
            }

            if (currQuantity.compareTo(ONE) == 0) {
                leftValue = item.getProductPrice();
            }
        }


        return Optional.of(new Discount("Any2ProductFor2PoundsDiscountRule", totalDiscount));

    }

    private List<Item> extractDiscountableDescSortedItems(Basket basket, List<String> discountableProducts) {
        return basket.getItems().stream()
                .filter(item -> discountableProducts.contains(item.getProductName()))
                .sorted((itemA, itemB) -> itemB.getProductPrice().compareTo(itemA.getProductPrice()))
                .collect(Collectors.toList());
    }

}

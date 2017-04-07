package discount;

import basket.Item;

import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 07/04/2017.
 */
public interface DiscountService {

    List<Discount> collectDiscounts(Item item);

}

package discount;

import basket.Item;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public interface Discount {

    Saving calculateDiscount(Item item);

}

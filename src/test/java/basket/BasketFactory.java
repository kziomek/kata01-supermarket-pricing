package basket;

import java.math.BigDecimal;

import static product.ProductEnum.*;
import static product.ProductFactory.getProduct;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class BasketFactory {

    public static Basket getFullBasket() {
        Basket basket = new Basket();

        basket.addItem(new Item(getProduct(BEANS), new BigDecimal(3)));
        basket.addItem(new Item(getProduct(COKE), new BigDecimal(2)));
        basket.addItem(new Item(getProduct(ORANGES), new BigDecimal(0.2)));

        return basket;
    }
}

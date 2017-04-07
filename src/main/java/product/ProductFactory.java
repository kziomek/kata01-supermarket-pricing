package product;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class ProductFactory {

    public static Product getProduct(ProductEnum productEnum) {

        switch (productEnum) {
            case BEANS:
                return new Beans(new BigDecimal("0.50"));
            case COKE:
                return new Coke(new BigDecimal("0.70"));
            case ORANGES:
                return new Oranges(new BigDecimal("1.99"));
        }
        return null;
    }

}

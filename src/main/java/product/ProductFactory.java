package product;

import product.pasta.Gnochi;
import product.pasta.Spaghetti;
import product.pasta.Tortellini;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class ProductFactory {

    private ProductFactory() {
    }

    public static Product getProduct(ProductEnum productEnum) {

        Product product = null;
        switch (productEnum) {
            case BEANS:
                product = new Beans(new BigDecimal("0.50"));
                break;
            case COKE:
                product = new Coke(new BigDecimal("0.70"));
                break;
            case ORANGES:
                product = new Oranges(new BigDecimal("1.99"));
                break;
            case TORTELINNI:
                product = new Tortellini(new BigDecimal("1.50"));
                break;
            case SPAGHETTI:
                product = new Spaghetti(new BigDecimal("1.30"));
                break;
            case GNOCHI:
                product = new Gnochi(new BigDecimal("1.80"));
                break;
        }

        return product;

    }

}

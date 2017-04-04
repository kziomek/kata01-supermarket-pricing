package product;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public abstract class Product {

    protected String name;

    protected BigDecimal price;


    public Product() {
    }

    public Product(String name, String barcode, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

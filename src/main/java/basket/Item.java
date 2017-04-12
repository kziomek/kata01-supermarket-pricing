package basket;

import product.Product;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Item {

    private final Product product;

    private final BigDecimal quantity;


    public Item(Product product, BigDecimal quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal getItemPrice() {
        return getQuantity().multiply(product.getPrice());
    }

    public BigDecimal getProductPrice() {
        return product.getPrice();
    }

    public String getProductName() {
        return product.getName();
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}

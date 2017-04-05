package basket;

import product.Product;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Item {

    private Product product;

    private BigDecimal quantity;


    public Item(Product product, BigDecimal quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal getItemPrice() {
        return getQuantity().multiply(getProduct().getPrice());
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}

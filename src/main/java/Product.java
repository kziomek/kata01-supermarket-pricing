import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class Product {

    private String name;

    private String barcode;

    private BigDecimal price;


    public Product(String name, String barcode, BigDecimal price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

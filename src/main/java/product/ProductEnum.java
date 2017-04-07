package product;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public enum ProductEnum {

    BEANS("Beans"),
    COKE("Coke"),
    ORANGES("Oranges");

    private final String value;

    ProductEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}

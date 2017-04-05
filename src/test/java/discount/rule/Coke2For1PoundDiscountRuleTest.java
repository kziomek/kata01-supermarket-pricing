package discount.rule;

import basket.Item;
import discount.Discount;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static product.ProductEnum.COKE;
import static product.ProductEnum.ORANGES;
import static product.ProductFactory.getProduct;

/**
 * @author Krzysztof Ziomek
 * @since 05/04/2017.
 */
public class Coke2For1PoundDiscountRuleTest {

    @Test
    public void calculateDiscountShouldReturnNullForItemDifferentThenCoke() {
        // prepare
        Coke2For1PoundDiscountRule rule = new Coke2For1PoundDiscountRule();
        Item item = new Item(getProduct(ORANGES), ONE);

        // execute
        Discount discount = rule.calculateDiscount(item);

        // assert
        Assert.assertNull(discount);
    }

    @Test
    public void calculateDiscountShouldReturn0pFor1Coke() {
        // prepare
        Coke2For1PoundDiscountRule rule = new Coke2For1PoundDiscountRule();
        Item item = new Item(getProduct(COKE), ONE);

        // execute
        Discount discount = rule.calculateDiscount(item);

        // assert
        Assert.assertEquals(new BigDecimal("0.00"), discount.getValue());
    }

    @Test
    public void calculateDiscountShouldReturn40pFor2Cokes() {
        // prepare
        Coke2For1PoundDiscountRule rule = new Coke2For1PoundDiscountRule();
        Item item = new Item(getProduct(COKE), new BigDecimal(2));

        // execute
        Discount discount = rule.calculateDiscount(item);

        // assert
        Assert.assertEquals(new BigDecimal("0.40"), discount.getValue());
    }

    @Test
    public void calculateDiscountShouldReturn120pFor7Cokes() {
        // prepare
        Coke2For1PoundDiscountRule rule = new Coke2For1PoundDiscountRule();
        Item item = new Item(getProduct(COKE), new BigDecimal(7));

        // execute
        Discount discount = rule.calculateDiscount(item);

        // assert
        Assert.assertEquals(new BigDecimal("1.20"), discount.getValue());
    }

}
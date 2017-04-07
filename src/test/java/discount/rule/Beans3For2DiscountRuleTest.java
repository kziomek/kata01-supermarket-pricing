package discount.rule;

import basket.Item;
import discount.Discount;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static java.math.BigDecimal.ONE;
import static product.ProductEnum.BEANS;
import static product.ProductEnum.COKE;
import static product.ProductFactory.getProduct;

/**
 * @author Krzysztof Ziomek
 * @since 05/04/2017.
 */
public class Beans3For2DiscountRuleTest {

    @Test
    public void calculateDiscountShouldReturnNullForItemDifferentThenBeans() {
        // prepare
        Beans3For2DiscountRule rule = new Beans3For2DiscountRule();
        Item item = new Item(getProduct(COKE), ONE);

        // execute
        Optional<Discount> discount = rule.calculateDiscount(item);

        // assert
        Assert.assertFalse(discount.isPresent());
    }

    @Test
    public void calculateDiscountShouldReturn0pFor1Beans() {
        // prepare
        Beans3For2DiscountRule rule = new Beans3For2DiscountRule();
        Item item = new Item(getProduct(BEANS), ONE);

        // execute
        Optional<Discount> discount = rule.calculateDiscount(item);

        // assert
        Assert.assertTrue(discount.isPresent());
        Assert.assertEquals(new BigDecimal("0.00"), discount.get().getValue());
    }

    @Test
    public void calculateDiscountShouldReturn50pFor3Beans() {
        // prepare
        Beans3For2DiscountRule rule = new Beans3For2DiscountRule();
        Item item = new Item(getProduct(BEANS), new BigDecimal("3"));

        // execute
        Optional<Discount> discount = rule.calculateDiscount(item);

        // assert
        Assert.assertTrue(discount.isPresent());
        Assert.assertEquals(new BigDecimal("0.50"), discount.get().getValue());
    }

    @Test
    public void calculateDiscountShouldReturn100pFor7Beans() {
        // prepare
        Beans3For2DiscountRule rule = new Beans3For2DiscountRule();
        Item item = new Item(getProduct(BEANS), new BigDecimal("7"));

        // execute
        Optional<Discount> discount = rule.calculateDiscount(item);

        // assert
        Assert.assertTrue(discount.isPresent());
        Assert.assertEquals(new BigDecimal("1.00"), discount.get().getValue());

    }

}
package discount.rule;

import basket.Basket;
import basket.Item;
import discount.Discount;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static product.ProductEnum.*;
import static product.ProductFactory.getProduct;

/**
 * @author Krzysztof Ziomek
 * @since 12/04/2017.
 */
public class Any2ProductFor2PoundsDiscountRuleTest {


    @Test
    public void calculateDiscountShouldReturn80pForOneSpaghettiAndOneTortelinni() throws Exception {
        // prepare
        Any2ProductFor2PoundsDiscountRule rule = new Any2ProductFor2PoundsDiscountRule(Arrays.asList(SPAGHETTI.getValue(), TORTELINNI.getValue(), GNOCHI.getValue()));
        Basket basket = new Basket();

        basket.addItem(new Item(getProduct(SPAGHETTI), new BigDecimal(1)));
        basket.addItem(new Item(getProduct(TORTELINNI), new BigDecimal(1)));

        // execute
        Optional<Discount> discount = rule.calculateDiscount(basket);

        // assert
        Assert.assertTrue(discount.isPresent());
        Assert.assertEquals(new BigDecimal("0.80"), discount.get().getValue());

    }

    @Test
    public void calculateDiscountShouldReturn130pForOneSpaghettiAndOneTortelinniAndOneGnochi() throws Exception {
        // prepare
        Any2ProductFor2PoundsDiscountRule rule = new Any2ProductFor2PoundsDiscountRule(Arrays.asList(SPAGHETTI.getValue(), TORTELINNI.getValue(), GNOCHI.getValue()));
        Basket basket = new Basket();

        basket.addItem(new Item(getProduct(SPAGHETTI), new BigDecimal(1)));
        basket.addItem(new Item(getProduct(TORTELINNI), new BigDecimal(1)));
        basket.addItem(new Item(getProduct(GNOCHI), new BigDecimal(1)));

        // execute
        Optional<Discount> discount = rule.calculateDiscount(basket);

        // assert
        Assert.assertTrue(discount.isPresent());
        Assert.assertEquals(new BigDecimal("1.30"), discount.get().getValue());
    }

    @Test
    public void calculateDiscountShouldReturnDiscountForSpaghettiAndGnochiWhen3PastasAnd2NonPastas() throws Exception {

        // prepare
        Any2ProductFor2PoundsDiscountRule rule = new Any2ProductFor2PoundsDiscountRule(Arrays.asList(SPAGHETTI.getValue(), TORTELINNI.getValue(), GNOCHI.getValue()));
        Basket basket = new Basket();

        basket.addItem(new Item(getProduct(SPAGHETTI), new BigDecimal(1)));
        basket.addItem(new Item(getProduct(TORTELINNI), new BigDecimal(1)));
        basket.addItem(new Item(getProduct(GNOCHI), new BigDecimal(1)));
        basket.addItem(new Item(getProduct(COKE), new BigDecimal(1)));
        basket.addItem(new Item(getProduct(ORANGES), new BigDecimal(1)));

        // execute
        Optional<Discount> discount = rule.calculateDiscount(basket);

        // assert
        Assert.assertTrue(discount.isPresent());
        Assert.assertEquals(new BigDecimal("1.30"), discount.get().getValue());

    }

    @Test
    public void calculateDiscount() throws Exception {

        // prepare
        Any2ProductFor2PoundsDiscountRule rule = new Any2ProductFor2PoundsDiscountRule(Arrays.asList(SPAGHETTI.getValue(), TORTELINNI.getValue(), GNOCHI.getValue()));
        Basket basket = new Basket();

        basket.addItem(new Item(getProduct(GNOCHI), new BigDecimal(3)));
        basket.addItem(new Item(getProduct(TORTELINNI), new BigDecimal(1)));
        basket.addItem(new Item(getProduct(SPAGHETTI), new BigDecimal(1)));

        // execute
        Optional<Discount> discount = rule.calculateDiscount(basket);

        // assert
        Assert.assertTrue(discount.isPresent());
        Assert.assertEquals(new BigDecimal("2.90"), discount.get().getValue());

    }


}
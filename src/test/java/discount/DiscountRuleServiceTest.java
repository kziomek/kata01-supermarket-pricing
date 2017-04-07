package discount;

import basket.Item;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static product.ProductEnum.BEANS;
import static product.ProductEnum.COKE;
import static product.ProductFactory.getProduct;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class DiscountRuleServiceTest {

    @Test
    public void collectDiscountsShouldReturn50pOn3BeansItem() throws Exception {
        // prepare
        DiscountService discountService = new DiscountServiceImpl(new InMemoryDiscountRepository());
        Item beansItem = new Item(getProduct(BEANS), new BigDecimal(3));

        // execute
        List<Discount> discounts = discountService.collectDiscounts(beansItem);

        // assert
        Assert.assertEquals(new BigDecimal("0.50"), discounts.get(0).getValue());

    }

    @Test
    public void collectDiscountsShouldReturn40pOn2CokesItem() throws Exception {
        // prepare
        DiscountService discountService = new DiscountServiceImpl(new InMemoryDiscountRepository());
        Item beansItem = new Item(getProduct(COKE), new BigDecimal(2));

        // execute
        List<Discount> discounts = discountService.collectDiscounts(beansItem);

        // assert
        Assert.assertEquals(new BigDecimal("0.40"), discounts.get(0).getValue());

    }

}
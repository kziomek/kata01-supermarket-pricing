package discount;

import basket.Item;
import org.junit.Assert;
import org.junit.Test;
import product.ProductFactory;

import java.math.BigDecimal;

import static product.ProductEnum.BEANS;
import static product.ProductEnum.COKE;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class DiscountServiceTest {

    @Test
    public void calculateDiscountShouldReturn50PencesOn3BeansItem() throws Exception {
        // prepare
        DiscountService discountService = new DiscountService();
        Item beansItem = new Item(ProductFactory.getProduct(BEANS), new BigDecimal(3));

        // execute
        BigDecimal result = discountService.calculateDiscount(beansItem);

        // assert
        Assert.assertEquals(new BigDecimal("0.50"), result);

    }

    @Test
    public void calculateDiscountShouldReturn40PencesOn2CokesItem() throws Exception {
        // prepare
        DiscountService discountService = new DiscountService();
        Item beansItem = new Item(ProductFactory.getProduct(COKE), new BigDecimal(2));

        // execute
        BigDecimal result = discountService.calculateDiscount(beansItem);

        // assert
        Assert.assertEquals(new BigDecimal("0.40"), result);

    }

}
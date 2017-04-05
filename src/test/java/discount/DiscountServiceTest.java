package discount;

import basket.Item;
import org.junit.Assert;
import org.junit.Test;
import pricing.Saving;
import product.ProductFactory;

import java.math.BigDecimal;
import java.util.List;

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
        DiscountService discountService = new DiscountService(new InMemoryDiscountRepository());
        Item beansItem = new Item(ProductFactory.getProduct(BEANS), new BigDecimal(3));

        // execute
        List<Saving> savings = discountService.calculateDiscount(beansItem);

        // assert
        Assert.assertEquals(new BigDecimal("0.50"), savings.get(0).getValue());

    }

    @Test
    public void calculateDiscountShouldReturn40PencesOn2CokesItem() throws Exception {
        // prepare
        DiscountService discountService = new DiscountService(new InMemoryDiscountRepository());
        Item beansItem = new Item(ProductFactory.getProduct(COKE), new BigDecimal(2));

        // execute
        List<Saving> savings = discountService.calculateDiscount(beansItem);

        // assert
        Assert.assertEquals(new BigDecimal("0.40"), savings.get(0).getValue());

    }

}
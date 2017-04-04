package pricing;

import basket.Basket;
import basket.BasketFactory;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class PricingServiceTest {

    @Test
    public void calculateShouldReturnReceiptWithCalculatedSubTotalValue() throws Exception {
        // prepare
        PricingService pricingService = new PricingService();

        Basket basket = new Basket();

        // execute
        Receipt result = pricingService.calculate(basket);

        // assert
        Assert.assertNotNull(result.getSubTotal());

    }


    @Test
    public void calculateSubTotalShouldReturnSummedPriceOfItemsForGivenBasket() {
        // prepare
        PricingService pricingService = new PricingService();
        Basket basket = BasketFactory.getFullBasket();

        // execute
        BigDecimal subTotal = pricingService.calculateSubTotal(basket);

        // assert
        Assert.assertEquals(new BigDecimal("3.30"), subTotal);
    }

}
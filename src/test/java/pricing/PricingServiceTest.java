package pricing;

import basket.Basket;
import basket.BasketFactory;
import discount.DiscountService;
import discount.InMemoryDiscountRepository;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class PricingServiceTest {

    @Test //Todo upgrade test to full Basket
    public void calculateShouldReturnReceiptWithCalculatedSubTotalValue() throws Exception {
        // prepare
        PricingService pricingService = new PricingService(new DiscountService(new InMemoryDiscountRepository()));

        Basket basket = new Basket();

        // execute
        Receipt result = pricingService.calculate(basket);

        // assert
        Assert.assertNotNull(result.getSubTotal());

    }


    @Test
    public void calculateSubTotalShouldReturnSummedPriceOfItemsForGivenBasket() {
        // prepare
        PricingService pricingService = new PricingService(new DiscountService(new InMemoryDiscountRepository()));
        Basket basket = BasketFactory.getFullBasket();

        // execute
        BigDecimal subTotal = pricingService.calculateSubTotal(basket);

        // assert
        Assert.assertEquals(new BigDecimal("3.30"), subTotal);
    }

    @Test
    public void calculateTotalSavingsShouldReturnSummedValueOfSavings() {
        // prepare
        PricingService pricingService = new PricingService(new DiscountService(new InMemoryDiscountRepository()));
        Basket basket = BasketFactory.getFullBasket();

        // execute
        BigDecimal subTotal = pricingService.calculateTotalSavings(basket);

        // assert
        Assert.assertEquals(new BigDecimal("0.90"), subTotal);
    }

}
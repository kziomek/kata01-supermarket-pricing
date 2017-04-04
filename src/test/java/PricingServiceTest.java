import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class PricingServiceTest {

    @Test
    public void calculateShouldReturnBasketWithCalculatedSubTotalValue() throws Exception {
        // prepare
        PricingService pricingService = new PricingService();

        Basket basket = new Basket();

        // execute
        Receipt result = pricingService.calculate(basket);

        // assert
        Assert.assertNotNull(result.getSubTotal());

    }

}
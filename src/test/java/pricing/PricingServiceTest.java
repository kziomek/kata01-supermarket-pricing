package pricing;

import basket.Basket;
import basket.BasketFactory;
import discount.DiscountServiceImpl;
import discount.InMemoryDiscountRepository;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author Krzysztof Ziomek
 * @since 07/04/2017.
 */
public class PricingServiceTest {

    @Test
    public void calculateShouldReturnPricingWithValidValuesForGivenBasket() throws Exception {
        // prepare
        PricingService pricingService = new PricingServiceImpl(new DiscountServiceImpl(new InMemoryDiscountRepository()));
        Basket basket = BasketFactory.getFullBasket();

        // execute
        Pricing result = pricingService.calculate(basket);

        // assert
        assertEquals(new BigDecimal("3.30"), result.getSubTotal());
        assertEquals(new BigDecimal("0.90"), result.getTotalSavings());
        assertEquals(new BigDecimal("2.40"), result.getTotalToPay());
        assertEquals(2, result.getSavings().size());
        assertEquals(3, result.getBasket().getItems().size());

    }

}

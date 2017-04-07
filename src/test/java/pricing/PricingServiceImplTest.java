package pricing;

import basket.Basket;
import basket.BasketFactory;
import discount.Discount;
import discount.DiscountServiceImpl;
import discount.InMemoryDiscountRepository;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class PricingServiceImplTest {

    @Test
    public void calculateSubTotalShouldReturnValidSubTotalForGivenBasket() {
        // prepare
        PricingServiceImpl pricingService = new PricingServiceImpl(new DiscountServiceImpl(new InMemoryDiscountRepository()));
        Basket basket = BasketFactory.getFullBasket();

        // execute
        BigDecimal subTotal = pricingService.calculateSubTotal(basket);

        // assert
        assertEquals(new BigDecimal("3.30"), subTotal);
    }

    @Test
    public void calculateTotalSavingsShouldReturnValidTotalSavingsForGivenListOfSavings() {
        // prepare
        PricingServiceImpl pricingService = new PricingServiceImpl(new DiscountServiceImpl(new InMemoryDiscountRepository()));

        List<Discount> discounts = new ArrayList<>();
        discounts.add(new Discount("Beans 3 for 2", new BigDecimal("0.50")));
        discounts.add(new Discount("Coke 2 for £1", new BigDecimal("0.40")));

        // execute
        BigDecimal subTotal = pricingService.calculateTotalSavings(discounts);

        // assert
        assertEquals(new BigDecimal("0.90"), subTotal);
    }

    @Test
    public void calculateAllSavingsShouldReturnListOfTwoSavingsForGivenBasket() {
        // prepare
        PricingServiceImpl pricingService = new PricingServiceImpl(new DiscountServiceImpl(new InMemoryDiscountRepository()));
        Basket basket = BasketFactory.getFullBasket();

        // execute
        List<Discount> discounts = pricingService.calculateAllSavings(basket);

        // assert
        assertEquals(2, discounts.size());
        assertEquals("Beans 3 for 2", discounts.get(0).getName());
        assertEquals(new BigDecimal("0.50"), discounts.get(0).getValue());
        assertEquals("Coke 2 for £1", discounts.get(1).getName());
        assertEquals(new BigDecimal("0.40"), discounts.get(1).getValue());

    }

}
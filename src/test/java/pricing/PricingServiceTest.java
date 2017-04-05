package pricing;

import basket.Basket;
import basket.BasketFactory;
import discount.DiscountService;
import discount.InMemoryDiscountRepository;
import discount.Saving;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class PricingServiceTest {

    @Test
    public void calculateShouldReturnReceiptWithValidValuesForGivenBasket() throws Exception {
        // prepare
        PricingService pricingService = new PricingService(new DiscountService(new InMemoryDiscountRepository()));
        Basket basket = BasketFactory.getFullBasket();

        // execute
        Receipt result = pricingService.calculate(basket);

        // assert
        assertEquals(new BigDecimal("3.30"), result.getSubTotal());
        assertEquals(new BigDecimal("0.90"), result.getTotalSavings());
        assertEquals(new BigDecimal("2.40"), result.getTotalToPay());
        assertEquals(2, result.getSavings().size());
        assertEquals(3, result.getBasket().getItems().size());

    }


    @Test
    public void calculateSubTotalShouldReturnValidSubTotalForGivenBasket() {
        // prepare
        PricingService pricingService = new PricingService(new DiscountService(new InMemoryDiscountRepository()));
        Basket basket = BasketFactory.getFullBasket();

        // execute
        BigDecimal subTotal = pricingService.calculateSubTotal(basket);

        // assert
        assertEquals(new BigDecimal("3.30"), subTotal);
    }

    @Test
    public void calculateTotalSavingsShouldReturnValidTotalSavingsForGivenListOfSavings() {
        // prepare
        PricingService pricingService = new PricingService(new DiscountService(new InMemoryDiscountRepository()));

        List<Saving> savings = new ArrayList<>();
        savings.add(new Saving("Beans 3 for 2", new BigDecimal("0.50")));
        savings.add(new Saving("Coke 2 for £1", new BigDecimal("0.40")));

        // execute
        BigDecimal subTotal = pricingService.calculateTotalSavings(savings);

        // assert
        assertEquals(new BigDecimal("0.90"), subTotal);
    }

    @Test
    public void calculateAllSavingsShouldReturnListOfTwoSavingsForGivenBasket() {
        // prepare
        PricingService pricingService = new PricingService(new DiscountService(new InMemoryDiscountRepository()));
        Basket basket = BasketFactory.getFullBasket();

        // execute
        List<Saving> savings = pricingService.calculateAllSavings(basket);

        // assert
        assertEquals(2, savings.size());
        assertEquals("Beans 3 for 2", savings.get(0).getName());
        assertEquals(new BigDecimal("0.50"), savings.get(0).getValue());
        assertEquals("Coke 2 for £1", savings.get(1).getName());
        assertEquals(new BigDecimal("0.40"), savings.get(1).getValue());

    }


}
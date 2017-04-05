package pricing;

import basket.Basket;
import basket.BasketFactory;
import discount.DiscountService;
import discount.InMemoryDiscountRepository;
import discount.Discount;
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
        Pricing result = pricingService.calculate(basket);

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
        PricingService pricingService = new PricingService(new DiscountService(new InMemoryDiscountRepository()));
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
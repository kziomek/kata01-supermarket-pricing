package pricing;

import basket.Basket;

/**
 * @author Krzysztof Ziomek
 * @since 07/04/2017.
 */
public interface PricingService {

    Pricing calculate(Basket basket);
}

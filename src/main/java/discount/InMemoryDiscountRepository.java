package discount;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class InMemoryDiscountRepository implements DiscountRepository {

    @Override
    public List<Discount> findAllDiscounts() {
        List<Discount> discounts = new ArrayList<>();
        discounts.add(new Beans3For2Discount());
        discounts.add(new Coke2For1PoundDiscount());
        return discounts;
    }

}

package discount;

import basket.Item;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Krzysztof Ziomek
 * @since 04/04/2017.
 */
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<Discount> collectDiscounts(Item item) {

        return discountRepository.findAllDiscounts().stream()
                .map(discountRule -> discountRule.calculateDiscount(item))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

    }

}

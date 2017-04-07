package product;

import org.junit.Assert;
import org.junit.Test;

import static product.ProductEnum.*;

/**
 * @author Krzysztof Ziomek
 * @since 07/04/2017.
 */
public class ProductFactoryTest {

    @Test
    public void getProductShouldReturnBeansWhenBeansRequested(){

        // execute
        Product product = ProductFactory.getProduct(BEANS);

        // assert
        Assert.assertNotNull(product);
        Assert.assertEquals(Beans.class, product.getClass());
    }

    @Test
    public void getProductShouldReturnCokeWhenCokeRequested(){

        // execute
        Product product = ProductFactory.getProduct(COKE);

        // assert
        Assert.assertNotNull(product);
        Assert.assertEquals(Coke.class, product.getClass());
    }

    @Test
    public void getProductShouldReturnOrangesWhenOrangesRequested(){

        // execute
        Product product = ProductFactory.getProduct(ORANGES);

        // assert
        Assert.assertNotNull(product);
        Assert.assertEquals(Oranges.class, product.getClass());
    }

    @Test
    public void getProductShouldReturnNullWhenUnregisteredProductRequested(){

        // execute
        Product product = ProductFactory.getProduct(UNREGISTERED);

        // assert
        Assert.assertNull(null);
    }

}
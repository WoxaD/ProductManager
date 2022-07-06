import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.product.Product;

public class ProductManagerTest {

    ProductManager manager = new ProductManager(new ProductRepository());

    Product item1 = new Product(1, "The Cather in the Rye", 1_599);
    Product item2 = new Product(2, "The Lord of the Rings", 2_649);
    Product item3 = new Product(3, "To Kill a Mockingbird", 2_499);
    Product item4 = new Product(3, "The Cather in the Rye", 1_599);

    @Test
    public void shouldAddProducts() {
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);

        Product[] expected = {item1, item2, item3, item4};

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldRemoveProduct() {
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.removeById(item2.getId());

        Product[] expected = {item1, item3, item4};

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldSearchItemIfItIsOnePresent() {
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.searchBy("The Lord of the Rings");

        Product[] expected = {item2};

        assertArrayEquals(expected, manager.searchBy("The Lord of the Rings"));
    }

    @Test
    public void shouldSearchItemIfItIsManyPresent() {
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.searchBy("The Cather in the Rye");

        Product[] expected = {item1, item4};

        assertArrayEquals(expected, manager.searchBy("The Cather in the Rye"));
    }

    @Test
    public void shouldSearchedItemIfItIsNotPresent() {
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.searchBy("Lolita");

        Product[] expected = {};

        assertArrayEquals(expected, manager.searchBy("Lolita"));
    }
}

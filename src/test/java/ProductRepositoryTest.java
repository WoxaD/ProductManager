import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.product.Product;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

    Product item1 = new Product(1, "The Cather in the Rye", 1_599);
    Product item2 = new Product(2, "The Lord of the Rings", 2_649);
    Product item3 = new Product(3, "To Kill a Mockingbird", 2_499);
    Product item4 = new Product(3, "The Cather in the Rye", 1_599);

    @Test
    public void shouldTryToRemoveProductFromArrayIfItemIsPresent() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(1);

        Product[] expected = {item2, item3};

        assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void shouldTryToRemoveProductFromArrayIfItemIsNotPresent() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        assertThrows(NotFoundException.class, () -> repo.removeById(8));
    }
}

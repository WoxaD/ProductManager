import ru.netology.product.Product;

public class ProductManager {
    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void save(Product productForAdd) {
        repository.save(productForAdd);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product [] findAll() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[1];
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                result[0] = product;
                return result;
            } else {
                result[0] = null;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}

package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService(){
        addProduct(new DigitalProduct(2L, "psPlus Subscription", 105.66, "Downaload URL", 6048));
        addProduct(new PhysicalProduct(4L, "Football", 90, 2,"Ball"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct ( Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

}



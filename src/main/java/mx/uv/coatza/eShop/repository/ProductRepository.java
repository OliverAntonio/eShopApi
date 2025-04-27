package mx.uv.coatza.eShop.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import mx.uv.coatza.eShop.model.Product;

@Repository
public class ProductRepository {
    
    private long currentId;
    private List<Product> products;

    public ProductRepository() {
        currentId = 1;
        products = new LinkedList<>();
    }

    public List<Product> getAll() {
        return products;
    }

    public Product save(Product data) {
        data.setId(++currentId);
        products.add(data);
        return data;
    }

    public Optional<Product> getById(long id) {
        Product data = null;

        for (Product product : products) {
            if (product.getId() == id) {
                data = product;
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
    
    public void update(long id, Product data) {
        Optional<Product> entry = getById(id);

        if (!entry.isPresent()) {
            return;
        }

        Product product = entry.get();
        if (data.getName() != null) {
            product.setName(data.getName());
        }
        if (data.getPrice() > 0) {
            product.setPrice(data.getPrice());
        }
        if (data.getQuantity() > 0) {
            product.setQuantity(data.getQuantity());
        }
    }

}

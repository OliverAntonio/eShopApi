package mx.uv.coatza.eShop.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uv.coatza.eShop.dto.CreateProductDTO;
import mx.uv.coatza.eShop.dto.ProductDTO;
import mx.uv.coatza.eShop.model.Product;
import mx.uv.coatza.eShop.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.getAll();

        List<ProductDTO> data = new LinkedList<>();

        for (Product product : products) {
            data.add(toDTO(product));
        }
        return data;
    }

    public ProductDTO save(CreateProductDTO data) {
        Product model = toModel(data);
        return toDTO(productRepository.save(model));
    }

    private Product toModel(CreateProductDTO dto) {
        return new Product(0, dto.getName(), dto.getQuantity(), dto.getPrice());
    }

    private ProductDTO toDTO(Product model) {
        return new ProductDTO(model.getId(), model.getName(), model.getQuantity(), model.getPrice());
    }
}

package mx.uv.coatza.eShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mx.uv.coatza.eShop.dto.CreateProductDTO;
import mx.uv.coatza.eShop.dto.ProductDTO;
import mx.uv.coatza.eShop.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/obtenerProductos")
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @RequestMapping("/crearProducto")
    public ProductDTO save(@Valid @RequestBody CreateProductDTO data) {
        return productService.save(data);
    }
}

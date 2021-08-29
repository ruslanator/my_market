package ru.ruslanator.routinglib.feings;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ruslanator.msproducts.entities.ProductDto;

@FeignClient("ms-product")
public interface ProductClient {
    @GetMapping("/api/v1/{id}")
    ProductDto findProductById(@PathVariable Long id);

    @GetMapping
    ProductDto findAllProducts();
}

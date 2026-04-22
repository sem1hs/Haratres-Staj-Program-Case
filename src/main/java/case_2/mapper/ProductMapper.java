package case_2.mapper;

import case_2.dto.CreateProductRequest;
import case_2.entity.Product;

public class ProductMapper {

    public Product toEntity(CreateProductRequest request) {
        if (request == null) return null;

        return Product.builder()
                .name(request.name())
                .price(request.price())
                .stock(request.stock())
                .rating(request.rating())
                .build();
    }
}

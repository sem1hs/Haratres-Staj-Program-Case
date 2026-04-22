package case_2.mapper;

import case_2.dto.CreateCardItemRequest;
import case_2.entity.CartItem;

public class CartMapper {

    public CartItem toEntity(CreateCardItemRequest request) {
        if (request == null) return null;

        return CartItem.builder()
                .product(request.selectedProduct())
                .quantity(request.quantity())
                .build();
    }
}

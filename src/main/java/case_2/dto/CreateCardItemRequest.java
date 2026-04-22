package case_2.dto;

import case_2.entity.Product;

public record CreateCardItemRequest(
        Product selectedProduct,
        int quantity
) {
}

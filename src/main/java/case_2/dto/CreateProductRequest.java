package case_2.dto;

public record CreateProductRequest(
        String name,
        double price,
        int stock,
        double rating
) {
}

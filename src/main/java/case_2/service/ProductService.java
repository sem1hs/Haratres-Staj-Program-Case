package case_2.service;

import case_2.dto.CreateProductRequest;
import case_2.entity.Product;
import case_2.mapper.ProductMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Product> createProducts(Scanner scn) {
        List<Product> products = new ArrayList<>();

        int count = getCount(scn);

        for (int i = 0; i < count; i++) {
            System.out.println("Urun " + (i + 1) + ":");

            String name = getProductName(scn);
            double price = getPrice(scn);
            int stock = getStock(scn);
            double rating = getRating(scn);

            scn.nextLine();

            CreateProductRequest request = new CreateProductRequest(name, price, stock, rating);
            Product product = productMapper.toEntity(request);
            products.add(product);
        }

        return products;
    }

    private int getCount(Scanner scn) {
        int count;
        while (true) {
            System.out.print("Kac farkli urun gireceksiniz: ");
            count = scn.nextInt();

            if (count >= 2) break;
            else System.out.println("En az 2 urun girilmelidir!");
        }

        scn.nextLine();

        return count;
    }

    private String getProductName(Scanner scn) {
        String name;
        while (true) {
            System.out.print("Urun adi: ");
            name = scn.nextLine();

            if (name.length() > 20 || name.isEmpty()) {
                System.out.println("Max 20 karakter girilmelidir !");
                continue;
            }

            if (!name.matches("[a-zA-Z .,!?'-]+")) {
                System.out.println("Lutfen sadece Latin alfabesi kullaniniz !");
                continue;
            }

            return name;
        }
    }

    private double getPrice(Scanner scn) {
        double price;
        while (true) {
            System.out.print("Fiyat: ");
            price = scn.nextDouble();

            if (price >= 1 && price <= 100) break;
            else System.out.println("Urun fiyati 1-100 arasi olmalidir !");
        }

        return price;
    }

    private int getStock(Scanner scn) {
        int stock;
        while (true) {
            System.out.print("Stok: ");
            stock = scn.nextInt();

            if (stock >= 1) break;
            else System.out.println("Urun stoku En az 1 olmalidir !");
        }

        return stock;
    }

    private double getRating(Scanner scn) {
        double rating;
        while (true) {
            System.out.print("Rating: ");
            rating = scn.nextDouble();

            if (rating >= 0 && rating <= 5) break;
            else System.out.println("Urun ratingi 0-5 arasi olmalidir !");
        }

        return rating;
    }

    public static void printProducts(List<Product> products) {
        System.out.println("\nSistemdeki Urunler:");
        products.forEach(p -> System.out.println(p.getName() + " - Fiyat: " + p.getPrice() + ", Stok: " + p.getStock() + ", Rating: " + p.getRating()));
    }
}

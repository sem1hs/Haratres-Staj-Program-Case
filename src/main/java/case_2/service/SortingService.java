package case_2.service;

import case_2.entity.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortingService {

    public String getSortCriteria(Scanner scn) {
        while (true) {
            System.out.print("Urunleri hangi kritere gore siralamak istersiniz? (name/price/stock/rating): ");
            String input = scn.nextLine().toLowerCase();

            if (input.equals("name") || input.equals("price") || input.equals("stock") || input.equals("rating"))
                return input;
            else System.out.println("Lutfen gecerli bir kriter giriniz ! (name/price/stock/rating)");
        }
    }

    public String getSortOrder(Scanner scn) {
        while (true) {
            System.out.print("Siralama artan mi azalan mi olsun? (artan/azalan): ");
            String input = scn.nextLine().toLowerCase();

            if (input.equals("artan") || input.equals("azalan")) return input;
            else System.out.println("Lutfen gecerli bir secim giriniz ! (artan/azalan)");
        }
    }

    public void sortProducts(List<Product> products, String criteria, String order) {

        Comparator<Product> comparator = switch (criteria) {
            case "name" -> Comparator.comparing(Product::getName);
            case "price" -> Comparator.comparing(Product::getPrice);
            case "stock" -> Comparator.comparing(Product::getStock);
            case "rating" -> Comparator.comparing(Product::getRating);
            default -> throw new IllegalArgumentException("Gecersiz secim !");
        };

        if (order.equals("azalan")) comparator = comparator.reversed();

        products.sort(comparator);

        System.out.println("\nSiralanmis Urunler:");
        products.forEach(p -> System.out.println(p.getName() + " - Fiyat: " + p.getPrice() + ", Stok: " + p.getStock() + ", Rating: " + p.getRating()));
    }
}
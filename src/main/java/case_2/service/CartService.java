package case_2.service;

import case_2.dto.CreateCardItemRequest;
import case_2.entity.Product;
import case_2.entity.CartItem;
import case_2.mapper.CartMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartService {

    private final CartMapper cartMapper;

    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public List<CartItem> createCart(Scanner scn, List<Product> products) {
        List<CartItem> cart = new ArrayList<>();

        while (true) {
            System.out.print("Sepete urun eklemek ister misiniz ? (Evet/Hayir): ");
            String answer = scn.nextLine();

            if (answer.equalsIgnoreCase("Hayir")) break;

            if (!answer.equalsIgnoreCase("Evet")) {
                System.out.println("Gecersiz secim!");
                continue;
            }

            Product selectedProduct = selectProduct(scn, products);
            int quantity = getQuantity(scn, selectedProduct);

            CreateCardItemRequest request = new CreateCardItemRequest(selectedProduct, quantity);
            CartItem cartItem = cartMapper.toEntity(request);
            cart.add(cartItem);

            selectedProduct.setStock(selectedProduct.getStock() - quantity);
            System.out.println(selectedProduct.getName() + " sepete eklendi.");
        }

        if (cart.size() < 2) System.out.println("Sepette en az 2 urun olmalidir!");

        return cart;
    }

    public double calculateTotal(List<CartItem> cart) {
        double total = 0;

        for (int i = 0; i < cart.size(); i++) {
            double unitPrice = getDiscountedUnitPrice(cart, i);
            total += unitPrice * cart.get(i).getQuantity();
        }

        return total;
    }

    private Product selectProduct(Scanner scn, List<Product> products) {
        while (true) {
            ProductService.printProducts(products);
            System.out.print("Eklemek istediginiz urunun adi: ");
            String name = scn.nextLine();

            for (Product p : products) {
                if (p.getName().equalsIgnoreCase(name)) {
                    return p;
                }
            }

            System.out.println("Urun bulunamadi!");
        }
    }

    private int getQuantity(Scanner scn, Product product) {
        int quantity;

        while (true) {
            System.out.print("Eklemek istediginiz adet: ");
            quantity = scn.nextInt();

            if (quantity <= 0) {
                System.out.println("Adet 1 veya daha fazla olmalidir !");
                continue;
            }

            if (quantity > product.getStock()) {
                System.out.println("Yeterli stok yok !");
                continue;
            }

            scn.nextLine();
            return quantity;
        }
    }

    private double getDiscountedUnitPrice(List<CartItem> cart, int index) {

        CartItem current = cart.get(index);
        double unitPrice = current.getProduct().getPrice();

        if (index < cart.size() - 1) {
            CartItem next = cart.get(index + 1);

            if (unitPrice > next.getProduct().getPrice()) {
                unitPrice -= next.getProduct().getPrice();
            }
        }

        return unitPrice;
    }

    public void printCart(List<CartItem> cart) {
        System.out.println("\nSepetiniz:");

        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);

            double originalPrice = item.getProduct().getPrice();
            double discountedPrice = getDiscountedUnitPrice(cart, i);

            double total = discountedPrice * item.getQuantity();

            boolean isDiscounted = originalPrice != discountedPrice;

            System.out.printf("%s - Adet: %d, Birim: %.2f%s, Toplam: %.2f%n", item.getProduct().getName(), item.getQuantity(), discountedPrice, isDiscounted ? " (indirimli)" : "", total);
        }
    }
}
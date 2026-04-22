package case_2;

import case_2.entity.CartItem;
import case_2.entity.Product;
import case_2.mapper.CartMapper;
import case_2.mapper.ProductMapper;
import case_2.service.CartService;
import case_2.service.ProductService;
import case_2.service.SortingService;

import java.util.List;
import java.util.Scanner;

public class Case {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        ProductMapper mapper = new ProductMapper();
        ProductService productService = new ProductService(mapper);
        List<Product> products = productService.createProducts(scn);

        SortingService sortingService = new SortingService();
        String criteria = sortingService.getSortCriteria(scn);
        String order = sortingService.getSortOrder(scn);

        sortingService.sortProducts(products, criteria, order);

        CartMapper cartMapper = new CartMapper();
        CartService cartService = new CartService(cartMapper);

        List<CartItem> cart = cartService.createCart(scn, products);

        cartService.printCart(cart);

        double total = cartService.calculateTotal(cart);

        System.out.println("Sepet Toplami: " + total);
    }
}

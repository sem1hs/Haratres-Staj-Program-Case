package case_2.entity;

import java.util.UUID;

public class Product {

    private UUID id;
    private String name;
    private double price;
    private int stock;
    private double rating;

    public Product(String name, double price, int stock, double rating) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.rating = rating;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private double price;
        private int stock;
        private double rating;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder stock(int stock) {
            this.stock = stock;
            return this;
        }

        public Builder rating(double rating) {
            this.rating = rating;
            return this;
        }

        public Product build() {
            return new Product(name, price, stock, rating);
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public double getRating() {
        return rating;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

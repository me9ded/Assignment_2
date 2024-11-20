package amazon;

import java.util.ArrayList;
import java.util.List;

public class AmazonCustomer {
    private int id;
    private String name;
    private String address;
    private List<String> credits = new ArrayList<>();
    private List<Integer> wishList = new ArrayList<>();
    private List<CartItem> cart = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    private AmazonCustomer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static AmazonCustomer createAmazonCustomer(List<String> data) {
        if (data == null || data.size() < 3) {
            throw new IllegalArgumentException("Invalid data provided");
        }

        int id = Integer.parseInt(data.get(0));
        String name = data.get(1).trim();
        String address = data.get(2).trim();

        return new AmazonCustomer(id, name, address);
    }

    public int getId() {
        return id;
    }

    public void addCredit(String type, float amount) {
        if (amount <= 0 || (!type.equalsIgnoreCase("cash") && !type.equalsIgnoreCase("check") && !type.equalsIgnoreCase("card"))) {
            throw new IllegalArgumentException("Invalid credit type or amount");
        }
        credits.add(type + ": $" + amount);
    }

    public void showCredits() {
        if (credits.isEmpty()) {
            System.out.println("No credits added.");
        } else {
            credits.forEach(System.out::println);
        }
    }

    public void addProductInWishList(int productId) {
        if (!wishList.contains(productId)) {
            wishList.add(productId);
        }
    }

    public void removeProductFromWishList(int productId) {
        wishList.remove(Integer.valueOf(productId));
    }

    public void showWishList() {
        if (wishList.isEmpty()) {
            System.out.println("Wishlist is empty.");
        } else {
            System.out.println("Wishlist: " + wishList);
        }
    }

    public void addItemInCart(int productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        cart.add(new CartItem(productId, quantity));
    }

    public void removeProductFromCart(int productId) {
        cart.removeIf(item -> item.getProductId() == productId);
    }

    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            cart.forEach(System.out::println);
        }
    }

    public void pay(float availableCredit) {
        float total = cart.stream().mapToDouble(item -> item.getQuantity() * 10.0).sum();
        if (availableCredit < total) {
            System.out.println("Insufficient credit. Payment failed.");
        } else {
            System.out.println("Payment successful. Moving products to comments.");
            cart.forEach(item -> comments.add(new Comment(item.getProductId(), "Purchased successfully", 5.0f)));
            cart.clear();
        }
    }

    public void addComment(int productId, String commentText, float rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        comments.add(new Comment(productId, commentText, rating));
    }

    public void showComments() {
        if (comments.isEmpty()) {
            System.out.println("No comments available.");
        } else {
            comments.forEach(System.out::println);
        }
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name + ", Address: " + address;
    }

    private static class CartItem {
        private int productId;
        private int quantity;

        public CartItem(int productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public int getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Quantity: " + quantity;
        }
    }

    private static class Comment {
        private int productId;
        private String text;
        private float rating;

        public Comment(int productId, String text, float rating) {
            this.productId = productId;
            this.text = text;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Comment: " + text + ", Rating: " + rating;
        }
    }
}

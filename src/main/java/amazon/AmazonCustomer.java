package amazon;

import java.util.ArrayList;
import java.util.List;

public class AmazonCustomer {
    private int id;
    private String name;
    private String address;
    private List<String> credits = new ArrayList<>();
    private List<Integer> wishList = new ArrayList<>();
    private List<AmazonComment> comments = new ArrayList<>();
    private List<AmazonCartItem> cart = new ArrayList<>();

    private AmazonCustomer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static AmazonCustomer createAmazonCustomer(String[] data) {
        if (data == null || data.length < 3) {
            throw new IllegalArgumentException("Invalid data provided");
        }

        int id = Integer.parseInt(data[0]);
        String name = data[1].trim();
        String address = data[2].trim();

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

    public void addItemInCart(AmazonCartItem item) {
        if (item.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        cart.add(new AmazonCartItem());
    }

    public void removeProductFromCart(int productId) {

        cart.removeIf(item -> item.getProduct().getId() == productId);
    }

    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            cart.forEach(System.out::println);
        }
    }

    public void pay(float availableCredit) {
        float total = (float) cart.stream().mapToDouble(item -> item.getQuantity() * 10.0).sum();
        if (availableCredit < total) {
            System.out.println("Insufficient credit. Payment failed.");
        } else {
            System.out.println("Payment successful. Moving products to comments.");
            cart.forEach(item -> comments.add(new Comment(item.getProductId(), "Purchased successfully", 5.0f)));
            cart.clear();
        }
    }

    public void addComment(AmazonComment comment) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        comments.add(comment);
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





}

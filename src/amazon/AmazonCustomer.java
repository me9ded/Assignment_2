package amazon;

import java.util.ArrayList;
import java.util.List;

public class AmazonCustomer {
    private int id;
    private String name;
    private String address;
    private List<AmazonComment> comments = new ArrayList<>();
    private List<AmazonProduct> wishlist = new ArrayList<>();
    private List<AmazonCredit> credits = new ArrayList<>();
    private AmazonCart cart;

    // Constructor (private)
    private AmazonCustomer(int id, String name, String address) {
        if (id <= 0 || name == null || name.isEmpty() || address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Invalid customer data");
        }
        this.id = id;
        this.name = name;
        this.address = address;
        this.cart = new AmazonCart(this); // Initialize cart
    }

    public static AmazonCustomer createAmazonCustomer(List<String> data) {
        if (data == null || data.size() < 3) {
            throw new IllegalArgumentException("Invalid data provided");
        }
        int id = Integer.parseInt(data.get(0).trim());
        String name = data.get(1).trim();
        String address = data.get(2).trim();

        return new AmazonCustomer(id, name, address);
    }

    public void addCredit(AmazonCredit credit) {
        if (credit == null) {
            throw new IllegalArgumentException("Invalid credit");
        }
        credits.add(credit);
    }

    public void showCredits() {
        if (credits.isEmpty()) {
            System.out.println("No credits available.");
        } else {
            credits.forEach(System.out::println);
        }
    }

    public void addProductToWishList(AmazonProduct product) {
        if (product != null && !wishlist.contains(product)) {
            wishlist.add(product);
        }
    }

    public void removeProductFromWishList(AmazonProduct product) {
        wishlist.remove(product);
    }

    public void showWishList() {
        if (wishlist.isEmpty()) {
            System.out.println("Wishlist is empty.");
        } else {
            wishlist.forEach(System.out::println);
        }
    }

    public void addItemInCart(AmazonProduct product, int quantity) {
        cart.addItem(new AmazonCartItem(product, quantity));
    }

    public void removeProductFromCart(AmazonProduct product) {
        cart.removeItem(product);
    }

    public void showCart() {
        cart.showCart();
    }

    public void pay(AmazonCredit credit) {
        if (!cart.pay(credit)) {
            System.out.println("Insufficient funds. Payment failed.");
        } else {
            moveFromCartToComments();
        }
    }

    public void moveFromCartToComments() {
        cart.getItems().forEach(item -> {
            comments.add(new AmazonComment(item.getProduct(), "Purchased successfully", 5.0f));
        });
        cart.clear();
    }

    public boolean hasProductToComment(AmazonProduct product) {
        return comments.stream().anyMatch(comment -> comment.getProduct().equals(product));
    }

    public void setComment(AmazonProduct product, String text, float rating) {
        if (!hasProductToComment(product)) {
            throw new IllegalArgumentException("Product not purchased");
        }
        comments.add(new AmazonComment(product, text, rating));
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
        return "AmazonCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

package amazon;
import java.util.ArrayList;
import java.util.List;

public class AmazonCustomer {
    private int id;
    private String name;
    private String address;
    private List<AmazonCredit> credits = new ArrayList<>();
    private List<AmazonProduct> wishList = new ArrayList<>();
    private List<AmazonComment> comments = new ArrayList<>();
    private List<AmazonCartItem> cart = new ArrayList<>();

    private AmazonCustomer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static AmazonCustomer createAmazonCustomer(String[] data){
        for (int i = 0; i < data.length; i++) {
            if(data[i].isBlank()) {
                return null;
            }
        }
        if (data.length !=3) {
            return null;
        }
        Integer id = null;

        try{
            id = Integer.parseInt(data[0]);

        } catch (NumberFormatException e) {
            System.err.println("Invalid id: " + data[0]);
        }
        String name = data[1].trim();
        String address = data[2].trim();
        if(id==null){
            return null;
        }
        return new AmazonCustomer(id, name, address);
    }

    public int getId() {
        return id;
    }


    public void showCredits() {
        if (credits.isEmpty()) {
            System.out.println("No credits added.");
        } else {
            credits.forEach(System.out::println);
        }
    }

    public void addProductInWishList(AmazonProduct product) {
        if (!wishList.contains(product)) {
            wishList.add(product);
        }
    }

    public void removeProductFromWishList(int productId) {
        wishList.removeIf(product -> product.getId() == productId);
    }

    public void showWishList() {
        if (wishList.isEmpty()) {
            System.err.println("Wishlist is empty.");
        } else {
            System.out.println("Wishlist: " + wishList);
        }
    }

    public void addItemInCart(AmazonCartItem item) {
        if (item.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        cart.add(new AmazonCartItem(item.getProduct(), item.getQuantity()));
    }

    public void removeProductFromCart(int productId) {
        cart.removeIf(item -> item.getProduct().getId() == productId);
    }

    public void showCart() {
        if (cart.isEmpty()) {
            System.err.println("Cart is empty.");
        } else {
            cart.forEach(System.out::println);
        }
    }

    public void pay(float availableCredit) {
        float total = (float) cart.stream().mapToDouble(item -> item.getQuantity() * 10.0).sum();
        if (availableCredit < total) {
            System.err.println("Insufficient credit. Payment failed.");
        } else {
            System.out.println("Payment successful. Moving products to comments.");
            cart.clear();
        }
    }

    public void addCredit(AmazonCredit credit) {
        if (credit.getValue() <= 0) {
            throw new IllegalArgumentException("Credit amount must be greater than zero.");
        }

        String paymentType = String.valueOf(credit.getPaymentType());
        if (paymentType == null) {
            throw new IllegalArgumentException("Invalid payment type: " + paymentType);
        }

        credits.add(credit);
        System.out.println("Credit added successfully: " + credit.getValue());
    }

    public void addComment(AmazonComment comment) {
        if (comment.getRating() < 0 || comment.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        if (comment != null) {
            comments.add(comment);
        } else {
            throw new IllegalArgumentException("Comment is null");
        }
    }

    public void showComments() {
        if (comments.isEmpty()) {
            System.err.println("No comments available.");
        } else {
            comments.forEach(System.out::println);
        }
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name + ", Address: " + address;
    }

    public List<AmazonComment> getComments() {
        return comments;
    }
    public List<AmazonCartItem> getCart() {
        return cart;
    }

    public List<AmazonProduct> getWishList() {
        return wishList;
    }

    public int getNumberOfCredits() {
        return credits.size();
    }


    public int getWishlistSize() {
        return wishList.size();
    }

    public int getNumberOfComments() {
        return comments.size();
    }

    public int getCartSize() {
        return cart.size();
    }

    public List<AmazonCredit> getCredits() {
        return credits;
    }

    public void setCredits(List<AmazonCredit> credits) {
        this.credits = credits;
    }
}


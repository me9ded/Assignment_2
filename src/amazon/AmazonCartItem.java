package amazon;

public class AmazonCartItem {
    private AmazonProduct product;
    private int quantity;

    public AmazonCartItem(AmazonProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public AmazonProduct getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "AmazonCartItem{product=" + product + ", quantity=" + quantity + '}';
    }
}

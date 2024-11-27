package amazon;
public class AmazonCartItem {
    private AmazonProduct product;
    private int quantity;

    public AmazonCartItem(AmazonProduct ap, int amount) {
        this.product = ap;
        this.quantity = amount;
    }

    public float calcSubTotal() {
        float subTotal = 0;
        subTotal = product.getDiscountPrice();
        return subTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AmazonProduct getProduct() {
        return product;
    }

    public void setProduct(AmazonProduct product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Product ID: " + product.getId() + ", Quantity: " + quantity;
    }
}

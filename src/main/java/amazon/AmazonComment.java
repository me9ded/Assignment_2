package amazon;
public class AmazonComment {
    private int productId;
    private String text;
    private float rating;

    public AmazonComment(AmazonProduct product) {
        this.productId = product.getId();
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Comment: " + text + ", Rating: " + rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setComment(String text) {
        this.text = text;
    }

    public int getProductId() {
        return productId;
    }

    public String getText() {
        return text;
    }
    public float getRating() {
        return rating;
    }

}
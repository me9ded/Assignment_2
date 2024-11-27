package amazon;

public class AmazonComment {
    private AmazonProduct product;
    private String text;
    private float rating;

    public AmazonComment(AmazonProduct product, String text, float rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        this.product = product;
        this.text = text;
        this.rating = rating;
    }

    public AmazonProduct getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "AmazonComment{product=" + product + ", text='" + text + "', rating=" + rating + '}';
    }
}

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
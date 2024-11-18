package amazon;
public class AmazonComment {
    private String comment;
    private AmazonProduct amazonProduct;
    private float rating;

    public AmazonComment(AmazonProduct amazonProduct){
        this.amazonProduct = amazonProduct;
    }

    @Override
    public String toString() {
        String ret="";
        ret="Description of this item" + comment + " And it's rating is " + rating;
        return ret;
    }
}
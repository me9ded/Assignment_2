package amazon;

public class AmazonProductCategory {
    private String categoryName;

    public AmazonProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategory() {
        return categoryName;
    }

    public void setCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}

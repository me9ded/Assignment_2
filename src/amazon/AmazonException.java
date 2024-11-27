package amazon;

public class AmazonException extends Exception {
    private static final long serialVersionUID = 8450907732051066312L;

    public AmazonException(String errorMessage) {
        super(errorMessage);
        System.err.println("AmazonProductException: " + errorMessage);
    }
}

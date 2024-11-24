package amazon;
public class AmazonCartItem {
    private AmazonProduct product;
    private int quantity;

    public AmazonCartItem(AmazonProduct ap, int b){
        this.product = ap;
        this.quantity = b;
    }
    public float calcSubTotal(){
        float subTotal = 0;
        subTotal=product.getDiscountPrice();
        return subTotal;
    }
    @Override
    public String toString() {
        String ret="";
        ret="The sub total is" + calcSubTotal() ;
        return ret;
    }
}
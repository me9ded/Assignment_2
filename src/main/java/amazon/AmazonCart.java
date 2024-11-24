package amazon;

import java.util.ArrayList;

public class AmazonCart {
    private AmazonCustomer customer;
    private ArrayList<AmazonCartItem> items=new ArrayList<>();
    private float totalValue;

    public AmazonCart(AmazonCustomer amazonCustomer){
        this.customer=amazonCustomer;
    }

    public float calcSubTotal(){
        float total=0;
        for(AmazonCartItem element : items){
            total+=element.calcSubTotal();
        }
        return total;
    }

    public AmazonCartItem getItem(int position){
        if(position < 0 || position >= items.size()){
            return null;
        }
        AmazonCartItem amazonCartItem = items.get(position);
        return amazonCartItem;
    }


}
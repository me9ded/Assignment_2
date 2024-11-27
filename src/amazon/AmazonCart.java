package amazon;

import java.util.ArrayList;
import java.util.List;

public class AmazonCart {
    private AmazonCustomer customer;
    private List<AmazonCartItem> items = new ArrayList<>();
    private float totalValue;

    public AmazonCart(AmazonCustomer customer) {
        this.customer = customer;
    }

    public void addItem(AmazonCartItem item) {
        items.add(item);
        calcSubTotal();
    }

    public void removeItem(AmazonProduct product) {
        items.removeIf(item -> item.getProduct().equals(product));
        calcSubTotal();
    }

    public void calcSubTotal() {
        totalValue = (float) items.stream().mapToDouble(item -> item.getProduct().getActualPrice() * item.getQuantity()).sum();
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            items.forEach(System.out::println);
        }
    }

    public boolean pay(AmazonCredit credit) {
        if (credit.getAmount() >= totalValue) {
            credit.deductAmount(totalValue);
            return true;
        }
        return false;
    }

    public List<AmazonCartItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}

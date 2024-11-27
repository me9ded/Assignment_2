package amazon;

public class AmazonCash extends AmazonCredit {

    public AmazonCash(float amount) {
        super(PaymentType.Cash, amount);
    }

    @Override
    public String toString() {
        return "AmazonCash{amount=" + getAmount() + '}';
    }
}

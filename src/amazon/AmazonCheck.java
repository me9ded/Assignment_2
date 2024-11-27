package amazon;

public class AmazonCheck extends AmazonCredit {
    private String accountNumber;

    public AmazonCheck(String accountNumber, float amount) {
        super(PaymentType.Check, amount);
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "AmazonCheck{accountNumber='" + accountNumber + "', amount=" + getAmount() + '}';
    }
}

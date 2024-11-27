package amazon;

public class AmazonCard extends AmazonCredit {
    private String number;
    private String expiration;

    public AmazonCard(String number, String expiration, float amount) {
        super(PaymentType.Card, amount);
        this.number = number;
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "AmazonCard{" +
                "number='" + number + '\'' +
                ", expiration='" + expiration + '\'' +
                ", amount=" + getAmount() +
                '}';
    }
}

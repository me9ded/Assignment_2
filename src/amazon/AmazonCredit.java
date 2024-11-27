package amazon;

public abstract class AmazonCredit {
    public enum PaymentType { Cash, Check, Card }

    private PaymentType type;
    private float amount;

    public AmazonCredit(PaymentType type, float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.type = type;
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void deductAmount(float value) {
        if (value > amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.amount -= value;
    }

    @Override
    public String toString() {
        return "AmazonCredit{" + "type=" + type + ", amount=" + amount + '}';
    }
}

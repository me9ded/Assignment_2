package amazon;

public abstract class AmazonCredit {
	public enum CreditType {
		CASH, CHECK, CREDIT
	}

	protected CreditType creditType;
	protected float value;

	// Constructor
	public AmazonCredit(CreditType creditType, float value) {
		if (creditType == null || value < 0) {
			throw new IllegalArgumentException("Invalid credit type or value");
		}
		this.creditType = creditType;
		this.value = value;
	}

	// Getter for value
	public float getValue() {
		return value;
	}

	// Deduct value from credit
	public void deduct(float amount) {
		if (amount > value) {
			throw new IllegalArgumentException("Insufficient credit balance");
		}
		value -= amount;
	}

	// Abstract method toString
	@Override
	public abstract String toString();
}

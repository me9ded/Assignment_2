package amazon;
public class AmazonCash extends AmazonCredit {

	// Constructor
	public AmazonCash(float value) {
		super(CreditType.CASH, value);
	}

	// Override toString to display cash information
	@Override
	public String toString() {
		return "Credit Type: CASH, Value: $" + value;
	}
}


package amazon;

public abstract class AmazonCredit{
    public enum PaymentType{
		CASH,CHECK,CARD
	}
	private float value;
	private PaymentType paymentType;

	public AmazonCredit(float value) throws IllegalArgumentException{
		if (value <= 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}
		this.value=value;

	}

	@Override
	public String toString(){
		String ret="Credit Type:" + PaymentType.values()[(int)this.value].toString();
		return ret;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

}
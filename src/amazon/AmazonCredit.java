package amazon;

public abstract class AmazonCredit{
	public enum CreditType{
		Cash,Check,Card
	}
	private float value;
	public AmazonCredit(float value) {
		this.value=value;
	}
	
	@Override
	public String toString(){
		String ret="Credit Type:" + CreditType.values()[(int)this.value].toString();
		return ret;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
}
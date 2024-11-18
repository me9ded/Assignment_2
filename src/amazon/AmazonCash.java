package amazon;
public class AmazonCash extends AmazonCredit{
	private CreditType ct;
	private AmazonCash(float amount) {
		super(amount);
		this.ct=ct;
		
	}

	public AmazonCash createCash(String[] data) {
		if(data.length > 2) {
			return null;
		}
		if(data[1].isBlank()) {
			return null;
		}
		AmazonCash ac=new AmazonCash(Float.parseFloat(data[1]));
		return ac;
	}

	@Override
	public String toString() {
		String ret="Credit : " + ct.Cash + getValue();
		return ret;
	}

}

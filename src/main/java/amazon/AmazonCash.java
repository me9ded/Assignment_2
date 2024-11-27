package amazon;



public class AmazonCash extends AmazonCredit{

	private AmazonCash(float amount) {
		super(amount);

	}

	public static AmazonCash createCash(String[] data) {
		if(data.length < 1) {
			return null;
		}
		for (int i = 0; i < data.length; i++) {
			if(data[i].isBlank()) {
				return null;
			}
		}
		if(data.length==1) {
			AmazonCash ac=new AmazonCash(Float.parseFloat(data[0]));
			return ac;
		}
		AmazonCash ac=new AmazonCash(Float.parseFloat(data[1]));
		return ac;
	}

	@Override
	public String toString() {
		String ret="Credit : " + PaymentType.CASH + getValue();
		return ret;
	}

}
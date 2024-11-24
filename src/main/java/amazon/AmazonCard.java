package amazon;
public class AmazonCard extends AmazonCredit{
	private String Number;
	private String Expiration;
	private CreditType ct;
	private AmazonCard(String n, String e,float value) {
		super(value);
		this.Number=n;
		this.Expiration=e;
	}


	@Override
	public String toString() {
		String ret="Credit Type" + ct.Card ;
		return ret;
	}
}
package amazon;

public class AmazonCard extends AmazonCredit{
	private String Number;
	private String Expiration;

	private AmazonCard(String number, String expiration,float value) {
		super(value);
		this.Number=number;
		this.Expiration=expiration;
	}

	public static AmazonCard createCard(String[] data) {
		return new AmazonCard(data[0],data[1],Float.parseFloat(data[2]));

	}

	@Override
	public String toString() {
		String ret="Card Number " + getNumber() + " Card balance: " +  getValue();
		return ret;
	}

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
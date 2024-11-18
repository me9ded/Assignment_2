package amazon;
public class AmazonCheck extends AmazonCredit{
    private CreditType creditType;
    private String accountNumber;

    private AmazonCheck(String accountNumber, float amount) {
        super(amount);
        this.accountNumber = accountNumber;
    }

    public AmazonCheck createAmazonCheck(String[] data) {
        if(data.){
            return null;
        }
        return new AmazonCheck(accountNumber);
    }

    @Override
    public String toString() {
        String ret="";
        ret="Credit Type" + creditType. + "Account Number" + accountNumber;
        return ret;
    }
}
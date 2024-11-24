package amazon;
public class AmazonCheck extends AmazonCredit{
    private CreditType creditType;
    private String accountNumber;

    private AmazonCheck(String accountNumber, float amount) {
        super(amount);
        this.accountNumber = accountNumber;
    }

    public static AmazonCheck createCheck(String[] data) {
        for(int i=0;i<data.length;i++){
            if(data[i].isBlank()){
                return null;
            }
        }
        if(data.length < 2){
            return null;
        }
        return new AmazonCheck(data[0], Float.parseFloat(data[1]));
    }

    @Override
    public String toString() {
        String ret="";
        ret="Credit Type" + creditType + "Account Number" + accountNumber;
        return ret;
    }
}
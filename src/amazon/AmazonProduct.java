package amazon;
public class AmazonProduct extends AmazonProductUtil{
	private String name;
	private String imageURL;
	private String link;
	private int id;
	private int nRatings;
	private float rating;
	private AmazonProductSubCategory subCategory;
	private AmazonProductCategory category;
	private float actualPrice;
	private float discountPrice;
	private static String[] title;
	


    private AmazonProduct(int id, String name,  AmazonProductCategory category, AmazonProductSubCategory subCategory, String imageURL, String link,
            float rating, int nRatings, float discountPrice, float actualPrice) {
    	this.id = id;
    	this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.imageURL = imageURL;
		this.link = link;
		this.rating = rating;
		this.nRatings = nRatings;
		this.discountPrice=discountPrice;
		this.actualPrice = actualPrice;
    }
    public AmazonProduct createAmazonProduct(String[] data){
    	int a=Integer.parseInt(data[0]);
    	String b=data[1];
    	AmazonProductCategory c=new AmazonProductCategory(data[2]);
    	AmazonProductSubCategory d= new AmazonProductSubCategory(data[3],this.category);
    	String e=data[4];
    	String f=data[5];
    	float g=Float.parseFloat(data[6]);
    	int h=Integer.parseInt(data[7].replace(",",""));
    	float j=convertStrToFloat(data[8].replace(",",""));
    	float k=convertStrToFloat(data[9].replace(",","" ));
    	AmazonProduct temp=new AmazonProduct(a,b,c,d,e,f,g,h,j,k);
    	return temp;
    	
    	
    	
    	
    }
    public static void setTitle(String[] csvTitle) {
        title = csvTitle;
    }

    public static String[] getTitle() {
        return title;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getLink() {
        return link;
    }

    public int getNRatings() {
        return nRatings;
    }

    public float getRating() {
        return rating;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public float getActualPrice() {
        return actualPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setNRatings(int nRatings) {
        this.nRatings = nRatings;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setActualPrice(float actualPrice) {
        this.actualPrice = actualPrice;
    }
    public AmazonProductCategory getMain_category() {
    	return category;
    }
    public AmazonProductSubCategory getSub_category() {
    	return subCategory;
    }
    public String toString() {
        return "AmazonProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Category=" + category.getCategory() +'\''+
                ", SubCtegory="+ subCategory.getSubCategory()+'\''+
                ", imageURL='" + imageURL + '\'' +
                ", link='" + link + '\'' +
                ", nRatings=" + nRatings +
                ", rating=" + rating +
                ", discountPrice=" + discountPrice +
                ", actualPrice=" + actualPrice +
                '}';
    }

}

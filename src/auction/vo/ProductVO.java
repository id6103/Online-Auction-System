package auction.vo;

public class ProductVO {
	private int id;
	private String productName;
	private String productDesc;
	private String startTime;
	private String endTime;
	private String img;
	private String saleName;
	private String buyName;
	private int startPrice;
	private int curPrice;
	private int state;

	
	
	public ProductVO(int id, String productName, String productDesc
			) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDesc = productDesc;

	}



	public ProductVO(int id, String productName, String productDesc,
			String startTime, String endTime, String img, String saleName,
			String buyName, int startPrice, int curPrice, int state) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDesc = productDesc;
		this.startTime = startTime;
		this.endTime = endTime;
		this.img = img;
		this.saleName = saleName;
		this.buyName = buyName;
		this.startPrice = startPrice;
		this.curPrice = curPrice;
		this.state = state;
	}
	
	public ProductVO(int id, String productName, String productDesc,
			String startTime, String endTime, String img, String saleName,
			 int startPrice, int curPrice,int state) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDesc = productDesc;
		this.startTime = startTime;
		this.endTime = endTime;
		this.img = img;
		this.saleName = saleName;
		this.startPrice = startPrice;
		this.curPrice = curPrice;
		this.state=state;
	}

    

	public ProductVO(String productName, String productDesc, String img,
			String saleName, int startPrice) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.img = img;
		this.saleName = saleName;
		this.startPrice = startPrice;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductDesc() {
		return productDesc;
	}



	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}



	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getEndTime() {
		return endTime;
	}



	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getSaleName() {
		return saleName;
	}



	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}






	public int getStartPrice() {
		return startPrice;
	}



	public String getBuyName() {
		return buyName;
	}



	public void setBuyName(String buyName) {
		this.buyName = buyName;
	}



	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}



	public int getCurPrice() {
		return curPrice;
	}



	public void setCurPrice(int curPrice) {
		this.curPrice = curPrice;
	}



	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}


	public ProductVO(int id, String productName, String productDesc, int state) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDesc = productDesc;
		this.state = state;
	}




}
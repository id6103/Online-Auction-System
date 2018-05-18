package auction.vo;

public class RecordVO {
private int id;
private int productId;
private String buyName;
private int price;
private String productName;
private String time;

public RecordVO(int id, int productId,String productName,String buyName, int price) {
	super();
	this.id = id;
	this.productId = productId;
	this.buyName = buyName;
	this.price = price;
	this.productName = productName;

}

public RecordVO(int id, int productId,String buyName, int price,String time) {
	super();
	this.id = id;
	this.productId = productId;
	this.buyName = buyName;
	this.price = price;
	this.time=time;


}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public String getBuyName() {
	return buyName;
}

public void setBuyName(String buyName) {
	this.buyName = buyName;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}


}

package pojo;

public class ShowAnjuke {

	private String name;

	private String address;

	private double area;

	private String houseType;

	private String rentWay;

	private double price;

	private String rowCol;
	
	private String paymentMethod;

	private double score;

	private String url;

	private double distance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType == null ? null : houseType.trim();
	}

	public String getRentWay() {
		return rentWay;
	}

	public void setRentWay(String rentWay) {
		this.rentWay = rentWay == null ? null : rentWay.trim();
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getRowCol() {
		return rowCol;
	}

	public void setRowCol(String rowCol) {
		this.rowCol = rowCol;
	}

}

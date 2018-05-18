package auction.vo;

public class RegisterVO {
	private int id;
	private String username;
	private int pwd;
	private String address;
	private int identification_no;
	private int age;
	private String hobby ;
	public RegisterVO(String username, int pwd, String address, int identification_no, int age, String hobby) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.address = address;
		this.identification_no = identification_no;
		this.age = age;
		this.hobby = hobby;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getIdentification_no() {
		return identification_no;
	}
	public void setIdentification_no(int identification_no) {
		this.identification_no = identification_no;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
package auction.vo;

public class LoginUserVO {
	private String usr;
	private String pwd;
	
	public LoginUserVO(String usr, String pwd) {
		super();
		this.usr = usr;
		this.pwd = pwd;
	}
	public String getUsr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
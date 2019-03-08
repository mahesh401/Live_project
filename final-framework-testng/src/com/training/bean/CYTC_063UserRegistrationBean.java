package com.training.bean;

public class CYTC_063UserRegistrationBean {
	private String loginname;
	private String fullname;
	private String email;
	private String birthday;
	private String address;
	private String postcode;
	private String city;
	private String phone;
	private String mobile;
	private String fax;
	private String url;
	private String password;
	private String confirmpassword;
	private String comments;

	public CYTC_063UserRegistrationBean() {
	}

	public CYTC_063UserRegistrationBean(String loginname, String fullname, String email, String birthday,String address, String postcode,
			String city, String phone, String mobile, String fax, String url, String password, String confirmpassword) {
		super();
		this.loginname = loginname;
		this.fullname = fullname;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
		this.phone = phone;
		this.mobile = mobile;
		this.fax = fax;
		this.url = url;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.comments = comments;
	}

	public String getloginname() {
		return loginname;
	}

	public void setloginname(String loginname) {
		this.loginname = loginname;
	}

	public String getfullname() {
		return fullname;
	}

	public void setfullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	public String getbirthday() {
		return birthday;
	}

	public void setbirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}
	public String getpostcode() {
		return postcode;
	}

	public void setpostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getcity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}
	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}
	public String getmobile() {
		return mobile;
	}

	public void setmobile(String mobile) {
		this.mobile = mobile;
	}
	public String getfax() {
		return fax;
	}

	public void setfax(String fax) {
		this.fax = fax;
	}
	public String geturl() {
		return url;
	}

	public void seturl(String url) {
		this.url = url;
	}
	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getconfirmpassword() {
		return confirmpassword;
	}

	public void setconfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	public String getcomments() {
		return comments;
	}

	public void setcomments(String comments) {
		this.comments = comments;
	}

/*	@Override
	public String toString() {
		return "CYTC_063UserRegistrationBean [loginname="+loginname+", fullname= "+fullname+", email= "+email+", birthday="+birthday+", address="+address+", "
				+ "postcode= "+postcode+", city="+city+", phone="+phone+", mobile="+mobile+", fax="+fax+", url="+url+", password="+password+", confirmpassword="+confirmpassword+", comments="+comments"]";
	}
*/
}

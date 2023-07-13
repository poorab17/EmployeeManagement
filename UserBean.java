package com.sts.um.bean;

public class UserBean {
	
	private int id;
	private String name;
	private String password;
	private String email;
	private String mobile;
	private String education;
	private String age;
	private String gender;
	private String hobby;
	private String detail;
	private String comment;
	private String file;
	

	
	

public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

public UserBean() {
		super();
	}

public UserBean(int id, String comment) {
		super();
		this.id = id;
		this.comment = comment;
	}



public UserBean(int id, String name, String password, String email, String mobile, String education, String age,
		String gender, String hobby, String detail, String comment, String file) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.email = email;
	this.mobile = mobile;
	this.education = education;
	this.age = age;
	this.gender = gender;
	this.hobby = hobby;
	this.detail = detail;
	this.comment = comment;
	this.file = file;
}

public UserBean(int id, String name, String password, String email, String mobile, String education, String age,
			String gender, String hobby, String detail, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.education = education;
		this.age = age;
		this.gender = gender;
		this.hobby = hobby;
		this.detail = detail;
		this.comment = comment;
	}



public UserBean(String name, String password, String email, String mobile, String education, String age, String gender,
		String hobby, String detail, String comment, String file) {
	super();
	this.name = name;
	this.password = password;
	this.email = email;
	this.mobile = mobile;
	this.education = education;
	this.age = age;
	this.gender = gender;
	this.hobby = hobby;
	this.detail = detail;
	this.comment = comment;
	this.file = file;
}

public UserBean(String name, String password, String email, String mobile, String education, String age,
			String gender, String hobby, String detail, String comment) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.education = education;
		this.age = age;
		this.gender = gender;
		this.hobby = hobby;
		this.detail = detail;
		this.comment = comment;
	}

public UserBean(int id, String name, String email, String mobile, String age, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
		this.comment = comment;
	}

public UserBean(String name, String email, String mobile, String age, String comment) {
	super();
	this.name = name;
	this.email = email;
	this.mobile = mobile;
	this.age = age;
	this.comment = comment;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getEducation() {
	return education;
}

public void setEducation(String education) {
	this.education = education;
}

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getHobby() {
	return hobby;
}

public void setHobby(String hobby) {
	this.hobby = hobby;
}

public String getDetail() {
	return detail;
}

public void setDetail(String detail) {
	this.detail = detail;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}


	

}

package com.uttara.contact.amogh;

public class ContactBean {
private String name;
private String emailid;
private String phonenums;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getPhonenums() {
	return phonenums;
}
public void setPhonenums(String phonenums) {
	this.phonenums = phonenums;
}
public ContactBean(String name, String emailid, String phonenums) {
	super();
	this.name = name;
	this.emailid = emailid;
	this.phonenums = phonenums;
}
public ContactBean() {
	super();
}
@Override
public int hashCode() {
	return name.hashCode()+emailid.hashCode()+phonenums.hashCode();
}
@Override
public boolean equals(Object obj) {
	if(obj instanceof ContactBean)
	{
		ContactBean cb=(ContactBean)obj;
		if(cb.hashCode()==this.hashCode())
			return true;
		else
			return false;
	}
	else
		throw new IllegalArgumentException("Please pass only ContactBean object");
}
@Override
public String toString() {
	return "[name=" + name + ", emailid=" + emailid + ", phonenums=" + phonenums + "]";
}

}

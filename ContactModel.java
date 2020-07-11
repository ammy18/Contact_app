package com.uttara.contact.amogh;

import java.util.ArrayList;
import java.util.List;

public class ContactModel {
public void addContact(ContactBean cb,int id)
{
	ContactDAO cd=ContactDAOFactory.getInstance(id);
	cd.addContact(cb);
}
public List<ContactBean> list(int id)
{
	List<ContactBean> li=new ArrayList<ContactBean>();
	ContactDAO cd=ContactDAOFactory.getInstance(id);
	li=cd.listContact();
	return li;
}
}

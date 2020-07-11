package com.uttara.contact.amogh;

public class ContactDAOFactory {
public static ContactDAO getInstance(int id)
{
	switch(id)
	{
	case 1:return new ContactFSDAO();
	case 2:return new ContactHSQLDAO();
	default:throw new IllegalArgumentException("only these options available as of now");
	}
}
}

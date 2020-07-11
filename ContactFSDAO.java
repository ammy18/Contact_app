package com.uttara.contact.amogh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactFSDAO implements ContactDAO {

	String name,emailid,phonenums;
	@Override
	public void addContact(ContactBean bean) {
		// TODO Auto-generated method stub
		BufferedWriter bw=null;
		try
		{
			bw=new BufferedWriter(new FileWriter("contacts.txt",true));
			name=bean.getName();
			emailid=bean.getEmailid();
			phonenums=bean.getPhonenums();
			bw.write(name+":"+emailid+":"+phonenums);
			bw.newLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Override
	public List<ContactBean> listContact() {
		// TODO Auto-generated method stub
		List<ContactBean> li=new ArrayList<ContactBean>();
		String line;
		BufferedReader br=null;
		try
		{
			br=new BufferedReader(new FileReader("contacts.txt"));
			ContactBean bean=new ContactBean();
			while((line=br.readLine())!=null)
			{
				String[] str=line.split(":");
				name=str[0];
				bean.setName(name);
				emailid=str[1];
				bean.setEmailid(emailid);
				phonenums=str[2];
				bean.setPhonenums(phonenums);
				li.add(bean);
			}
			return li;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}

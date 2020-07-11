package com.uttara.contact.amogh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc1=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        //int id=1;
        int ch=0,id=Integer.parseInt(args[0]);
        ContactModel cm=new ContactModel();
        String name,emailid,phonenums;
        while(ch!=3)
        {
        	System.out.println("Press 1 to enter contact names");
        	System.out.println("Press 2 to list the contact names");
        	System.out.println("Press 3 to exit");
        	while(!sc2.hasNextInt())
        	{
        		System.out.println("Please enter an integer no");
        		sc2.next();
        	}
        	ch=sc2.nextInt();
        	switch(ch)
        	{
        	case 1:System.out.println("Enter contact name");
        	       name=sc1.nextLine();
        	       System.out.println("Enter contact emailid");
        	       emailid=sc1.nextLine();
        	       System.out.println("Enter contact phoneNums(coma separated)");
        	       phonenums=sc1.nextLine();
        	       ContactBean contact=new ContactBean(name,emailid,phonenums);
        	       cm.addContact(contact, id);
        		break;
        	case 2:List<ContactBean> li=new ArrayList<ContactBean>();
        	       li=cm.list(id);
        	       System.out.println(li);
        		break;
        	case 3:System.out.println("nice meeting you bye-bye");
        	       break;
            default:System.out.println("There are only two choices yet");
                    break;
        	}
        }
        sc1.close();
        sc2.close();
	}

}

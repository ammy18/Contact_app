package com.uttara.contact.amogh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactHSQLDAO implements ContactDAO {

	@Override
	public void addContact(ContactBean bean) {
		// TODO Auto-generated method stub
		PreparedStatement ps_ins=null;
			try {
				//Connection con=JDBCHelper.getConnection();
				ps_ins=JDBCHelper.getStatement("insert into contact(name,emailid,phonenums) values(?,?,?)");
				ps_ins.setString(1, bean.getName());
				ps_ins.setString(2, bean.getEmailid());
				ps_ins.setString(3, bean.getPhonenums());
				ps_ins.execute();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				JDBCHelper.closePreparedStatement(ps_ins);
			}
	}

	@Override
	public List<ContactBean> listContact() {
		// TODO Auto-generated method stub
		List<ContactBean> li=new ArrayList<ContactBean>();
		PreparedStatement ps_sel=null;
		ResultSet rs=null;
		ContactBean bean;
		try {
			
			ps_sel=JDBCHelper.getStatement("select * from contact");//"select * from contact where name=%?%"
			rs=ps_sel.executeQuery();
			int i=0;
			while(rs.next())
			{ 
				bean=new ContactBean();
				bean.setName(rs.getString("name"));
				System.out.println(rs.getInt("slno"));
				bean.setEmailid(rs.getString("emailid"));
				bean.setPhonenums(rs.getString("phonenums"));
				li.add(bean);
			}
			return li;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally
		{
			JDBCHelper.closePreparedStatement(ps_sel);
			JDBCHelper.closeResultSet(rs);
		}
	}

}

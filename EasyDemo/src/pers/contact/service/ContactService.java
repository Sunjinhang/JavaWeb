package pers.contact.service;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import pers.contact.entity.Contact;
 
import pers.contact.dao.BaseDao;;
 
public class ContactService extends BaseDao {
 
	ResultSet rs = null;
	
	public List<Contact> GetAllContact(){
 
		List<Contact> list = new ArrayList();
		String sql = "select * from contact";
		rs = executeQuery(sql);
		try {
			while (rs.next()) {
				Contact f = new Contact(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getString(4), rs.getDate(5),
						rs.getString(6));
				list.add(f);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}
	
	public int AddContact(Contact contact)
	{
		int num = 0;
		String sql = "insert into contact(name,age,phone,date,favorite) values(?,?,?,?,?)";
		try {
			num = executeUpdate(sql, contact.getName(), contact.getAge(), contact.getPhone(),
					contact.getDate(), contact.getFavorite());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int DeleteContact(int id)
	{
		int num = 0;
		String sql = "delete from contact where id = ?";
		try {
			num = executeUpdate(sql, id);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return num;
	}
	
	public Contact GetContact(int id) {
		
		String sql = "select * from contact where id = ?";
		Contact contact = null;
		rs = executeQuery(sql, id);
		try {
			while(rs.next()) {
				contact = new Contact(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDate(5),rs.getString(6));
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return contact;	
	}
	
	public int UpdateContact(Contact contact) {
		int num = 0;
		String sql = "update contact set name = ?,age = ?,phone = ?,date = ?,favorite = ? where id = ?";
		try {
			num = executeUpdate(sql, contact.getName(),contact.getAge(),contact.getPhone(),contact.getDate(),contact.getFavorite(),contact.getId());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return num;
	}
}
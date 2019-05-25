package pers.contact.entity;
 
import java.util.Date;
 
public class Contact {
 
	public Contact(int id, String name, int age, String phone, Date date, String favorite) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.date = date;
		this.favorite = favorite;
	}
		
	private int id;
	private String name;
	private int age;
	private String phone;
	private Date date;
	private String favorite;
	
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	
	
}
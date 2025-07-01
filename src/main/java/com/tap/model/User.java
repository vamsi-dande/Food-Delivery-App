package com.tap.model;

import com.tap.daoimpl.UserDAOImpl;

public class User {

	private int userId;
	private String userName;
	private String password;
	private String email;
	private String address;
	private String role;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public User(int userId, String userName, String password, String email, String address, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
	}
	public User(String userName, String password, String email, String address, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
	}
	public User(String userName, String password, String email, String address) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", role=" + role + "]";
	}
	
	public static void main(String[] args) {
		
		User user = new User("vamsi","123456","vamsi@gmail.com","BTM,Bengaluru","Customer");
		UserDAOImpl udao = new UserDAOImpl();
//		int x = udao.insertUser(user);
//		System.out.println(x);
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the user id");
//		int id = scan.nextInt();
		//User u = udao.getSpecificUser(id);
//		for(User u : list) {
//			System.out.println(u);
//		}
//		System.out.println(u);
//		System.out.println("Enter the new address");
//		scan.nextLine();
//		String address = scan.nextLine();
		//System.out.println(udao.updateUser(id, address));
		System.out.println(udao.deleteUser(10));
		
		//scan.close();
	}
	
}

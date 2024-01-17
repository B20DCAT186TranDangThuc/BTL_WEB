package bean;

import java.util.Date;

public class Employee {
	private int id;
	private String nameuser;
	private String username;
	private String email;
	private String address;
	private String password;
	private Date dob;
	private String phone;
	private long salary;
	private int position;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameuser() {
		return nameuser;
	}

	public void setNameuser(String nameuser) {
		this.nameuser = nameuser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public int getPosition() {
		return position;
	}
	
	public String getStringPosition() {
		if (this.position == 1)
			return "Quản Trị Viên";
		if (this.position == 2)
			return "Nhân viên kho";
		if (this.position == 3)
			return "Nhân viên bán hàng";
		return null;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nameuser=" + nameuser + ", username=" + username + ", email=" + email
				+ ", address=" + address + ", dob=" + dob + ", phone=" + phone + ", salary=" + salary + ", position="
				+ position + "]";
	}

}

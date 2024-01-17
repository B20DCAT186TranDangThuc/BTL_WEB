package bean;


import java.util.Arrays;
import java.util.Date;

public class Member {
	private int id, id_user;
	private String nameuser;
	private int role;
	private String email;
	private String address;
	private Date dob;
	private String phone;
	private long salary;
	private String gender;
	private Permission[] permission;

	
	
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public Permission[] getPermission() {
		return permission;
	}

	public void setPermission(Permission[] permission) {
		this.permission = permission;
	}

	public int getId() {
		return id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
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

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", nameuser=" + nameuser + ", role=" + role + ", email=" + email + ", address="
				+ address + ", dob=" + dob + ", phone=" + phone + ", salary=" + salary + ", gender=" + gender
				+ ", permission=" + Arrays.toString(permission) + ", getPermission()="
				+ Arrays.toString(getPermission()) + ", getId()=" + getId() + ", getGender()=" + getGender()
				+ ", getNameuser()=" + getNameuser() + ", getRole()=" + getRole() + ", getEmail()=" + getEmail()
				+ ", getAddress()=" + getAddress() + ", getDob()=" + getDob() + ", getPhone()=" + getPhone()
				+ ", getSalary()=" + getSalary() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}



}

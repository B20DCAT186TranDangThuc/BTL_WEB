package bean;

import java.sql.Date;

public class Order {
	private int id_order;
	private String name_customer;
	private String address;
	private long price;
	private boolean status;
	private String phone;
	private Date time;

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public String getName_customer() {
		return name_customer;
	}

	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Order [id_order=" + id_order + ", name_customer=" + name_customer + ", address=" + address + ", price="
				+ price + ", status=" + status + ", phone=" + phone + ", time=" + time + "]";
	}

}

package bean;

public class Permission {
	private int id;
	private String nameAction;
	private String link;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameAction() {
		return nameAction;
	}

	public void setNameAction(String nameAction) {
		this.nameAction = nameAction;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", nameAction=" + nameAction + ", link=" + link + "]";
	}

}

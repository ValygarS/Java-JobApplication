
public class Guest extends Person implements IContact {
	
	protected String company;
	protected String contact;
	protected String email;
	protected String mobile;
	
	public Guest(String firstname, String lastname, String company, String contact, String email, String mobile) {
		super(firstname, lastname);
		this.company = company;
		this.contact = contact;
		this.email = email;
		this.mobile = mobile;
	}
	
	public String getCompany() {
		return company;
	}

	public String getContact() {
		return contact;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String toString() {
		return super.toString() + " Mobile: " + this.mobile;
	}
}

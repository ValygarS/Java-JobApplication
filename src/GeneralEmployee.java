

public class GeneralEmployee extends Person implements IContact{

	protected String dob;
	protected Double salary;
	protected String jobTitle;
	protected String email;
	protected String mobile;
	
	public GeneralEmployee(String firstname, String lastname, String dob, Double salary, String jobTitle,
			String email, String mobile) {
		super(firstname, lastname);
		this.dob = dob;
		this.salary = salary;
		this.jobTitle = jobTitle;
		this.email = email;
		this.mobile = mobile;
	}
	
	public String getDob() {
		return dob;
	}

	public Double getSalary() {
		return salary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	@Override
	public String toString() {
		return super.toString() + " Mobile: " + this.mobile;
	}
	
	
	

}

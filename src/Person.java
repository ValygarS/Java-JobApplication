/* Super class for other classes. Has only firstname and lastname as other fields are specific
   and not every person can have email and phone  */
public abstract class Person implements IPerson {
	
	protected String firstname;
	protected String lastname;
	
	
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	} 
	

	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}


	@Override
	public String toString(){
		return "Firstname: " + this.firstname + " Lastname: " + this.lastname;
	} 

}

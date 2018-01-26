import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class TestProgram {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		//creating test objects
		Contractor c1 = new Contractor("John", "Smith", "2000-05-12", "Blizzard", "Maik Morhaim", 
				"jsmith@blizzard.com", "+353852554178");
		
		GeneralEmployee gempl1 = new GeneralEmployee("Mick", "Jansen", "1943-07-26", 260000.00, "GM",
				"mick.jansen@gmail.com", "+353871574567");
		
		Guest g1 = new Guest("Sergey", "Dolya", "Photo Pro", "Mikhail Tun",
				"dolya@gmail.com", "+79031567623");
		
		// adding to array
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(c1);
		persons.add(gempl1);
		persons.add(g1);
		
		// writing to file in CSV format, can change *.txt to *.csv
		try {
			FileWriter writer = new FileWriter("employees.txt", true);
			
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			for (Person p: persons){
				bufferedWriter.write(CsvWriter.writeToCsv(p));
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// writing to SQLite DB (tables already created: separate table for each class)
		SqlWriter sqlWriter = new SqlWriter();
		for (Person p: persons){
			sqlWriter.writeToSQL(p);
		}
		
		//printing requested field values to screen
		for (Person p: persons){
			System.out.println(p.toString());
			
		}
		// creating Array for contacting attendees
		ArrayList<IContact> employees = new ArrayList<>();
		employees.add(c1);
		employees.add(gempl1);
		employees.add(g1);
		for (IContact emp: employees){
			SmsService sms = new SmsService();
			sms.sendMessage("0863578623", emp.getMobile(), "Thank you for attending our event!");
		
			
			EmailService email = new EmailService();
			email.sendMessage("ourcompany@gmail.com", emp.getEmail(), "Thank you for attending the event!");
			
		}
		
		
	}

}

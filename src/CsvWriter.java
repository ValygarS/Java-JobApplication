
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class CsvWriter{
	
	
	
	public static String writeToCsv(Person p){
		
		String values = "";
		Field field = null;
		/* making fixed-size ArrayList with CSV file headers. It will be used to check if class object
		 * has such field. If so get field value and add to String values, if not, add null to values. 
		 */
		List<String> fieldNames = Arrays.asList("dob", "salary", "company", "jobTitle", "contact", "email", "mobile");
		
		// first, adding to values Type of employee (received from class name) and first/last name of Super class
		values += p.getClass().getName().toLowerCase() + "," + p.getFirstname() + "," + p.getLastname();
		
		for (String value : fieldNames){
			values += ",";
			try {
				field = p.getClass().getDeclaredField(value);
			// if no such field exists, adding null
			}catch(NoSuchFieldException e){
				values += "null";
				continue;
			}
			try {
				values += field.get(p).toString();
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return values;
		
		
		
	}
}
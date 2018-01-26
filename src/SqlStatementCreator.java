import java.lang.reflect.Field;

/* Separate class for creating valid format SQL query from class (object) fields to add
   values to EXISTING table*/
public class SqlStatementCreator {
	
	private Person pObj = null;
	
	public SqlStatementCreator(Person personObj){
		this.pObj = personObj;
	}
	
	
	public String generateSqlString(){
		//creating empty strings, where names and values for SQL statements would be added
		String names = "";
		String values = "";
		
		/* check if class has super class, because .getDeclaredFields method doesn't include inherited fields
		create Field, then iterate through it's objects to get names of fields and their values
		in order to put that into SQL query */
		if (pObj.getClass().getSuperclass() != null){
			Field[] fieldsSuper = pObj.getClass().getSuperclass().getDeclaredFields();
			for (int i = 0; i < fieldsSuper.length; i++)
			{
				try{
					String name = fieldsSuper[i].getName();
					String value = fieldsSuper[i].get(pObj).toString();
					
					if (fieldsSuper[i].get(pObj) instanceof String){
						values += "'"+value+"',";
						}
					else{
						values += value + ",";
					}
					names += name + ",";
				}catch(IllegalAccessException e){
					System.out.println(e.getMessage());
				}
			}
		}
		
		// now doing exactly the same for our class
		Field[] fields = pObj.getClass().getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++){
			try{
				String name = fields[i].getName();
				String value = fields[i].get(pObj).toString();
				
				// skipping adding comma before the first element
				if(i!=0){
					names += ",";
					values += ",";
				}
				if(fields[i].get(pObj) instanceof String){
					values += "'"+value+"'";
				}
				else{
					values += value;
				}
				names += name; 
			}catch (IllegalAccessException e){
				System.out.println(e.getMessage());
			}
		}
		// returns string of correct SQL format
		 return "INSERT INTO "+pObj.getClass().getSimpleName().toLowerCase()+"("+names+") VALUES ("+values+");";
			
	}
		
}



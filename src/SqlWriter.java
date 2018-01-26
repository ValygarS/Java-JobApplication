import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlWriter {
	
	Connection c = null;
	Statement stmt = null;
	
	public void writeToSQL(Person p){
		
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:employees.sqlite");
			System.out.println("Connected!");
			
			stmt = c.createStatement();
			
			SqlStatementCreator sq1 = new SqlStatementCreator(p);
			
			String insertQuery = sq1.generateSqlString();
			stmt.executeUpdate(insertQuery);
			c.close();
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}

}

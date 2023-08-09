package procedure;
import java.util.*;
import java.sql.*;
public class RetrievingDataFromDbUsingProcedure {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","wahidur");
			Scanner sc=new Scanner(System.in);
			CallableStatement cs=con.prepareCall("{Call EmpRetrieve51(?,?,?,?,?,?,?)}");
			System.out.println("Enter id:");
			String id=sc.nextLine();
			cs.setString(1, id);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.BIGINT);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.registerOutParameter(7, Types.FLOAT);
			cs.execute();
			System.out.println("\t******EmpDetails*******");
			System.out.println("Emp id : "+id);
			System.out.println("Emp Name : "+cs.getString(2));
			System.out.println("Emp designation : "+cs.getString(3));
			System.out.println("Emp maiId : "+cs.getString(4));
			System.out.println("Emp phone : "+cs.getLong(5));
			System.out.println("Emp  basicSal : "+cs.getInt(6));
			System.out.println("Emp TotSal : "+cs.getFloat(7));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

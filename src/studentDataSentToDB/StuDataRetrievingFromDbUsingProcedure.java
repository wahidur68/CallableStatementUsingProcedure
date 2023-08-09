package studentDataSentToDB;
import java.util.*;
import java.sql.*;

public class StuDataRetrievingFromDbUsingProcedure {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","wahidur");
			Scanner sc=new Scanner(System.in);
			
			CallableStatement cs=con.prepareCall("{call stuRetrieve51(?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("Enter ROLL NO");
			String roll=sc.nextLine();
			cs.setString(1, roll);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.BIGINT);
			cs.registerOutParameter(10, Types.INTEGER);
			cs.registerOutParameter(11, Types.FLOAT);
			cs.registerOutParameter(12, Types.VARCHAR);			
			
		cs.executeQuery();
			
			System.out.println("\t****Student Record");
			System.out.println("Student rollNo :  "+roll);
			System.out.println("Student Name :  "+cs.getString(2));
			System.out.println("Student Branch :  "+cs.getString(3));
			System.out.println("Student hone no :  "+cs.getString(4));
			System.out.println("Student city :  "+cs.getString(5));
			System.out.println("Student state :  "+cs.getString(6));
			System.out.println("Student pin no :  "+cs.getInt(7));
			System.out.println("Student mail id :  "+cs.getString(8));
			System.out.println("Student phone number :  "+cs.getLong(9));
			System.out.println("Student total marks :  "+cs.getInt(10));
			System.out.println("Student persentage :  "+cs.getFloat(11));
			System.out.println("Student grade :  "+cs.getString(12));
			sc.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}

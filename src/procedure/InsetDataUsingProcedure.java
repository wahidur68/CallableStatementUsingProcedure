package procedure;
import java.sql.*;
import java.util.*;

public class InsetDataUsingProcedure {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","wahidur");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter EmpId");
			String empId=sc.nextLine();
			System.out.println("Enter EmpName");
			String empName=sc.nextLine();
			System.out.println("Enter EmpDesignation");
			String empDesg=sc.nextLine();
			System.out.println("Enter EmpMailId");
			String empMailId=sc.nextLine();
			System.out.println("Enter EmpPhno");
			long empPhno=Long.parseLong(sc.nextLine());
			System.out.println("Enter EmpBasicSal");
			int empSal=Integer.parseInt(sc.nextLine());
			
			float totSal = empSal+(0.93F* empSal)+(0.63F* empSal);
			
			CallableStatement cs=con.prepareCall("Call EmpDetails51(?,?,?,?,?,?,?)");
			cs.setString(1, empId);
			cs.setString(2,empName);
			cs.setString(3,empDesg);
			cs.setString(4,empMailId);
			cs.setLong(5,empPhno);
			cs.setInt(6, empSal);
			cs.setFloat(7, totSal);
			cs.execute();//procedure execute and return type is boolean
			System.out.println("Emp data inserted successufully");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}

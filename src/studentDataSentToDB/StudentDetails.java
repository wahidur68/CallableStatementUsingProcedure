package studentDataSentToDB;
import java.util.*;
import java.sql.*;
public class StudentDetails {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","wahidur");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Student Roll No");
			String rno=sc.nextLine();
			
			System.out.println("Enter Student Name");
			String sname=sc.nextLine();
			System.out.println("Enter Student Branch");
			String branch=sc.nextLine();
			System.out.println("Enter Student home no");
			String homeno=sc.nextLine();
//			System.out.println("Enter Student Street name");
//			String street=sc.nextLine();
			
			System.out.println("Enter Student City Name");
			String city=sc.nextLine();
			System.out.println("Enter Student State Name");
			String state=sc.nextLine();
			
			System.out.println("Enter pinCode");
			int pin=Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter Student mail Id");
			String mail=sc.nextLine();
			
			System.out.println("Enter Student phno");
			long ph=Long.parseLong(sc.nextLine());
			
			System.out.println("Enter Student total marks obtain marks(600)");
			int tot=Integer.parseInt(sc.nextLine());
			float per=(float)tot/6;
			CallableStatement cs=con.prepareCall("{call stuDetails51(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, rno);
			cs.setString(2, sname);
			cs.setString(3, branch);
			cs.setString(4, homeno);
			cs.setString(5, city);
			cs.setString(6, state);
			cs.setInt(7, pin);
			cs.setString(8, mail);
			cs.setLong(9, ph);
			cs.setInt(10, tot);
			cs.setFloat(11, per);
			if(per>80)
			{
				cs.setString(12, "AA");
			}else if(per>=70 && per<80)
			{
				cs.setString(12, "BB");
			}else if(per>=50 && per<45) {
				cs.setString(12, "CC");
			}else {
				cs.setString(12, "F");
			}
			cs.execute();
			System.out.println("student data recorded successfully");
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}

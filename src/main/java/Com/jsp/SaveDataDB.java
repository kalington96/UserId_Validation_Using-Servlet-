package Com.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/JDbc")
public class SaveDataDB extends HttpServlet {
	@Override
	public void service(ServletRequest req,ServletResponse resp) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String Email=req.getParameter("Email");
		String MobileNo=req.getParameter("Mobile_No");
		String UserName=req.getParameter("Use Name");
		String Password=req.getParameter("Password");
		String ConformPassword=req.getParameter("ConformPassword");
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","Kalington@95");
			PreparedStatement cpr=con.prepareStatement("Insert into Information(Id,Name,Age,Email,Mobile_No,Use_Name,Password,Date_Time)values(?,?,?,?,?,?,?,?)");
			cpr.setString(1,id);
			cpr.setString(2,name);
			cpr.setInt(3,Integer.parseInt(age));
			cpr.setString(4,Email);
			cpr.setString(5,MobileNo);
			cpr.setString(6,UserName);
			cpr.setString(7,Password);
			cpr.setString(8,formattedDate);
			cpr.execute();
			RequestDispatcher b9=req.getRequestDispatcher("login.html");
			b9.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

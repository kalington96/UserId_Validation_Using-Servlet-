package Com.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/Login")
public class Login extends  HttpServlet {
	@Override
	public void service(ServletRequest req,ServletResponse resp) throws ServletException, IOException
	{
		String Email=req.getParameter("Email");
		String Mobile=req.getParameter("Mobile");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con=null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","Kalington@95");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement cpr=con.prepareStatement("select * from Information where Email=? and Mobile_No=? ");
			cpr.setString(1,Email);
			cpr.setString(2, Mobile);
			ResultSet vm=cpr.executeQuery();
			if(vm.next())
			{
				RequestDispatcher b3=req.getRequestDispatcher("index.jsp");
				b3.forward(req, resp);
			}
			else 
			{
				PrintWriter bn=resp.getWriter();
				bn.print("<h1>Enter Vailid Email and Mobile no</h1>");
				RequestDispatcher b2=req.getRequestDispatcher("login.html");
				b2.include(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
			
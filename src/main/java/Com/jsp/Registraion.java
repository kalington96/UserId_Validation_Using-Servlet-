package Com.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/Url")
public class Registraion extends HttpServlet {
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
		if(Password.equals(ConformPassword))
		{
			
			class A
			 {
				 public void m1() throws SQLException, IOException, ServletException
				 {
					Pattern pattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*@[a-zA-Z]+[.]com");
					Pattern pattern1 = Pattern.compile("[6-9][0-9]{9}"); 
					Matcher m = pattern.matcher(Email);
					Matcher m2 = pattern1.matcher(MobileNo);
					 if(m.matches() && m2.matches())
					 {
						 RequestDispatcher b4=req.getRequestDispatcher("JDbc");
						 b4.forward(req, resp);
					 }
					 else {
						 //System.out.println("Enter Valid Email and Mobile no");
						 //m1();
						    PrintWriter bn=resp.getWriter();
							bn.print("<h1>Enter Vailid Email and Mobile no</h1>");
							RequestDispatcher b2=req.getRequestDispatcher("NewFile.html");
							b2.include(req, resp);
						 
					 }
						 
						 
					 
				 }
			 }A v21=new A();
			 try {
				v21.m1();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			PrintWriter b1=resp.getWriter();
			b1.print("<h1>Enter vailid password</h1>");
			RequestDispatcher b=req.getRequestDispatcher("Registraion.html");
			b.include(req, resp);
		}
		
		
	}
	

}

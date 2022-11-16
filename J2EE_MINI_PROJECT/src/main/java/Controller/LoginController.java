package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO1.User;
import DTO1.UserDemo;

@WebServlet("/Login")
public class LoginController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		String email=req.getParameter("myemail");
		String password=req.getParameter("psw");
		
		//parsing string value to integer
		int pwd=Integer.parseInt(password);
		
		UserDemo dao=new UserDemo();
		try
		{
			User u=dao.validate(email, pwd);
			if(u !=null)
			{
				HttpSession session=req.getSession();
				session.setAttribute("name", u.getName());
				
				RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
				rd.forward(req, resp);
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				PrintWriter pw=resp.getWriter();
				pw.print("Invalid UserName or Password");
				
				rd.include(req, resp);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(" Handled........");

		}
;	}
}

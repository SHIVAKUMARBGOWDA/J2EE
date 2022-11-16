package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO1.User;
import DTO1.UserDemo;

@WebServlet("/getuser")
public class DisplayServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Fetching user name from session object
		HttpSession session=req.getSession(false);
		String name=(String) session.getAttribute("name");
		
		UserDemo dao=new UserDemo();
		//passing name to dao class
		try
		{
			//return user object
			User u=dao.displayUser(name);
			//getting user object to request
			req.setAttribute("user", u);//manually setting object to request
			
			RequestDispatcher rd=req.getRequestDispatcher("view.jsp");
			rd.forward(req, resp);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Handled....!!!!!!!!!");
			
		}
	}
}

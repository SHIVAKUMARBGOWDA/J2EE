package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO1.User;
import DTO1.UserDemo;
@WebServlet("/save")
public class RegisterController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	//Fetching data from request
	String id=req.getParameter("myid");
	String name=req.getParameter("myname");
	String email=req.getParameter("myemail");
	String phone=req.getParameter("mypnum");
	String password=req.getParameter("psw");
	
	//Creating user object to store all the user data
	User u=new User();
	u.setId(Integer.parseInt(id));
	u.setName(name);
	u.setEmail(email);
	u.setPhone(Long.parseLong(phone));
	u.setPassword(Integer.parseInt(password));
	
	//Pass the user object to the DAO Class
	UserDemo dao=new UserDemo();
	
	try
	{
		dao.insertUser(u);
	}
	catch (Exception e)
	{
		//For Check the Errors
		e.printStackTrace();
		System.out.println("Exception Handled");
	}
	
	RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
	rd.forward(req, resp);
	}
}

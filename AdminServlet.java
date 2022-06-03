package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		
		if(email.equals("admin@gmail.com") && password.equals("admin123"))
			/*if(email.equals("aarti") && password.equals("12345678"))*/
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Successful')");
			out.println("location='adminHome.jsp';");
			out.println("</script>");
			out.print("welcome" + email);
			HttpSession session = request.getSession();
			/*session.setAttribute("id",user.getId());*/
			session.setAttribute("email",email);
			/*session.setAttribute("name", user.getName());*/
			
			/*HttpSession ss=request.getSession();
			ss.setAttribute("email", email);*/
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid Credentials.......')");
			out.println("location='adminLogin.jsp';");
			out.println("</script>");
			
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

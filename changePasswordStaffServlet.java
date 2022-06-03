package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.FacultyDao;



/**
 * Servlet implementation class changePasswordStaffServlet
 */
@WebServlet("/changePasswordStaffServlet")
public class changePasswordStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePasswordStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String oldpass=request.getParameter("oldpass");
		String newpass=request.getParameter("newpass");
		
		FacultyDao dao=new FacultyDao();
		
		if(dao.UpdateStaffPassword(oldpass,newpass))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('password change successfully')");
			out.println("location='staffLogin.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Fail..........')");
			out.println("location='staffHome.jsp';");
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

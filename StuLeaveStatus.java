package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import Dao.StudentDao;

/**
 * Servlet implementation class StuLeaveStatus
 */
@WebServlet("/StuLeaveStatus")
public class StuLeaveStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuLeaveStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String status=request.getParameter("status");
		
		StudentDao dao=new StudentDao();
		
		if(dao.UpdateStudentLveStatus(id, status))
		{
			ResultSet rs=dao.SelectStuLve();
			if(rs!= null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("listUsers", rs);
				out.println("<script type=\"text/javascript\">");
				out.println("alert('student leave status updated successfully');");
				out.println("location='viewstuleave.jsp';");
				out.println("</script>");
			}
			
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User status not updated');");
				out.println("location='ViewUserDetails.jsp';");
				out.println("</script>");
			}
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

package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.FacultyDao;

import Userbean.User;

/**
 * Servlet implementation class StaffLoginServlet
 */
@WebServlet("/StaffLoginServlet")
public class StaffLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String teacher_id=request.getParameter("teacher_id");
		String pass=request.getParameter("pass");
		
		FacultyDao dao=new FacultyDao();
		//UserBean user;// = new UserBean();
		User user=dao.CheckStaff(teacher_id, pass);
		
		
		if ( user== null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('No Such User Present...')");
			out.println("location='staffLogin.jsp';");
			out.println("</script>");
		} else if ((user.getTeacher_id() != null && user.getTeacher_id() != "")
				&& (user.getPass() != null && user.getPass() != "")) {
			if (user.getStatus().equals("Active")) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Login Successful')");
				out.println("location='facultyHome.jsp';");
				out.println("</script>");
				
				out.print("welcome" + teacher_id);
				HttpSession session = request.getSession();
				session.setAttribute("id",user.getId());
				session.setAttribute("email",user.getEmail());
				session.setAttribute("name", user.getName());
				/*out.print("welcome" + rollno);
				HttpSession session = request.getSession();
				session.setAttribute("id",user.getId());
				session.setAttribute("studentname", user.getStudentname());
				session.setAttribute("phoneno", user.getPhoneno());
				session.setAttribute("id", user.getId());
				session.setAttribute("email",user.getEmail());
				session.setAttribute("phoneno", user.getPhoneno());
				session.setAttribute("rollno",user.getRollno());
				session.setAttribute("bookname",user.getBookname());
				session.setAttribute("bookauthor",user.getBookauthor());
				session.setAttribute("bookbarrowdate",user.getBookbarrowdate());*/
				/*session.setAttribute("email",user.getEmail());*/
			} else {
				request.setAttribute("ErrMsg", "Wait for activation of your account!...");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Wait For Activation')");
				out.println("location='staffLogin.jsp';");
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

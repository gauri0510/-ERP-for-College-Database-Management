package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.StudentDao;

import Userbean.User;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String rollno=request.getParameter("rollno");
		String pass=request.getParameter("pass");
		
		StudentDao dao=new StudentDao();
		//UserBean user;// = new UserBean();
		User user=dao.CheckStudent(rollno, pass);
		
		
		if ( user== null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('No Such User Present...')");
			out.println("location='studentLogin.jsp';");
			out.println("</script>");
		} else if ((user.getRollno() != null && user.getRollno() != "")
				&& (user.getPass() != null && user.getPass() != "")) {
			if (user.getStatus().equals("Active")) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Login Successful')");
				out.println("location='studentHome.jsp';");
				out.println("</script>");
				out.print("welcome" + rollno);
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
				out.println("location='studentLogin.jsp';");
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

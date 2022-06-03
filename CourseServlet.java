package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.AdminDao;

import Userbean.User;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String course_id=request.getParameter("course_id");
		String courname=request.getParameter("courname");
		String year=request.getParameter("year");
		String status="Active";
		
		
		
		User b = new User();
		
		b.setCourse_id(course_id);
		b.setCourname(courname);
		
		b.setYear(year);
		b.setStatus(status);
      
		
		AdminDao dao=new AdminDao();
		
		
		
		
		
			if(dao.InsertCourse(b))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Course added')");
				out.println("location='adminHome.jsp';");
				/*out.println("location='Userregistration.jsp';");*/
				out.println("</script>");
				
				/*RegisterMail mail=new RegisterMail();
				mail.emailutility(email);*/
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Course Not added')");
				out.println("location='Addcourse.jsp';");
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

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
 * Servlet implementation class TimetableServlet
 */
@WebServlet("/TimetableServlet")
public class TimetableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimetableServlet() {
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
		String sem=request.getParameter("sem");
		String sub_id=request.getParameter("sub_id");
		String subname=request.getParameter("subname");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		
		
		
		String status="Active";
		
		
		
		User b = new User();

	
		b.setCourse_id(course_id);
		b.setCourname(courname);
		b.setYear(year);
		b.setSem(sem);
		b.setSub_id(sub_id);
		b.setSubname(subname);
		b.setDate(date);
		b.setTime(time);
		b.setStatus(status);
		
		AdminDao dao=new AdminDao();
		
		
		
		
		
			if(dao.InsertTimetable(b))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Add timetable  Details Added')");
				out.println("location='Timetable.jsp';");
				/*out.println("location='Userregistration.jsp';");*/
				out.println("</script>");
				
				/*RegisterMail mail=new RegisterMail();
				mail.emailutility(email);*/
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Subject details not added')");
				out.println("location='addsubject.jsp';");
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

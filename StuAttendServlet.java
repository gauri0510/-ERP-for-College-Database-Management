package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.FacultyDao;

import Userbean.User;

/**
 * Servlet implementation class StuAttendServlet
 */
@WebServlet("/StuAttendServlet")
public class StuAttendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuAttendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String rollno=request.getParameter("rollno");
		String branch=request.getParameter("branch");
		String year=request.getParameter("year");
		String sem=request.getParameter("sem");
		String subname=request.getParameter("subname");
		String teachnm=request.getParameter("teachnm");
		String date=request.getParameter("date");
		
		/*String phoneno=request.getParameter("phoneno");
		String rollno=request.getParameter("rollno");*/
		String status="Present";
		
		User b = new User();
		
	
		b.setName(name);
		b.setRollno(rollno);
		b.setBranch(branch);
		b.setYear(year);
		b.setSem(sem);
		b.setSubname(subname);
		b.setTeachnm(teachnm);
		b.setDate(date);
		b.setStatus(status);
       /* bean.setImage(image);
		
		bean.setImage_name(imageName);
		*/
		FacultyDao dao=new FacultyDao();
		
		
		
		
		
			if(dao.InsertStuAtt(b))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert(' student Attendance updated')");
				out.println("location='facultyHome.jsp';");
				/*out.println("location='Userregistration.jsp';");*/
				out.println("</script>");
				
				/*RegisterMail mail=new RegisterMail();
				mail.emailutility(email);*/
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert(' Attendance  not updated')");
				out.println("location='addStuAttend.jsp';");
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

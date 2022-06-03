package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.FacultyDao;
import Dao.StudentDao;
import Userbean.User;

/**
 * Servlet implementation class StudFineServlet
 */
@WebServlet("/StudFineServlet")
public class StudFineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudFineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String branch=request.getParameter("branch");
		String year=request.getParameter("year");
		String rollno=request.getParameter("rollno");
		String reason=request.getParameter("reason");
		String amt=request.getParameter("amt");
		String dtesrt=request.getParameter("dtesrt");
		String dtedue=request.getParameter("dtedue");
		String status="Unpaid";
		
		
		
		User b = new User();
		
	
		b.setName(name);
		b.setGender(gender);
		b.setBranch(branch);
		b.setYear(year);
		b.setRollno(rollno);
		b.setReason(reason);
		b.setAmt(amt);
		b.setDtesrt(dtesrt);
		b.setDtedue(dtedue);
		b.setStatus(status);
      
		
		StudentDao dao=new StudentDao();
		
		
		
		
		
			if(dao.InsertStudentfine(b))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Fine details sent')");
				out.println("location='fineForm.jsp';");
				/*out.println("location='Userregistration.jsp';");*/
				out.println("</script>");
				
				/*RegisterMail mail=new RegisterMail();
				mail.emailutility(email);*/
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Not sent')");
				out.println("location='fineForm.jsp';");
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

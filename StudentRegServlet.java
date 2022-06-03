package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDao;
import Userbean.User;

/**
 * Servlet implementation class StudentRegServlet
 */
@WebServlet("/StudentRegServlet")
public class StudentRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String contactno=request.getParameter("contactno");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String branch=request.getParameter("branch");
		String year=request.getParameter("year");
		String email=request.getParameter("email");
		String prnno=request.getParameter("prnno");
		String rollno=request.getParameter("rollno");
		String pass=request.getParameter("pass");
		/*String phoneno=request.getParameter("phoneno");
		String rollno=request.getParameter("rollno");*/
		String status="Active";
		
		User b = new User();
		
	
		b.setName(name);
		b.setContactno(contactno);
		b.setAddress(address);
		b.setGender(gender);
		b.setBranch(branch);
		b.setYear(year);
		b.setEmail(email);
		b.setPrnno(prnno);
		b.setRollno(rollno);
		b.setPass(pass);
		b.setEmail(email);
		b.setPass(pass);
		b.setStatus(status);
       /* bean.setImage(image);
		
		bean.setImage_name(imageName);
		*/
		StudentDao dao=new StudentDao();
		
		
		
		
		
			if(dao.InsertStudentData(b))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('New Student Add Successful')");
				out.println("location='AddStuImage.jsp';");
				/*out.println("location='Userregistration.jsp';");*/
				out.println("</script>");
				
				/*RegisterMail mail=new RegisterMail();
				mail.emailutility(email);*/
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Registration UnSuccessful')");
				out.println("location='studentRegister.jsp';");
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

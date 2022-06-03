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
 * Servlet implementation class StaffRegServlet
 */
@WebServlet("/StaffRegServlet")
public class StaffRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffRegServlet() {
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
		String email=request.getParameter("email");
		String designation=request.getParameter("designation");
		
		String teacher_id=request.getParameter("teacher_id");
		
		String pass=request.getParameter("pass");
		
		String status="Active";
		
		User b = new User();
		
	
		b.setName(name);
		b.setContactno(contactno);
		b.setAddress(address);
		b.setGender(gender);
		b.setBranch(branch);
		b.setDesignation(designation);
		b.setEmail(email);
		b.setTeacher_id(teacher_id);
		/*b.setPrnno(prnno);
		b.setRollno(rollno);*/
		b.setPass(pass);
	
		
		b.setStatus(status);
       /* bean.setImage(image);
		
		bean.setImage_name(imageName);
		*/
		FacultyDao dao=new FacultyDao();
		
		
		
		
		
			if(dao.InsertStaffData(b))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('new faculty add Successful')");
				out.println("location='Faculty.jsp';");
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

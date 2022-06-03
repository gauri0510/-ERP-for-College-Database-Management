package Servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.FacultyDao;
import Userbean.User;

/**
 * Servlet implementation class newFacultyServlet
 */
@MultipartConfig(maxFileSize = 10485760)
@WebServlet("/newFacultyServlet")
public class newFacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream image=null;		
	String imageName="";
	String path=null;
	File upload=null; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newFacultyServlet() {
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
		String subject=request.getParameter("subject");
		String teacher_id=request.getParameter("teacher_id");
		String status="Active";
		
		FacultyDao db=new FacultyDao();
		
		User b = new User();
		Part part=request.getPart("file");
		
		if(part!=null)
		{
			image=part.getInputStream();
			System.out.println("is size:"+image.available());
			
			imageName=db.extractFileName(part);
			System.out.println("name:"+imageName);
		}
		
	
		b.setName(name);
		b.setGender(gender);
		b.setBranch(branch);
		b.setSubject(subject);
		b.setTeacher_id(teacher_id);
		b.setStatus(status);
       b.setImage(image);
		
		b.setImage_name(imageName);
		
		FacultyDao dao=new FacultyDao();
		
		
		
		
		
			if(dao.InsertNewStaffData(b))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('faculty added')");
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
				out.println("location='staffRegister.jsp';");
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

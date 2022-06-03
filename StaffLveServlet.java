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
import Dao.StudentDao;
import Userbean.User;

/**
 * Servlet implementation class StaffLveServlet
 */
@MultipartConfig(maxFileSize = 10485760)
@WebServlet("/StaffLveServlet")
public class StaffLveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream image=null;		
	String imageName="";
	String path=null;
	File upload=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffLveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String teacher_id=request.getParameter("teacher_id");
		String lvetyp=request.getParameter("lvetyp");
		String lvedtesrt=request.getParameter("lvedtesrt");
		String lvedtend=request.getParameter("lvedtend");
		String msg=request.getParameter("msg");
		
		
		/*String pass=request.getParameter("pass");*/
		
		String status="Pending";
		
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
		b.setTeacher_id(teacher_id);
		b.setLvetyp(lvetyp);
		b.setLvedtesrt(lvedtesrt);
		b.setLvedtend(lvedtend);
		b.setMsg(msg);
		
		b.setStatus(status);
		b.setImage(image);
		
		b.setImage_name(imageName);
	
		FacultyDao dao=new FacultyDao();
		
		
		
		
		
			if(dao.InsertStaffLve(b))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Leave Application send Successful')");
				out.println("location='facultyHome.jsp';");
				/*out.println("location='Userregistration.jsp';");*/
				out.println("</script>");
				
				/*RegisterMail mail=new RegisterMail();
				mail.emailutility(email);*/
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Application send UnSuccessful')");
				out.println("location='staffleave.jsp';");
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

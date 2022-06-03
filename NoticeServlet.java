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

import Dao.AdminDao;
import Dao.FacultyDao;
import Dao.StudentDao;
import Userbean.User;

/**
 * Servlet implementation class NoticeServlet
 */
@MultipartConfig(maxFileSize = 10485760)
@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream image=null;		
	String imageName="";
	String path=null;
	File upload=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String status="Active";
		
		AdminDao db=new AdminDao();
		User b = new User();
		Part part=request.getPart("file");
		
		if(part!=null)
		{
			image=part.getInputStream();
			System.out.println("is size:"+image.available());
			
			imageName=db.extractFileName(part);
			System.out.println("name:"+imageName);
		}
		
	
		
		b.setStatus(status);
		b.setImage(image);
		
		b.setImage_name(imageName);
	
		AdminDao dao=new AdminDao();
		
		
		
		
		
			if(dao.Insertnotice(b))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Notice send  Successful')");
				out.println("location='Notification.jsp';");
				/*out.println("location='Userregistration.jsp';");*/
				out.println("</script>");
				
				/*RegisterMail mail=new RegisterMail();
				mail.emailutility(email);*/
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('notice send UnSuccessful')");
				out.println("location='Notification.jsp';");
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

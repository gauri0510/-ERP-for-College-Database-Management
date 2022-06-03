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

import Dao.StudentDao;
import Userbean.User;

/**
 * Servlet implementation class StuLveServlet
 */
@MultipartConfig(maxFileSize = 10485760)

@WebServlet("/StuLveServlet")
public class StuLveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
		InputStream image=null;		
		String imageName="";
		String path=null;
		File upload=null; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuLveServlet() {
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
		String lvetyp=request.getParameter("lvetyp");
		String lvedtesrt=request.getParameter("lvedtesrt");
		String lvedtend=request.getParameter("lvedtend");
		String msg=request.getParameter("msg");
		String teachnm=request.getParameter("teachnm");
		
		/*String pass=request.getParameter("pass");*/
		
		String status="Pending";
		
		StudentDao db=new StudentDao();
		
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
		b.setRollno(rollno);
		b.setLvetyp(lvetyp);
		b.setLvedtesrt(lvedtesrt);
		b.setLvedtend(lvedtend);
		b.setMsg(msg);
		b.setTeachnm(teachnm);
		b.setStatus(status);
		b.setImage(image);
		
		b.setImage_name(imageName);
	
		StudentDao dao=new StudentDao();
		
		
		
		
		
			if(dao.InsertstuLve(b))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Leave Application send Successful')");
				out.println("location='studentHome.jsp';");
				/*out.println("location='Userregistration.jsp';");*/
				out.println("</script>");
				
				/*RegisterMail mail=new RegisterMail();
				mail.emailutility(email);*/
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Application send UnSuccessful')");
				out.println("location='studleave.jsp';");
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

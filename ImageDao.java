package Dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.Part;

import DB.DBconnection;
import Userbean.User;




public class ImageDao {Connection connection=null;
Boolean resultStatus=Boolean.FALSE;
PreparedStatement ps;
ResultSet rs;
Statement st=null;
String sql;
boolean flag = false;


 //insert operation
 public boolean InsertStudentData(User user) {
		
		sql = "insert into image (email,pass,status,image,imagename) values(?,?,?,?,?)";//registration queery

		Connection con = DBconnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			
			
			
			ps.setString(1,user.getEmail());
			ps.setString(2,user.getPass());
			ps.setString(3,user.getStatus());
			ps.setBlob(4,user.getImage());
			ps.setString(5,user.getImage_name());
			int index = ps.executeUpdate();
			
			if (index > 0) {
				
				flag = true;
				
			} else 
			{
				flag = false;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return flag;
 }
 
 public boolean alreadyStudent(String rollno) throws SQLException {
		String sql="select * from image where email=?";
		connection=DBconnection.getConnection();
		ps=connection.prepareStatement(sql);
		ps.setString(1, rollno);
		rs=ps.executeQuery();
		if(rs.next())
		{
			resultStatus=true;
		}
		return resultStatus;
	}



/*public User CheckStudent(String email, String pass, InputStream image) {
		
		User bean=new User();
		sql = "select * from image where email='" + email + "' and pass='" + pass + "' ";
		int flag = 0;
		try {
			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				flag = 1;
				bean.setId(rs.getInt(1));
				bean.setEmail(rs.getString(2));
				bean.setPass(rs.getString(3));
				bean.setStatus(rs.getString(4));
				Blob blob = null;
				bean.setImage(rs.getBlob(5));
				bean.setImage_name(rs.getString(6));
				
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(flag ==1)
			return bean;
		else 
			return null;
	}*/

public boolean UpdateStudentStatus(int userid, String status) {
		if(status.equalsIgnoreCase("Inactive"))
			status="Active";
		else
			status="Inactive";
		
		String sql="update image set status=? where id=?";
		
		try {
			ps=DBconnection.getConnection().prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, userid);
			
			int index=ps.executeUpdate();
			if(index>0)
			{
				flag=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}



public ResultSet SelectStudent() {
ResultSet rs= null;
			String sql ="Select * from image";
			try {
				PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
				rs = pstmt.executeQuery();			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		}


public boolean UpdateStudentPassword(String oldpass,String newpass) {
	
	sql="update image set pass=? where pass='"+oldpass+"'";
	
	Connection con = DBconnection.getConnection();
	
	try {
		ps=con.prepareStatement(sql);
		ps.setString(1, newpass);
		
		int index=ps.executeUpdate();
		
		if(index>0)
		{
			flag=true;
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return flag;
}
	
public boolean DeleteStudent(int id) {
	String sql="delete from image where id='"+id+"'";
			 Connection con=DBconnection.getConnection();
			 try {
				ps=con.prepareStatement(sql);
				int index =ps.executeUpdate();
				if(index>0)
				{
					flag=true;
				}
				else
				{
					flag=false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
				return flag;
		}

public String extractFileName(Part part) {
	final String partHeader = part.getHeader("content-disposition");
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
			return null;
	
}


}
 
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.Part;

import DB.DBconnection;
import Userbean.User;




public class FacultyDao {Connection connection=null;
Boolean resultStatus=Boolean.FALSE;
PreparedStatement ps;
ResultSet rs;
Statement st=null;
String sql;
boolean flag = false;


 //insert operation
 public boolean InsertStaffData(User user) {
		
		sql = "insert into staff_reg (name,contactno,address,gender,branch,email,designation,teacher_id,pass,status) values(?,?,?,?,?,?,?,?,?,?)";//registration queery

		Connection con = DBconnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			/*ps.setInt(1, user.getId());*/
			
			
			ps.setString(1,user.getName());
			ps.setString(2,user.getContactno());
			ps.setString(3,user.getAddress());
			ps.setString(4,user.getGender());
			ps.setString(5, user.getBranch());
			ps.setString(6,user.getEmail());
			ps.setString(7,user.getDesignation());
			ps.setString(8,user.getTeacher_id());
			ps.setString(9,user.getPass());
			ps.setString(10,user.getStatus());
			
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
 
 public boolean alreadyStaff(String teacher_id) throws SQLException {
		String sql="select * from staff_reg where teacher_id=?";
		connection=DBconnection.getConnection();
		ps=connection.prepareStatement(sql);
		ps.setString(1, teacher_id);
		rs=ps.executeQuery();
		if(rs.next())
		{
			resultStatus=true;
		}
		return resultStatus;
	}



public User CheckStaff(String teacher_id, String pass) {
		
		User bean=new User();
		sql = "select * from staff_reg where teacher_id='" + teacher_id + "' and pass='" + pass + "' ";
		int flag = 0;
		try {
			Statement stmt = DBconnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				flag = 1;
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setContactno(rs.getString(3));
				bean.setAddress(rs.getString(4));
				bean.setGender(rs.getString(5));
				bean.setBranch(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setDesignation(rs.getString(8));
				bean.setTeacher_id(rs.getString(9));
				bean.setPass(rs.getString(10));
				bean.setStatus(rs.getString(11));
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(flag ==1)
			return bean;
		else 
			return null;
	}


public boolean UpdateStaffPassword(String oldpass,String newpass) {
	
	sql="update staff_reg set pass=? where pass='"+oldpass+"'";
	
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

public boolean UpdateStaffStatus(int userid, String status) {
		if(status.equalsIgnoreCase("Inactive"))
			status="Active";
		else
			status="Inactive";
		
		String sql="update staff_reg set status=? where id=?";
		
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



public ResultSet SelectStaff() {
ResultSet rs= null;
			String sql ="Select * from staff_reg";
			try {
				PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
				rs = pstmt.executeQuery();			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		}


	 
	
public boolean DeleteStaff(int id) {
	String sql="delete from staff_reg where id='"+id+"'";
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


public boolean InsertNewStaffData(User user) {
	
	sql = "insert into add_newstaff (name,gender,branch,subject,teacher_id,status,image,imagename) values(?,?,?,?,?,?,?,?)";//registration queery

	Connection con = DBconnection.getConnection();

	try {
		ps = con.prepareStatement(sql);
		
		/*ps.setInt(1, user.getId());*/
		
		
		ps.setString(1,user.getName());
		ps.setString(2,user.getGender());
		ps.setString(3, user.getBranch());
		ps.setString(4,user.getSubject());
		ps.setString(5,user.getTeacher_id());
		ps.setString(6,user.getStatus());
		ps.setBlob(7,user.getImage());
		ps.setString(8,user.getImage_name());
		
		
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

public boolean UpdateNewStaffStatus(int userid, String status) {
	if(status.equalsIgnoreCase("Inactive"))
		status="Active";
	else
		status="Inactive";
	
	String sql="update add_newstaff set status=? where id=?";
	
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



public ResultSet SelectNewStaff() {
ResultSet rs= null;
		String sql ="Select * from add_newstaff";
		try {
			PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}


 

public boolean DeleteNewStaff(int id) {
String sql="delete from add_newstaff where id='"+id+"'";
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

public boolean InsertStaffLve(User user) {
	
	sql = "insert into staffleave (name,teacher_id,lvetyp,lvedtesrt,lvedtend,msg,status,image,imagename) values(?,?,?,?,?,?,?,?,?)";//registration queery

	Connection con = DBconnection.getConnection();

	try {
		ps = con.prepareStatement(sql);
		
		/*ps.setInt(1, user.getId());*/
		
		ps.setString(1, user.getName());
		ps.setString(2,user.getTeacher_id());
		ps.setString(3, user.getLvetyp());
		ps.setString(4, user.getLvedtesrt());
		ps.setString(5, user.getLvedtend());
		ps.setString(6, user.getMsg());
		ps.setString(7,user.getStatus());
		ps.setBlob(8,user.getImage());
		ps.setString(9,user.getImage_name());
		
		
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

public boolean UpdateStaffLveStatus(int userid, String status) {
	if(status.equalsIgnoreCase("Approved"))
		status="Pending";
	else
		status="Approved";
	
	String sql="update staffleave set status=? where id=?";
	
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



public ResultSet SelectStaffLve() {
ResultSet rs= null;
		String sql ="Select * from staffleave";
		try {
			PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}


 

public boolean DeleteStaffLve(int id) {
String sql="delete from staffleave where id='"+id+"'";
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


public boolean InsertStuAtt(User user) {
	
	sql = "insert into stuatt (name,rollno,branch,year,sem,subname,teachnm,date,status) values(?,?,?,?,?,?,?,?,?)";//registration queery

	Connection con = DBconnection.getConnection();

	try {
		ps = con.prepareStatement(sql);
		
		/*ps.setInt(1, user.getId());*/
		
		
		ps.setString(1,user.getName());
		ps.setString(2,user.getRollno());
		ps.setString(3, user.getBranch());
		ps.setString(4,user.getYear());
		ps.setString(5,user.getSem());
		ps.setString(6,user.getSubname());
		ps.setString(7,user.getTeachnm());
		ps.setString(8,user.getDate());
		ps.setString(9,user.getStatus());
		
		
		
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

public boolean UpdateStuAttStatus(int userid, String status) {
	if(status.equalsIgnoreCase("Absent"))
		status="Present";
	else
		status="Absent";
	
	String sql="update stuatt set status=? where id=?";
	
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



public ResultSet SelectStuAtt() {
ResultSet rs= null;
		String sql ="Select * from stuatt";
		try {
			PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}


 

public boolean DeletestuAtt(int id) {
String sql="delete from stuatt where id='"+id+"'";
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
 
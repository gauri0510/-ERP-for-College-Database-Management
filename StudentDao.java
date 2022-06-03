package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.Part;

import DB.DBconnection;
import Userbean.User;




public class StudentDao {Connection connection=null;
Boolean resultStatus=Boolean.FALSE;
PreparedStatement ps;
ResultSet rs;
Statement st=null;
String sql;
boolean flag = false;


 //insert operation
 public boolean InsertStudentData(User user) {
		
		sql = "insert into stud_reg (name,contactno,address,gender,branch,year,email,prnno,rollno,pass,status) values(?,?,?,?,?,?,?,?,?,?,?)";//registration queery

		Connection con = DBconnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			/*ps.setInt(1, user.getId());*/
			
			
			ps.setString(1,user.getName());
			ps.setString(2,user.getContactno());
			ps.setString(3,user.getAddress());
			ps.setString(4,user.getGender());
			ps.setString(5,user.getBranch());
			ps.setString(6,user.getYear());
			ps.setString(7,user.getEmail());
			ps.setString(8,user.getPrnno());
			ps.setString(9,user.getRollno());
			ps.setString(10,user.getPass());
			ps.setString(11,user.getStatus());
			
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
		String sql="select * from stud_reg where rollno=?";
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



public User CheckStudent(String rollno, String pass) {
		
		User bean=new User();
		sql = "select * from stud_reg where rollno='" + rollno + "' and pass='" + pass + "' ";
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
				bean.setYear(rs.getString(7));
				bean.setEmail(rs.getString(8));
				bean.setPrnno(rs.getString(9));
				bean.setRollno(rs.getString(10));
				bean.setPass(rs.getString(11));
				bean.setStatus(rs.getString(12));
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(flag ==1)
			return bean;
		else 
			return null;
	}

public boolean UpdateStudentStatus(int userid, String status) {
		if(status.equalsIgnoreCase("Inactive"))
			status="Active";
		else
			status="Inactive";
		
		String sql="update stud_reg set status=? where id=?";
		
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
			String sql ="Select * from stud_reg";
			try {
				PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
				rs = pstmt.executeQuery();			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		}


public boolean UpdateStudentPassword(String oldpass,String newpass) {
	
	sql="update stud_reg set pass=? where pass='"+oldpass+"'";
	
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
	String sql="delete from stud_reg where id='"+id+"'";
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

public boolean InsertStuImage(User user) {
	
	sql = "insert into addstuimage (rollno,status,image,imagename) values(?,?,?,?)";//registration queery

	Connection con = DBconnection.getConnection();

	try {
		ps = con.prepareStatement(sql);
		
		/*ps.setInt(1, user.getId());*/
		
		ps.setString(1,user.getRollno());
		ps.setString(2,user.getStatus());
		ps.setBlob(3,user.getImage());
		ps.setString(4,user.getImage_name());
		
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

public ResultSet SelectStuImage() {
ResultSet rs= null;
			String sql ="Select * from addstuimage";
			try {
				PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
				rs = pstmt.executeQuery();			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		}
public boolean UpdateStudentLveStatus(int userid, String status) {
	if(status.equalsIgnoreCase("Approved"))
		status="Pending";
	else
		status="Approved";
	
	String sql="update stuleave set status=? where id=?";
	
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


public boolean DeleteStudentImage(int id) {
	String sql="delete from addstuimage where id='"+id+"'";
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

public boolean InsertstuLve(User user) {
	
	sql = "insert into stuleave (name,rollno,lvetyp,lvedtesrt,lvedtend,msg,teachnm,status,image,imagename) values(?,?,?,?,?,?,?,?,?,?)";//registration queery

	Connection con = DBconnection.getConnection();

	try {
		ps = con.prepareStatement(sql);
		
		/*ps.setInt(1, user.getId());*/
		ps.setString(1, user.getName());
		ps.setString(2,user.getRollno());
		ps.setString(3, user.getLvetyp());
		ps.setString(4, user.getLvedtesrt());
		ps.setString(5, user.getLvedtend());
		ps.setString(6, user.getMsg());
		ps.setString(7, user.getTeachnm());
		ps.setString(8,user.getStatus());
		ps.setBlob(9,user.getImage());
		ps.setString(10,user.getImage_name());
		
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

public ResultSet SelectStuLve() {
ResultSet rs= null;
			String sql ="Select * from stuleave";
			try {
				PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
				rs = pstmt.executeQuery();			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		}

public boolean DeleteStudentLve(int id) {
	String sql="delete from stuleave where id='"+id+"'";
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

public boolean InsertStudentfine(User user) {
	
	sql = "insert into stufine (name,gender,branch,year,rollno,reason,amt,dtesrt,dtedue,status) values(?,?,?,?,?,?,?,?,?,?)";//registration queery

	Connection con = DBconnection.getConnection();

	try {
		ps = con.prepareStatement(sql);
		
		/*ps.setInt(1, user.getId());*/
		
		
		ps.setString(1,user.getName());
		ps.setString(2,user.getGender());
		ps.setString(3,user.getBranch());
		ps.setString(4,user.getYear());
		ps.setString(5,user.getRollno());
		ps.setString(6,user.getReason());
		ps.setString(7, user.getAmt());
		ps.setString(8, user.getDtesrt());
		ps.setString(9, user.getDtedue());
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

public ResultSet SelectStufine() {
ResultSet rs= null;
			String sql ="Select * from stufine";
			try {
				PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
				rs = pstmt.executeQuery();			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		}

/*public boolean alreadyStudent(String rollno) throws SQLException {
	String sql="select * from stud_reg where rollno=?";
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



public User CheckStudent(String rollno, String pass) {
	
	User bean=new User();
	sql = "select * from stud_reg where rollno='" + rollno + "' and pass='" + pass + "' ";
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
			bean.setYear(rs.getString(7));
			bean.setEmail(rs.getString(8));
			bean.setPrnno(rs.getString(9));
			bean.setRollno(rs.getString(10));
			bean.setPass(rs.getString(11));
			bean.setStatus(rs.getString(12));
			
		}

	} catch (SQLException e) {

		e.printStackTrace();
	}
	if(flag ==1)
		return bean;
	else 
		return null;
}
*/
public boolean UpdateStudentFineStatus(int userid, String status) {
	if(status.equalsIgnoreCase("Paid"))
		status="Unpaid";
	else
		status="Paid";
	
	String sql="update stufine set status=? where id=?";
	
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



public ResultSet SelectStudentFine() {
ResultSet rs= null;
		String sql ="Select * from stufine";
		try {
			PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}


/*public boolean UpdateStudentPassword(String oldpass,String newpass) {

sql="update stud_reg set pass=? where pass='"+oldpass+"'";

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
}*/

public boolean DeleteStudentfine(int id) {
String sql="delete from stufine where id='"+id+"'";
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
 
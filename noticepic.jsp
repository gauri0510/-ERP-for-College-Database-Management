<%@page import="DB.DBconnection"%>
<%@ page import="java.sql.*,java.io.*,java.util.*" %> 


<%@ page trimDirectiveWhitespaces="true" %>
<%
		int id = Integer.parseInt(request.getParameter("id"));
		String sql = "Select image from notice where id=?";
		PreparedStatement pstmt = DBconnection.getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			InputStream is = rs.getBinaryStream(1);
			
			byte[] profilePic = null;
			byte[] profilePic1 = null;
		   	byte[] buffer = new byte[1024*1024*50];
			int bytesRead;		
			if(is!=null){
				while ((bytesRead =is.read(buffer)) != -1)
				{
				   	response.reset();
					response.setContentType("file");
					response.setHeader("Content-disposition","attachment; filename=" );
					
			    	response.getOutputStream().write(buffer, 0, bytesRead);
			    	response.getOutputStream().flush(); 
			 	}
			}		
	
		}		
		
%>
package com.mtw.publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mtw.common.DBInfo;

public class PublisherDao {
		
	public List<Publisher> selectAll() throws SQLException, ClassNotFoundException{
		 Connection conn = null;
    	 try {
			conn = DBInfo.getConnnection();
			String sql = "select * from tbl_publisher";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Publisher> list = new ArrayList<Publisher>();
			while(rs.next()) {
				list.add(new Publisher(rs.getLong("pubid"), 
						rs.getString("name"),
						rs.getString("contact"),
						rs.getString("phone")));
			}
			return list;
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

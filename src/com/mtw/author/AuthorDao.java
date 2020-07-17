package com.mtw.author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mtw.common.DBInfo;

public class AuthorDao {
	public List<Author> selectAll() throws SQLException, ClassNotFoundException{
		 Connection conn = null;
   	 try {
			conn = DBInfo.getConnnection();
			String sql = "select * from tbl_author";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Author> list = new ArrayList<Author>();
			while(rs.next()) {
				list.add(new Author(rs.getString("authorid"),
						rs.getString("name")));
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

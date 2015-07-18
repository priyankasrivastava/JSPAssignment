package com.raremile.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.raremile.common.DatabaseManager;
import com.raremile.entities.User;
import org.apache.log4j.Logger;

/**
 * 
 * @author
 * 
 *         UserDAL class is mainly creating the database connection and
 *         interacting with the User java class..
 */

public class UserDAL {
	private static final Logger LOG = Logger
			.getLogger(com.raremile.dal.UserDAL.class);

	private static final String Select_User_Data = "SELECT * FROM USER WHERE USER_EMAIL=?";

	/**
	 * Retrieving the data from UserDatabase
	 * 
	 * @param username
	 * @return
	 */

	public List<User> getUserData(String username) {
		LOG.info("Retrieving the records from user data");
		List<User> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DatabaseManager.getConnection();
			pstmt = con.prepareStatement(Select_User_Data);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			list = new ArrayList<User>();
			User user = new User();
			while (rs.next()) {
				user.setUserId(rs.getLong(1));
				user.setUserName(rs.getString(2));
				user.setUserRole(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				list.add(user);
			}

		} catch (SQLException e) {
			LOG.error("Could not Load the driver", e);
			throw new DatabaseException("SQLException in retrieving data");
		} finally {
			DatabaseManager.closeDBObjects(pstmt, rs, con);
		}
		return list;

	}

}

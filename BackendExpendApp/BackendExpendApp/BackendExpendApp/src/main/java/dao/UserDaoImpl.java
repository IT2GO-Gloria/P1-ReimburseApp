package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;
import pojo.UserPojo;

public class UserDaoImpl implements UserDao {
	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

//	@Override
//	public UserPojo addUser(UserPojo userInfo) throws ApplicationException {
//		logger.info("Entered registerUser() is located in dao.");
//		userInfo.setUserRemoved(false);
//
//		Connection connection = DbUtil.makeConnection();
//		try {
//			Statement statement = connection.createStatement();
//
//			String query = "insert into users_info(firstname, lastname, email, "
//					+ "username, password, accessLevel, userRemoved ) " + "values( '" + userInfo.getFirstname()
//					+ " ', '" + userInfo.getLastname() + "', '" + userInfo.getEmail() + "', '" + userInfo.getUsername()
//					+ "',  " + "'" + userInfo.getPassword() + "', '" + userInfo.getAccessLevel() + "'," + " "
//					+ userInfo.isUserRemoved() + ") returning user_id ";
//			ResultSet rs = statement.executeQuery(query);
//			rs.next();
//			userInfo.setUserId(rs.getInt(1));
//		} catch (SQLException e) {
//			throw new ApplicationException(e.getMessage());
//		}
//
//		logger.info("Left registerUser() is located in dao.");
//		return userInfo;
//	}

	@Override
	public UserPojo validateUser(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered validateUser() in dao.");
		java.sql.Connection conn = DbUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from users_info where username='" + userPojo.getUsername() + "' and password='"
					+ userPojo.getPassword() + "'";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				userPojo.setFirstname(rs.getString(4));
				userPojo.setLastname(rs.getString(5));
				userPojo.setEmail(rs.getString(6));
				userPojo.setAccessLevel(rs.getString(7));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited validateUser() in dao.");
		return userPojo;
	}
	
	@Override
	public UserPojo loggingUser(int userId) throws ApplicationException {
		logger.info("Entered  loggingUser() is located in dao.");
		Connection connection = DbUtil.makeConnection();
		Statement statement;
		UserPojo userinformation = null;
		try {
			statement = connection.createStatement();
			String query = "SELECT * FROM users_info where userId=" + userId + "AND userRemoved=false";
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				userinformation = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Left  loggingUser() is located in dao.");
		return userinformation;
	}

	@Override
	public UserPojo updateUser(UserPojo userInfo) throws ApplicationException {
		logger.info("Entered updateUser() is located in dao.");
		Connection connection = DbUtil.makeConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "update user_info set  password=" + userInfo.getPassword() + "WHERE userId="
					+ userInfo.getUserId();

		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Left updateUser() is located in dao.");
		return userInfo;
	}

	@Override
	public boolean deleteUser(int userId) throws ApplicationException {
		logger.info("Entered  deleteUser() is located in dao.");

		Connection connection = DbUtil.makeConnection();
		int rowsAffected = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "update users_info  set userRemoved=true WHERE userId=" + userId;
			rowsAffected = statement.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Left  deleteUser() is located in dao.");

		return false;
	}

	@Override
	public List<UserPojo> retrieveAllUsers() throws ApplicationException {

		logger.info("Entered  retrieveAllUsers() is located in dao.");

		List<UserPojo> allusers = new ArrayList<UserPojo>();

		Connection connection = DbUtil.makeConnection();
		Statement statement;

		try {
			statement = connection.createStatement();

			String query = "select *  from  users_info where userRemoved=false ORDER BY userid asc";

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				UserPojo userinformationPojo = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));

				allusers.add(userinformationPojo);
			}

		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Left  retrieveAllUsers() is located in dao.");
		return allusers;
	}

	@Override
	public UserPojo retrieveAUser(int userId) throws ApplicationException {

		logger.info("Entered  retrieveAUser() is located in dao.");
		Statement statement;
		UserPojo userInformationPojo = null;
		try {
			Connection connection = DbUtil.makeConnection();
			statement = connection.createStatement();

			String query = " select * from users_info where userId=" + userId + "and user_removed=false";

			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				userInformationPojo = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
			}

		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Left  retrieveAUser() is located in dao.");

		return null;
	}

	@Override
	public void exitApplication() {
		logger.info("Entering This  exitApplication() located in dao .");
		DbUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");

	}

	@Override
	public UserPojo registerUser(UserPojo userInfo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
}

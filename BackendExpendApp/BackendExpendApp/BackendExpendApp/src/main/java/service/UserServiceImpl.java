package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.UserDaoImpl;
import dao.UserDao;
import exception.ApplicationException;
import pojo.UserPojo;

public class UserServiceImpl implements UserService{
	private static final Logger logger =  LogManager.getLogger(UserServiceImpl.class);
	UserDao authUsersDao;
	
	public UserServiceImpl () {
		this.authUsersDao = new UserDaoImpl();
	}

	@Override
	public UserPojo registerUser(UserPojo userInfo) throws ApplicationException {
		logger.info("Entered registerUserService() located in service Layer");
		UserPojo  returnUserInformationPojo = this.authUsersDao.registerUser(userInfo);
		logger.info("Left registerUserService() located in service Layer");
		return returnUserInformationPojo;
	}
	
	@Override
	public UserPojo validateUser(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered validateUser() in service.");
		UserPojo returnUserPojo = this.authUsersDao.validateUser(userPojo);
		logger.info("Exited validateUser() in service.");
		return returnUserPojo;
	}
	
	@Override
	public UserPojo loggingUser(int userId) throws ApplicationException {
		logger.info("Entered loggingUserService() located in service Layer");
		UserPojo  returnUserInformationPojo = this.authUsersDao.loggingUser(userId);
		logger.info("Left logginUserService() located in service Layer");
		return returnUserInformationPojo;
	}

	
	@Override
	public UserPojo updateUser(UserPojo userInfo) throws ApplicationException {
		logger.info("Entered  updateUserService() located in service Layer");	
		UserPojo  returnUserInformationPojo = this.authUsersDao.updateUser(userInfo) ;
		logger.info("Left  updateUserService() located in service Layer");
		return returnUserInformationPojo;
	}

	@Override
	public boolean deleteUser(int userId) throws ApplicationException {
	logger.info("Entered deleteUserService() located in service Layer");
		
		boolean  returnUserInformationPojo = this.authUsersDao.deleteUser(userId) ;
		logger.info("Left  deleteUserService() located in service Layer");
		return returnUserInformationPojo;
	}

	@Override
	public List<UserPojo> retrieveAllUsers() throws ApplicationException {
	logger.info("Entered  retrieveAllUserService() located in service Layer");
		
		List<UserPojo>  allUsers = this.authUsersDao.retrieveAllUsers() ;
		logger.info("Left  retrieveAllUserService() located in service Layer");
		return allUsers;
	}
	@Override
	public UserPojo retrieveAUser(int userId) throws ApplicationException {
           logger.info("Entered  retrieveAUserService() located in service Layer");
		
		UserPojo  returnUserInformationPojo = this.authUsersDao.retrieveAUser(userId) ;
		logger.info("Left  retrieveAUserService() located in service Layer");
		return returnUserInformationPojo;
	}	
	
	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() located in service.");
		authUsersDao.exitApplication();
		logger.info("Exited exitApplication()  located in service.");
	}

}

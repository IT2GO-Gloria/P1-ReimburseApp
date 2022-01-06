package service;

import java.util.List;

import exception.ApplicationException;
import pojo.UserPojo;

public interface UserService {
	UserPojo registerUser(UserPojo userInfo) throws ApplicationException;
	UserPojo loggingUser(int userId) throws ApplicationException;
	UserPojo updateUser(UserPojo userInfo) throws ApplicationException;
	boolean deleteUser(int userId) throws ApplicationException;
	UserPojo retrieveAUser(int userId) throws ApplicationException;
	List<UserPojo> retrieveAllUsers() throws ApplicationException;
	UserPojo validateUser(UserPojo userPojo) throws ApplicationException;
	void exitApplication();


}

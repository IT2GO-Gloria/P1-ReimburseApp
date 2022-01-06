package service;

import java.util.List;

import exception.ApplicationException;
import pojo.ReimbursementPojo;

public interface ReimbursementService {
	ReimbursementPojo createReimbursementService(ReimbursementPojo reimbursementPojo) throws ApplicationException;

	ReimbursementPojo updateReimbursementService(ReimbursementPojo reimbursementPojo) throws ApplicationException;

	boolean deleteReimbursementService(int reimbursementId) throws ApplicationException;

	ReimbursementPojo retrieveAReimbursementService(int reimbursementId) throws ApplicationException;

	List<ReimbursementPojo> retrieveAllReimbursementsService() throws ApplicationException;

	// ----------newly added reimbursements
	// create endpoint to take userId & return all reimbursement for this user
	List<ReimbursementPojo> getAUserReimbursementService(int userId) throws ApplicationException;

	// create endpoint to take userId & return all the pending reimb
	List<ReimbursementPojo> getAUserPendingReimbursementService(int userId) throws ApplicationException;

	// create endpoint to take userId & return all the resolved
	List<ReimbursementPojo> getAUserResolvedReimbursementService(int userId) throws ApplicationException;

	List<ReimbursementPojo> getAllResolvedReimbursementService() throws ApplicationException;

	List<ReimbursementPojo> getAllPendingReimbursementService() throws ApplicationException;

	void exitApplication();

}

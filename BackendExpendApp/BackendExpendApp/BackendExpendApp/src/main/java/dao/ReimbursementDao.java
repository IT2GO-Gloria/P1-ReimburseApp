package dao;

import java.util.List;

import exception.ApplicationException;
import pojo.ReimbursementPojo;

public interface ReimbursementDao {

	ReimbursementPojo createReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	ReimbursementPojo updateReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	boolean deleteReimbursement(int reimbursementId) throws ApplicationException;
	ReimbursementPojo getAReimbursement(int reimbursementId) throws ApplicationException;

	// creates EndPoint, takes userId & return all reimbursement for this user
	List<ReimbursementPojo> getAUserReimbursement(int userId) throws ApplicationException;
	
	// creates EndPoint, takes userId & return all pending reimbursements
	List<ReimbursementPojo> getAUserPendingReimbursement(int userId) throws ApplicationException;

	// creates EndPoint, takes userId & return all the resolved
	List<ReimbursementPojo> getAUserResolvedReimbursement(int userId) throws ApplicationException;

	List<ReimbursementPojo> getAllResolvedReimbursement() throws ApplicationException;

	List<ReimbursementPojo> getAllPendingReimbursement() throws ApplicationException;

	List<ReimbursementPojo> getAllReimbursements() throws ApplicationException;

	void exitApplication();

}

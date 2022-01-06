package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import exception.ApplicationException;
import pojo.ReimbursementPojo;

public class ReimbursementServiceImpl implements ReimbursementService {

	private static final Logger logger = LogManager.getLogger(ReimbursementServiceImpl.class);

	ReimbursementDao reimbursementDao;

	// Constructor
	public ReimbursementServiceImpl() {
		this.reimbursementDao = new ReimbursementDaoImpl();
	}

	@Override
	public ReimbursementPojo createReimbursementService(ReimbursementPojo reimbursementPojo)
			throws ApplicationException {

		logger.info("Entered createReimbursementService() located in service Layer");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.createReimbursement(reimbursementPojo);
		logger.info("Left createReimbursementService()  located in service Layer");
		return returnReimbursementPojo;
	}

	@Override
	public ReimbursementPojo updateReimbursementService(ReimbursementPojo reimbursementPojo)
			throws ApplicationException {
		logger.info("Entered  updateReimbursementService() located in service Layer");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.updateReimbursement(reimbursementPojo);

		logger.info("Left updateReimbursementService() located in service Layer");
		return returnReimbursementPojo;
	}

	@Override
	public boolean deleteReimbursementService(int reimbursementId) throws ApplicationException {
		logger.info("Entered  deleteReimbursementService() located in service Layer");
		boolean returnReimbursementPojo = this.reimbursementDao.deleteReimbursement(reimbursementId);
		logger.info("Left  deleteReimbursementService() located in service Layer");
		return returnReimbursementPojo;
	}

	@Override
	public ReimbursementPojo retrieveAReimbursementService(int reimbursementId) throws ApplicationException {
		logger.info("Entered  retrieveReimbursementService() located in service Layer");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.getAReimbursement(reimbursementId);
		logger.info("Left retrieveReimbursementService()  located in service Layer");
		return returnReimbursementPojo;
	}

	@Override
	public List<ReimbursementPojo> retrieveAllReimbursementsService() throws ApplicationException {
		logger.info("Entered retrieveAllReimbursementService() located in service Layer");
		List<ReimbursementPojo> allReimbursement = this.reimbursementDao.getAllReimbursements();
		logger.info("Left retrieveAllReimbursementService()  located in service Layer");
		return allReimbursement;
	}

	@Override
	public List<ReimbursementPojo> getAUserReimbursementService(int userId) throws ApplicationException {
		logger.info("Entered getAUserReimbursementService() located in service Layer");
		List<ReimbursementPojo> returnGetAUserReim = this.reimbursementDao.getAUserReimbursement(userId);
		logger.info("Left getAUserReimbursementService() located in service Layer");
		return returnGetAUserReim;
	}

	@Override
	public List<ReimbursementPojo> getAUserPendingReimbursementService(int userId) throws ApplicationException {
		logger.info("Entered getAUserPendingReimbursementService() located in service Layer");
		List<ReimbursementPojo> returnGetAUserReim = this.reimbursementDao.getAUserPendingReimbursement(userId);
		logger.info("Left getAUserPendingReimbursementService() located in service Layer");
		return returnGetAUserReim;
	}

	@Override
	public List<ReimbursementPojo> getAUserResolvedReimbursementService(int userId) throws ApplicationException {
		logger.info("Entered getAResolvedUserReimbursementService() located in service Layer");
		List<ReimbursementPojo> returnGetAUserReim = this.reimbursementDao.getAUserResolvedReimbursement(userId);
		logger.info("Left getAResolvedUserReimbursementService() located in service Layer");
		return returnGetAUserReim;
	}

	@Override
	public List<ReimbursementPojo> getAllResolvedReimbursementService() throws ApplicationException {
		logger.info("Entered getAllResolvedReimbursementService() located in service Layer");
		List<ReimbursementPojo> returnGetAUserReim = this.reimbursementDao.getAllResolvedReimbursement();
		logger.info("Left getAllResolvedReimbursementService() located in service Layer");
		return returnGetAUserReim;
	}

	@Override
	public List<ReimbursementPojo> getAllPendingReimbursementService() throws ApplicationException {
		logger.info("Entered getAllPendingResolvedReimbursementService() located in service Layer");
		List<ReimbursementPojo> returnGetAUserReim = this.reimbursementDao.getAllPendingReimbursement();
		logger.info("Left getAllPendingReimbursementService() located in service Layer");
		return returnGetAUserReim;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() located in service.");
		reimbursementDao.exitApplication();
		logger.info("Exited exitApplication()  located in service.");
	}

}

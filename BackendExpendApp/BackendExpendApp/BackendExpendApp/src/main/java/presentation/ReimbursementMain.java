package presentation;

import java.util.List;

import exception.ApplicationException;
import io.javalin.Javalin;
import pojo.ErrorPojo;
import pojo.ReimbursementPojo;
import pojo.UserPojo;
import service.UserService;
import service.UserServiceImpl;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;

public class ReimbursementMain {

	ErrorPojo error = new ErrorPojo();

	public static void main(String[] args) {

		ReimbursementService reimbursementService = new ReimbursementServiceImpl();
		UserService authUserService = new UserServiceImpl();

		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(4041);
		
		
		server.get("/", ctx -> ctx.result(" Endpoints Requested"));

		
//API ENDPOINTS
		// http://localhost:4041/api/reimbursements
		server.get("api/reimbursements", (ctx) -> {
			System.out.println("hello");
			ctx.json(reimbursementService.retrieveAllReimbursementsService());
			
		});

		//  Get EndPoint - fetch 1 reimbursement
		// http://localhost:4041/api/reimbursements/
		server.get("api/reimbursements/{rid}", (ctx) -> {
			ctx.json(reimbursementService.retrieveAReimbursementService(Integer.parseInt(ctx.pathParam("rid"))));
		});

		// EndPoint To delete reimbursement
		// http://localhost:4041/api/reimbursements/
		server.delete("api/reimbursements/{rid}", (ctx) -> {
			reimbursementService.deleteReimbursementService(Integer.parseInt(ctx.pathParam("rid")));
		});

		// Post EndPoint
		// http://localhost:4041/api//reimbursements
		server.post("api/reimbursements", (ctx) -> {
			ReimbursementPojo returnReimbPojo = reimbursementService
					.createReimbursementService(ctx.bodyAsClass(ReimbursementPojo.class));
			ctx.json(returnReimbPojo);
		});

		// Update (Put) EndPoint 
		// http://localhost:4041/api/reimbursements/5
		server.put("api/reimbursements/{rid}", (ctx) -> {
			ReimbursementPojo returnReimbPojo = reimbursementService
					.updateReimbursementService(ctx.bodyAsClass(ReimbursementPojo.class));
			ctx.json(returnReimbPojo);
		});

		// http://localhost:4041/api/reimbursementsresolved

		server.get("api/reimbursementsresolved", (ctx) -> {
			ctx.json(reimbursementService.getAllResolvedReimbursementService());
		});

		// Pending EndPoint
		// http://localhost:4041/api/reimbursementspending
		server.get("api/reimbursementspending", (ctx) -> {
			ctx.json(reimbursementService.getAllPendingReimbursementService());
		});

		// For returning a reimb based on user_id
		// http://localhost:4041/api/reimbursementsuser/
		server.get("api/reimbursementsuser/{rid}", (ctx) -> {
			ctx.json(reimbursementService.getAUserReimbursementService(Integer.parseInt(ctx.pathParam("rid"))));
		});

		// For returning a Pending reimb based on user_id
		// http://localhost:4041/api/reimbursementspending/
		server.get("api/reimbursementspending/{rid}", (ctx) -> {
			ctx.json(reimbursementService.getAUserPendingReimbursementService(Integer.parseInt(ctx.pathParam("rid"))));
		});

		// For returning a Resolved reimb based on user_id
		// http://localhost:4041/api/reimbursementsresolved/
		server.get("api/reimbursementsresolved/{rid}", (ctx) -> {
			ctx.json(reimbursementService.getAUserResolvedReimbursementService(Integer.parseInt(ctx.pathParam("rid"))));
		});
		
		//  Post EndPoint
		// http://localhost:4041/api/registerusers
		server.post("api/validateusers", (ctx) -> {
			UserPojo returnUserInfoPojo = authUserService.validateUser(ctx.bodyAsClass(UserPojo.class));
			ctx.json(returnUserInfoPojo);
		});

		// Get EndPoint - 1 User
		// http://localhost:4041/api/registerusers/2
		server.get("api/registerusers/{uid}", (ctx) -> {
			ctx.json(authUserService.retrieveAUser(Integer.parseInt(ctx.pathParam("uid"))));
		});

		// Get EndPoint - All Users
		// http://localhost:4041/api/registerusers
		server.get("api/registerusers", (ctx) -> {
			ctx.json(authUserService.retrieveAllUsers());
		});

		// Get EndPoint -Update User
		// http://localhost:4041/api/registerusers
		server.put("api/registerusers/{uid}", (ctx) -> {
			UserPojo returnUserInformationPojo = authUserService.updateUser(ctx.bodyAsClass(UserPojo.class));
			ctx.json(returnUserInformationPojo);
		});

		// Get EndPoint - Delete
		// http://localhost:4041/api/registerusers
		server.delete("api/registerusers/{uid}", (ctx) -> {
			authUserService.deleteUser(Integer.parseInt(ctx.pathParam("uid")));
		});

		server.exception(ApplicationException.class, (ae, ctx) -> {
			ErrorPojo error = new ErrorPojo();
			error.setErrorMessage(ae.getMessage());
			ctx.json(error).status(500);
		});

	}

}

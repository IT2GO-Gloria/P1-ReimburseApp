package pojo;

import java.util.Date;

public class ReimbursementPojo {

	private int reimbId;
	private Date reimbDate;
	private String reimbReason;
	private float reimbAmount;
	private String reimbStatus;
	boolean reimbRemoved;
	

	public ReimbursementPojo() {
		super();
	}

	public ReimbursementPojo(int reimbId, Date reimbDate, String reimbReason, float reimbAmount, String reimbStatus,
			boolean reimbRemoved) {
		super();
		this.reimbId = reimbId;
		this.reimbDate = reimbDate;
		this.reimbReason = reimbReason;
		this.reimbAmount = reimbAmount;
		this.reimbStatus = reimbStatus;
		this.reimbRemoved = reimbRemoved;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public Date getReimbDate() {
		return reimbDate;
	}

	public void setReimbDate(Date reimbDate) {
		this.reimbDate = reimbDate;
	}

	public String getReimbReason() {
		return reimbReason;
	}

	public void setReimbReason(String reimbReason) {
		this.reimbReason = reimbReason;
	}

	public float getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(float reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public boolean isReimbRemoved() {
		return reimbRemoved;
	}

	public void setReimbRemoved(boolean reimbRemoved) {
		this.reimbRemoved = reimbRemoved;
	}

	@Override
	public String toString() {
		return "ReimbursementPojo [reimbId=" + reimbId + ", reimbDate=" + reimbDate + ", reimbReason=" + reimbReason
				+ ", reimbAmount=" + reimbAmount + ", reimbStatus=" + reimbStatus + ", reimbRemoved=" + reimbRemoved
				+ "]";
	}

}

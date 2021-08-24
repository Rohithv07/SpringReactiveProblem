package com.example.model;


import org.springframework.data.annotation.Id;


public class Loan {

	@Id
	private Integer loanId;

	private String loanType;

	private Integer amount;

	private Integer duration;

	private Integer rateOfInterest;

	private String loanDate;

	private Integer accId;

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(Integer loanId, String loanType, Integer amount, Integer duration, Integer rateOfInterest,
			String loanDate, Integer accId) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.amount = amount;
		this.duration = duration;
		this.rateOfInterest = rateOfInterest;
		this.loanDate = loanDate;
		this.accId = accId;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanType=" + loanType + ", amount=" + amount + ", duration=" + duration
				+ ", rateOfInterest=" + rateOfInterest + ", loanDate=" + loanDate + ", accId=" + accId + "]";
	}

	public Integer getAccId() {
		return accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Integer rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

}

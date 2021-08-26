package com.example.model;

import org.springframework.data.annotation.Id;

/**
 * The model class for Loan
 * 
 * @author groupd 5
 *
 */
public class Loan {

	/**
	 * Primary key for the loan
	 */
	@Id
	private Integer loanId;

	/**
	 * This field holds the information about loan type
	 */
	private String loanType;

	/**
	 * This field holds the information about amaount;
	 */
	private Integer amount;

	/**
	 * This field holds the information about the duration of loan
	 */
	private Integer duration;

	/**
	 * This field holds the information about the rate of interest
	 */
	private Integer rateOfInterest;

	/**
	 * This field holds the information about the local date
	 */
	private String loanDate;

	/**
	 * This field holds the information about the account id which is a foreign key
	 */
	private Integer accId;

	/**
	 * No argument constructor
	 */
	public Loan() {
		super();
	}

	/**
	 * All argument constructor
	 * @param loanId
	 * @param loanType
	 * @param amount
	 * @param duration
	 * @param rateOfInterest
	 * @param loanDate
	 * @param accId
	 */
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

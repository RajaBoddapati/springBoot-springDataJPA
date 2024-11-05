package com.prac.springDataJpa.dtos;

import java.util.Objects;

public class CustomerDTO {

	
	private int cId;
	private String cName;
	private Long accountNum;
	private String branch;
	private Double balance;
	private Double loanAmount;
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountNum, balance, branch, cId, cName, loanAmount);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(accountNum, other.accountNum) && Objects.equals(balance, other.balance)
				&& Objects.equals(branch, other.branch) && cId == other.cId && Objects.equals(cName, other.cName)
				&& Objects.equals(loanAmount, other.loanAmount);
	}
	@Override
	public String toString() {
		return "CustomerDTO [cId=" + cId + ", cName=" + cName + ", accountNum=" + accountNum + ", branch=" + branch
				+ ", balance=" + balance + ", loanAmount=" + loanAmount + "]";
	}
	
	
	
}

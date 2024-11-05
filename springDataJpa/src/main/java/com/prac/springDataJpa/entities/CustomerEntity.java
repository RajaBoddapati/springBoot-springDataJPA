package com.prac.springDataJpa.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

@Entity
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "cId-pkgen")
	@TableGenerator(name="cId-pkgen",table="cId-pkgen-table",pkColumnName = "pk-col",valueColumnName = "val-col",pkColumnValue = "pk-val",allocationSize = 1)
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
		CustomerEntity other = (CustomerEntity) obj;
		return Objects.equals(accountNum, other.accountNum) && Objects.equals(balance, other.balance)
				&& Objects.equals(branch, other.branch) && cId == other.cId && Objects.equals(cName, other.cName)
				&& Objects.equals(loanAmount, other.loanAmount);
	}
	@Override
	public String toString() {
		return "CustomerEntity [cId=" + cId + ", cName=" + cName + ", accountNum=" + accountNum + ", branch=" + branch
				+ ", balance=" + balance + ", loanAmount=" + loanAmount + "]";
	}
	
	
}

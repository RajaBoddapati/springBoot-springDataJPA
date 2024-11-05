package com.prac.springDataJpa.entities;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;

@Entity
@NamedQuery(name="EmployeeOfCompanyEntity.findEmpsByJoiningDate",
query="select e from EmployeeOfCompanyEntity e where e.joinedDate=:date")
public class EmployeeOfCompanyEntity {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
    //@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq-gen")
    //@SequenceGenerator(name="seq-gen" sequenceName="my-sequence",allocationSize = 3)
	
	@GeneratedValue(strategy=GenerationType.TABLE,generator="pkgen")
	@TableGenerator(name="pkgen",table="my-table",pkColumnName = "pk-col",valueColumnName = "val-col",pkColumnValue = "pk-value",allocationSize =1)
	private int eId;
	private String eName;
	private Long eSalary;
	private String location;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate joinedDate;
	
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public Long geteSalary() {
		return eSalary;
	}
	public void seteSalary(Long eSalary) {
		this.eSalary = eSalary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public LocalDate getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(eId, eName, eSalary, joinedDate, location);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeOfCompanyEntity other = (EmployeeOfCompanyEntity) obj;
		return eId == other.eId && Objects.equals(eName, other.eName) && Objects.equals(eSalary, other.eSalary)
				&& Objects.equals(joinedDate, other.joinedDate) && Objects.equals(location, other.location);
	}
	@Override
	public String toString() {
		return "EmployeeOfCompanyEntity [eId=" + eId + ", eName=" + eName + ", eSalary=" + eSalary + ", location="
				+ location + ", joinedDate=" + joinedDate + "]";
	}
	
	
	
    
}

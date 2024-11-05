package com.prac.springDataJpa.dtos;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeOfCompanyDTO {
	
	
	private int eId;
	private String eName;
	private Long eSalary;
	private String location;
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
		EmployeeOfCompanyDTO other = (EmployeeOfCompanyDTO) obj;
		return eId == other.eId && Objects.equals(eName, other.eName) && Objects.equals(eSalary, other.eSalary)
				&& Objects.equals(joinedDate, other.joinedDate) && Objects.equals(location, other.location);
	}
	@Override
	public String toString() {
		return "EmployeeOfCompanyDTO [eId=" + eId + ", eName=" + eName + ", eSalary=" + eSalary + ", location="
				+ location + ", joinedDate=" + joinedDate + "]";
	}
	
	
	
	
	
    
}


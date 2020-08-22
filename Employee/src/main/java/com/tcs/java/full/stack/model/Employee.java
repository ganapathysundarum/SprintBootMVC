package com.tcs.java.full.stack.model;

public class Employee {

	private String empId;
	private String empFName;
	private String empMName;
	private String empLName;
	private String empDOB;
	private String empSex;
	private String empDOJ;
	private String empStatus;
	private String empBaseBranch;
	private String empLocation;
	private String lastUpdateDate;
	private String lastUpdateUser;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpFName() {
		return empFName;
	}
	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}
	public String getEmpMName() {
		return empMName;
	}
	public void setEmpMName(String empMName) {
		this.empMName = empMName;
	}
	public String getEmpLName() {
		return empLName;
	}
	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}
	public String getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public String getEmpDOJ() {
		return empDOJ;
	}
	public void setEmpDOJ(String empDOJ) {
		this.empDOJ = empDOJ;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public String getEmpBaseBranch() {
		return empBaseBranch;
	}
	public void setEmpBaseBranch(String empBaseBranch) {
		this.empBaseBranch = empBaseBranch;
	}
	public String getEmpLocation() {
		return empLocation;
	}
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	@Override
	public String toString() {
		return "EmployeeModel [empId=" + empId + ", empFName=" + empFName + ", empMName=" + empMName + ", empLName="
				+ empLName + ", empDOB=" + empDOB + ", empSex=" + empSex + ", empDOJ=" + empDOJ + ", empStatus="
				+ empStatus + ", empBaseBranch=" + empBaseBranch + ", empLocation=" + empLocation + ", lastUpdateDate="
				+ lastUpdateDate + ", lastUpdateUser=" + lastUpdateUser + "]";
	}
	
	
	
}

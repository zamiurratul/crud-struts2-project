package com.zamiurratul.struts.ems.action;

import java.sql.Date;
import java.util.Calendar;

import com.opensymphony.xwork2.ActionSupport;
import com.zamiurratul.struts.ems.dao.SystemDao;

public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = -8233034294391040976L;

	private SystemDao systemDao;

	private String employeeId;
	private String fullName;
	private String designation;
	private String email;
	private String contactNo;
	private Date joiningDate;
	int ctr = 0;
	String msg = "";

	@Override
	public String execute() throws Exception {
		if (employeeId == null || employeeId.isEmpty()) {
			System.out.println("NO DATA :: REGISTER :: RETURN");
			return "REGISTER";
		}
		systemDao = new SystemDao();
		Calendar calendar = Calendar.getInstance();
		joiningDate = new Date(calendar.getTimeInMillis());
		try {
			Long empId = Long.parseLong(employeeId);
			ctr = systemDao.registerEmployee(empId, fullName, email, contactNo, designation, joiningDate);
			if (ctr > 0) {
				msg = "Success";
			} else {
				msg = "Failed";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "REGISTER";
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}

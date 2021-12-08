<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Struts2 and MySQL database connectivity</title>
</head>
<body style="background-color: lightyellow;">
	<div style="margin-left: 25%; margin-top: 50px;">
		<h1>Struts2 and MySQL database connectivity example</h1>
		 <s:form action="register.action">
			<s:textfield label="EmployeeId" name="employeeId" />
			<s:textfield label="FullName" name="fullName" />
			<s:textfield label="Email" name="email" />
			<s:textfield label="ContactNo" name="contactNo" />
			<s:textfield label="Designation" name="designation" />
			<%-- <s:datetextfield format="yyyy-dd-MM" label="Joining Date" name="joiningDate" /> --%>
			<s:submit value="Register" />
		</s:form>
</div>
</body>
</html>
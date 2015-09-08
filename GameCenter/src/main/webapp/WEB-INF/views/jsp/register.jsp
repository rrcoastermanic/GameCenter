<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="registerForm">
<form:form method="post" modelAttribute="registerForm" action="/GameCenter/register">

	<form:errors/>
	<spring:bind path="username">
		<label>Username:</label>
		<form:input path="username" type="text" class="form-control" placeholder="username"/>
		<form:errors path="username"/>
	</spring:bind>
	
	
	<spring:bind path="password">
		<label>Password:</label>
		<form:input path="password" type="password" class="form-control" placeholder="password"/>
		<form:errors path="password"/>
	</spring:bind>
	
	<spring:bind path="confirmPassword">
		<label>Confirm Password:</label>
		<form:input path="confirmPassword" type="password" class="form-control" placeholder="password"/>
		<form:errors path="confirmPassword"/>
	</spring:bind>
	
	<spring:bind path="email">
		<label>E-Mail:</label>
		<form:input path="email" type="text" class="form-control" placeholder="password"/>
		<form:errors path="email"/>
	</spring:bind>
	
	<input type="submit" value="register"/>

</form:form>


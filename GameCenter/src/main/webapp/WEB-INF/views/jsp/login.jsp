<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<form:form method="post" modelAttribute="loginForm" action="/GameCenter/login">
		<form:errors/>
		<spring:bind path="username">
			<label>Username:</label>
			<form:input path="username" type="text" class="form-control" id="username" placeholder="username"/>
			<form:errors path="username"/>
		</spring:bind>
		
		<spring:bind path="password">
			<label>password</label>
			<form:input path="password" type="password" class="form-control" id="password" placeholder="password"/>
			<form:errors path="password"/>
		</spring:bind>
		
		<input type="submit" value="Login"/>
	</form:form>
</div>
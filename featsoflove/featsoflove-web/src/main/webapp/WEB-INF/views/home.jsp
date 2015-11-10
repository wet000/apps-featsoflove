<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<jsp:include page="head.jsp" />
	</head>
	<body>
		<jsp:include page="header.jsp" />
		<div id="front-cover" class="front-cover-image box-shadow-bottom">
			<div id="front-cover-text" class="fixed-width white serif">
				<p id="front-cover-p1" class="l40 text-shadow-dark1">Coming Soon!</p>
				<p id="front-cover-p2" class="l15 w1 text-shadow-dark3">Creating Solutions to Fight Chronic Diseases</p>
				<p class="l25 text-shadow-dark2">Be Part of the Solution</p>
				<form:form method="post">
					<input type="text" name="email" value="Enter Your Email"/>
    				<form:errors path="email" cssclass="unsuccessful-message"></form:errors>
					
					<input type="submit" value="Find Out How"/>
					<input type="hidden" name="formId" value="11"/>
					
					
				</form:form>
				<p>Locale:  ${pageContext.response.locale}</p>
				<p>Title: <spring:message code="featsoflove.title"/></p>
				<!-- <p class="${messageClass}">${message}</p>-->
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</body>
</html>
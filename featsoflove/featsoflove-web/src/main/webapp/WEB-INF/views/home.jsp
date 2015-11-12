<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				<form:form commandName="subscriber" method="post">
					<form:input path="email"/>
					<form:hidden path="formId" value="11"/>
					<input type="submit" value="Find Out How"/>
					<p><form:errors class="unsuccessful-message" path="email"></form:errors></p>					
				</form:form>
				<c:if test="${subscriber.active}">
					<p class="successful-message"><spring:message code="success.message"/></p>
				</c:if>
				<p class="unsuccessful-message">${exceptionMessage}</p>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</body>
</html>
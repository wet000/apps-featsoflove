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
		
		<div id="front-cover-banner" class="front-cover-image box-shadow-bottom">
			<div id="front-cover" class="fixed-width white">
				<div id="front-cover-text" class="serif">
					<p id="front-cover-p1" class="l40 text-shadow-dark1">Coming Soon!</p>
					<p id="front-cover-p2" class="l15 w1 text-shadow-dark3">Creating Solutions to Fight Chronic Diseases</p>
					<p class="l25 text-shadow-dark2">Be Part of the Solution</p>
				</div>
				<div id="optin-form" class="sans-serif">
					<form:form commandName="subscriber" method="post">
						<form:input id="optin-email" 
							class="standard-input l14 g6" 
							path="email" 
							value="Enter Your Email" 
							onkeydown="if (this.value == 'Enter Your Email') {this.value = ''; this.style.color = '#606060';}" 
							onblur="if (this.value == '') {this.value = 'Enter Your Email';}" 
							onfocus="if (this.value == 'Enter Your Email') {this.style.color = '#c0c0c0'; document.getElementById('optin-email').setSelectionRange(0,0);}"
						/>
						<form:hidden path="formId" value="1"/>
						<input class="standard-submit l14 white" type="submit" value="Find Out How"/>
							<form:errors element="div" class="error optin-message l12" path="email"></form:errors>
							<c:if test="${subscriber.active}">
								<div class="success optin-message l12" ><spring:message code="success.message"/></div>
							</c:if>
							<c:if test="${not empty message}">
								<div class="error optin-message l12">${message}</div>
							</c:if>
					</form:form>
				</div>
			</div>
		</div>
		
		<jsp:include page="footer.jsp" />
	</body>
</html>
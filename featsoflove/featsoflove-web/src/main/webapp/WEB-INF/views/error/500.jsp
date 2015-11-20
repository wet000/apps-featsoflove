<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<jsp:include page="../head.jsp" />
	</head>
	<body>
		<jsp:include page="../header.jsp" />
		<div id="front-cover" class="front-cover-image box-shadow-bottom">
			<div id="front-cover-text" class="fixed-width white serif">
				<p id="front-cover-p2" class="l25 text-shadow-dark2">Sorry, a server error occurred on our end!</p>
				<p class="l15 w1 text-shadow-dark3">${message}</p>
			</div>
		</div>
		<jsp:include page="../footer.jsp" />
	</body>
</html>
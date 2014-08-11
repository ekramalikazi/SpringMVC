<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Messages</title>
	</head>
	<body>
		<h1>Message List</h1>
		<ul>
			<c:forEach var="message" items="${messages}">
				<li>
					Message: ${message.id} - ${message.content}
                </li>
			</c:forEach>
		</ul>
	</body>
</html>
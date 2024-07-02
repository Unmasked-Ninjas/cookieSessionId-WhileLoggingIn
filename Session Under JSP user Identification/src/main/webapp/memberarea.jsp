<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member area</title>
</head>
<body>
Hello this is member area

<%
String username = null;
String sessionid = null;

Cookie[] cookies = request.getCookies();
if(cookies!= null ){
	for(Cookie cookie: cookies){
		if(cookie.getName().equals("username")){
			username	= cookie.getValue();
		}
		if(cookie.getName().equals("JSESSIONID")){
			sessionid = cookie.getValue();
		}
	}
}
if(sessionid == null || username == null){
	response.sendRedirect("login.jsp");
}

%>
Username: <%= username %>
<br/>

SessionID: <%= sessionid %>


</body>
</html>
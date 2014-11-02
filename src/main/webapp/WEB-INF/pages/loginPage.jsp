<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login to SuperUser</title>
    <link rel="stylesheet" href="<c:url value='/styles/loginPage.css'></c:url>"/>

</head>
<body>
<h2>Custom Form based Login Page 2</h2>


<form name='loginForm' action="<c:url value='/j_spring_security_check'></c:url>" method='POST'>

    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>

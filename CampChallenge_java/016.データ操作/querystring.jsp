<%-- 
    Document   : querystring
    Created on : 2017/09/06, 15:52:46
    Author     : karimatayuuta2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./querystringtra.jsp" method="post">
            総額:    <input type="text" name="total">
            個数:    <input type="text" name="count">
            商品種別: <input type="text" name="type">
            
            送信: <input type="submit" name="btnSubmit">
        </form>
    </body>
</html>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>      
        
        <form action="./Data01rec.jsp" method="post">
            名前: <input type="text" name="name">
            性別: <input type="radio" name="gender">
            送信: <input type="submit" name="btnSubmit">
            
            趣味: <textarea name="hobbyText"></textarea>
        </form>

        
    </body>
</html>

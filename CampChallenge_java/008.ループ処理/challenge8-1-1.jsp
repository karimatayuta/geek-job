

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            long total = 1;
            for (long i = 1; i <= 20; i++) {
            total=total*8;
            out.print(i + "回目" + total + "<br>");
            
            }
        %>





    </body>
</html>

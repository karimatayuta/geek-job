<%-- 
    Document   : challenge3-1.jsp
    Created on : 2017/08/04, 13:38:22
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
        
        <%
            int num1 = 10;
            int num2 = 20;
            int num3 = 30;
            int num4 = 40;
            
            out.print(++num1);
            out.print(num2++);
            out.print(--num3);
            out.print(num4--);
            %>
        
        
    </body>
</html>

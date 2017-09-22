

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            String text="A";
            for (int i=1;i<=30;i++){
                text= text+ "A";
            }
            out.print(text);
            %>
            
            
    </body>
</html>

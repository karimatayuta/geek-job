

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import ="java.util.ArrayList"%>
        <%
            ArrayList <String> datas = new ArrayList <String>();
            datas.add("10");
            datas.add("100");
            datas.add("soeda");
            datas.add("hayashi");
            datas.add("-20");
            datas.add("118");
            datas.add("END");
            
            datas.set(2, "33");
            
            out.print(datas.get(0) + "<br>");
            out.print(datas.get(1) + "<br>");
            out.print(datas.get(2) + "<br>");
            out.print(datas.get(3) + "<br>");
            out.print(datas.get(4) + "<br>");
            out.print(datas.get(5) + "<br>");
            out.print(datas.get(6) + "<br>");
            %>
            
    </body>
</html>

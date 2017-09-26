<%-- 
    Document   : Data01
    Created on : 2017/09/06, 14:00:34
    Author     : karimatayuuta2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ope data</title>
    </head>
    <body>
        <%
            //文字コード指定
            request.setCharacterEncoding("UTF-8");
            
            //情報取り出し表示
            out.print("名前:" + request.getParameter("name") + "<br>");
            out.print("性別:" + request.getParameter("gender") + "<br>");
            out.print("趣味:" + request.getParameter("hobbyText") + "<br>");

        %>
    </body>
</html>

<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% if (!udb.getName().equals("")
                    && !udb.getYear().equals("")
                    && !udb.getMonth().equals("")
                    && !udb.getDay().equals("")
                    && !udb.getType().equals("")
                    && !udb.getTell().equals("")
                    && !udb.getComment().equals("")
                    && udb.getComment().length()!=0
                    &&  udb.getComment()!=null) {%>
        <h1>登録確認</h1>
        <% boolean abc = udb.getComment().isEmpty();
            out.print(abc);%>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type = "hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <% } else { %>
        <h1>入力が不完全です</h1>
        <%if (udb.getName().equals("")) {%>
       　　　名前が未入力です。
        <%}%>
        <% if (udb.getYear().equals("") && udb.getMonth().equals("") && udb.getDay().equals("")) {%>
        生年月日が未入力です。 
        <% } %>
        <% if (udb.getType().equals("")) {%>
        種別が未入力です。
        <% } %> 
        <% if (udb.getTell().equals("")) {%>
        電話番号が未入力です。
        <% } %> 
        <%if (udb.getComment().equals("")) {%>
        コメントが未入力です。
        <% }
           }%>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <%=JumsHelper.getInstance().home()%>

    </body>
</html>

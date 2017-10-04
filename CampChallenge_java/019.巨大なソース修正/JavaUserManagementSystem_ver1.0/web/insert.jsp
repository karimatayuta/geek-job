
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
        <title>JUMS登録画面</title>
    </head>
    <body>
        <form action="insertconfirm" method="POST">
            名前:
            <input type="text" name="name" value="<%if (udb != null) {%><%=udb.getName()%><%}%>">

            <br><br>

            生年月日:　
            <select name="year">
                <option value="">----</option>
                <%
                    for (int i = 1950; i <= 2010; i++) {
                        String y = String.valueOf(i);  //数値を文字列に型変換
%>
                <option value="<%=i%>"
                        <%if (udb != null && udb.getYear().equals(y)) {%>
                        <%=Integer.parseInt(udb.getYear())%> selected <% }%>><%=i%></option>
                <% } %>


            </select>年
            <select name="month">
                <option value="">--</option>
                <%
                    for (int i = 1; i <= 12; i++) {
                        String m = String.valueOf(i);
                %>
                <option value="<%=i%>"
                        <%if (udb != null && udb.getMonth().equals(m)) {%>
                        <%=Integer.parseInt(udb.getMonth())%> selected <%}%>><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <option value="">--</option>
                <%
                    for (int i = 1; i <= 31; i++) {
                        String x = String.valueOf(i);
                %>
                <option value="<%=i%>" 
                    <%if (udb != null && udb.getDay().equals(x)) {%>
                    <%=Integer.parseInt(udb.getDay())%> selected <%}%>><%=i%></option>
                    <% }%>
            </select>日
            <br><br>

            種別:
            <br>
            <input type="radio" name="type" value="1"<%if (udb != null && udb.getType().equals("1")) { %>checked<%}%>>エンジニア<br>
            <input type="radio" name="type" value="2"<%if (udb != null && udb.getType().equals("2")) { %>checked<%}%>>営業<br>
            <input type="radio" name="type" value="3"<%if (udb != null && udb.getType().equals("3")) { %>checked<%}%>>その他<br>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%if (udb != null) {%><%=udb.getTell()%><%}%>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%
                if (udb != null) {%><%=udb.getComment()%><%}%></textarea><br><br>

            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>

        <%=JumsHelper.getInstance().home()%>


    </body>
</html>

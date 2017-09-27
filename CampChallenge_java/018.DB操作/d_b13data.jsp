

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品登録、商品一覧画面</title>
    </head>
    <body>
        <form action ="d_b13reg" method="post">
            商品登録するものを入力してください<br>
            商品登録<br>
            商品名<input type ="text" name ="reg"><br>
            価格<input type="text" name="money"><br>
            個数<select name="sum">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            </select><br>
            <input type="submit" name="btnSubmit"><br>
            
        </form>
        <form action="d_b13dis" name="dis"><br>
            商品一覧を表示します<br>
            <input type="submit" name="btnSubmit"><br>
        </form>
        <br><br>
        <form action = "d_b13html.jsp" method = "post">
        <input type="submit" name="btnSubmit" value="ログアウト">    
        </form>
    </body>
</html>

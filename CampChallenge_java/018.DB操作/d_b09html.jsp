

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>d_b09送信用</title>
    </head>
    <body>
        <form action ="./d_b09" method ="post">

            更新するデータを入力してください<br>
            ID<br>
            <input type = "text" name = "id"><br>

            名前<br>
            <input type= "text" name = "name"><br>

            電話番号<br>
            <input type = "text" name = "tel"><br>

            年齢<br>
            <input type = "text" name = "age"><br>

            誕生日<br>
            <input type = "text" name = "birthday"><br><br>

            <input type = "submit" name = "btnSubmit" value = "追加送信">

      　</form>  
    </body>
</html>

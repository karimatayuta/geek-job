<%-- 
    Document   : querystringtra
    Created on : 2017/09/06, 16:47:56
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
            //文字コード指定
            request.setCharacterEncoding("UTF-8");
            
            //情報取り出し表示
            out.print("総額:"    + request.getParameter("total") + "<br>");
            out.print("個数:"    + request.getParameter("count") + "<br>");
            out.print("商品種別が" + request.getParameter("type")  +"であるので"+ "<br>");
            int i = Integer.parseInt(request.getParameter("type"));
            
            //受け取った商品種別によって、表示を変える。
            if(i==1){
            out.println("雑貨" + "<br>");
            }else if(i==2){
            out.println("生鮮食品" + "<br>");
            }else if(i==3){
            out.println("その他" + "<br>");
            } //ok
            
            //受け取った総額からと個数から１個あたりの値段を計算し表示する。
            int k = Integer.parseInt(request.getParameter("total"));
            int j = Integer.parseInt(request.getParameter("count"));

            int p = k/j;
            
            out.println("受け取った総額が" + k + "円で個数が" + j + 
                    "個で１個あたりの値段が" + p + "円です。" +"<br>");//ok
            
            //総額に応じてポイントがつく。ポイントを計算し、表示する。
            
            int m = Integer.parseInt(request.getParameter("total"));
            if(3000<=m&&m<5000){
                double q = m*0.04;
                out.print("3000円以上お買い上げなので、" + q + "ポイント付与します" + "<br>");
            }else if(5000<=m){
                double e = m*0.05;
                out.print("5000円以上お買い上げなので、" + e + "ポイント付与します" + "<br>");
            }//質問：総額5000円以上にして入力しても、3000円以上のとでてしまう。
            //答え：3000円以上5000円未満の論理演算子の使い方を間違えた。またはではなくカツにする。
            //ok
        %>   
    </body>
</html>

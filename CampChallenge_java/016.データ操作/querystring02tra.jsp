<%-- 
    Document   : querystring02tra
    Created on : 2017/09/07, 11:47:23
    Author     : karimatayuuta2
--%>
<%@page import="java.util.ArrayList"%>
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
            

           // int l = Integer.parseInt(request.getParameter("suuchi"));
            
              /*  if (l < 2) {
                    out.println("1以下の数が入力されました。" + "<br>");
                } else if (l == 2) {
                    out.println(l + "は素数です。" + "<br>");
                } else {
                    boolean isSosuu = true;
                    for (int i = 2; i <= l - 1; i++) {
                        if (l % i == 0) {
                            // 割り切れた場合は素数ではない
                            isSosuu = false;
                            break;
                        }
                    }
                    if (isSosuu) {
                        out.println(l + "は素数です。" + "<br>");
                    } else {
                        out.println(l + "は素数ではありません。" + "<br>");
                    }
               */
             /* int num[] ={1,2,3,5,7};
                for(int i=1;i<=num.length;i++){
                    if(l%num[i]==0){
                        int k =l%num[i];
                        out.print("元の値は" + l + "一桁の素因数分解は" + k );//素因数分解できた解。
                    }else if(l%num[i]!=0){
                        int f = l%num[i];
                        
                        out.print("元の値は" + l );
                    }
                    
                }*/
                String g = request.getParameter("num");
            int n = Integer.parseInt(g);
            int dn = n;
            
            //表示 + 処理
            out.print(n + "の素因数は ");
            while(dn > 1){
                if(dn % 2 == 0){
                    out.print("2, ");
                    dn /= 2;
                }else if(dn % 3 == 0){
                    out.print("3, ");
                    dn /= 3;
                }else if(dn % 5 == 0){
                    out.print("5, ");
                    dn /= 5;
                }else if(dn % 7 == 0){
                    out.print("7, ");
                    dn /= 7;
                }else{
                    out.print("余りは" + dn);
                    break;
                }
            }
            
            out.print(" です。");


        %>
    </body>
</html>

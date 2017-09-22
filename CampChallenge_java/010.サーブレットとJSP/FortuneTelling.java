
package org.camp.servret;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import org.mypackage.sample.ResultData;


public class FortuneTelling extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String luckList[] = {"大吉", "中吉", "小吉", "吉", "半吉", "末小吉", "凶", "小凶", "半凶", "末凶", "大凶"};
            //乱数クラス作成
            Random rand = new Random();
            //乱数取得
            Integer index = rand.nextInt(luckList.length);

            //リクエストスコープへ結果を設定
            ResultData data = new ResultData();
            data.setD(new Date());
            data.setLuck(luckList[index]);
            request.setAttribute("DATA", data);

            System.out.println("今日の運勢は" + luckList[index]);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/FortuneTellingResult.jsp");

            rd.forward(request, response);

            

        }

    }
}




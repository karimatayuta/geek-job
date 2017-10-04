package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //セッションスタート
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        UserDataBeans udb =(UserDataBeans)session.getAttribute("udb");
        String accesschk0 = request.getParameter("ac");//なぜ条件分岐がうまくいかないのか？
        
        try{
            
            
            
            if(accesschk0 == null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk0)){
                throw new Exception("不正なアクセスです。");
            }
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            UserDataDTO userdata = new UserDataDTO();
            userdata.setName((String)udb.getName());

//            Calendar birthday = Calendar.getInstance();
//           userdata.setBirthday(birthday.getTime()); 
//            userdata.setType(Integer.parseInt((String)session.getAttribute("type")));
//            userdata.setTell((String)session.getAttribute("tell"));
//            userdata.setComment((String)session.getAttribute("comment"));
//            なぜダメなのか？しっかり理由を書く。


            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = f.parse(udb.getYear() + "-" + udb.getMonth() + "-" +udb.getDay());
            userdata.setBirthday(birthday);
            userdata.setType(Integer.parseInt((String)udb.getType()));
            userdata.setTell((String)udb.getTell());
            userdata.setComment((String)udb.getComment());
            
            
            //DBへデータの挿入
            UserDataDAO .getInstance().insert(userdata);
            
            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

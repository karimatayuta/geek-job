package DataOperation;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class d_b07 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String user = "KARIMATA";
            String password = "KARI";
            String url = "jdbc:mysql://localhost:8889/geekjob_db";

            Connection db_con = null;//DB接続するためにConnectionが必要
            PreparedStatement db_st = null;//SQL文を表すためPreparedStatementが必要
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection(url, user, password);
                out.println("DB接続完了"+"<br>");

                
                db_st = db_con.prepareStatement("update tab set name = ?,age = ?,birthday = ? where profilesID = 1");
                db_st.setString(1,"松岡修造");
                db_st.setInt(2,48);
                db_st.setString(3,"1967-11-06");
                
                int db_up = db_st.executeUpdate();
                
                db_st = db_con.prepareStatement("select * from tab");
                db_data = db_st.executeQuery();//executeUpdateはSQL文を実行し、作成された結果を返すために必要
                
                
                
                while (db_data.next()) {
                    out.println("profilesID:" + db_data.getInt("profilesID") + "name:" + db_data.getString("name")
                            + "tel" + db_data.getString("tel")+ "age" + db_data.getInt("age")+ "birthday" + db_data.getString("birthday")+"<br>");
                }
                db_data.close();
                db_st.close();
                db_con.close();
                } catch (SQLException e) {
                out.println("SQLException:" + e.getMessage());
            } catch (ClassNotFoundException e) {
                out.println("ClassNotFoundException:" + e.getMessage() + "<br>");
            } catch (Exception e) {
                out.println("Exception:" + e.getMessage() + "<br>");
                } finally {
                if (db_con != null) {
                    try {
                        db_con.close();
                        out.println("DBとの切断に成功");
                    } catch (Exception e) {
                        out.println(e.getMessage());
                    }
                }
               
            }
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

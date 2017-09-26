
package DataOperation;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;



public class d_b02 extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            String user = "KARIMATA";
            String password = "KARI";
            String url = "jdbc:mysql://localhost:8889/geekjob_db";

            Connection db_con = null;//DB接続するためにConnectionが必要
            PreparedStatement db_st = null;//SQL文を表すためPreparedStatementが必要
            
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection(url, user, password);
                out.println("DB接続完了");
                
                
                db_st = db_con.prepareStatement("insert into tab values(?,?,?,?,?)");
                
                db_st.setInt(1,7);
                db_st.setString(2,"ドラえもん");
                db_st.setString(3,"0123-123-123");
                db_st.setInt(4,10);
                db_st.setString(5,"2112-09-03");
                
                int num = db_st.executeUpdate();//executeUpdateはSQL文を実行し、作成された結果を返すために必要
                
                
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

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}


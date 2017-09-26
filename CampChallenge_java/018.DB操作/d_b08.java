package DataOperation;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class d_b08 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            request.setCharacterEncoding("UTF-8");

            String name = request.getParameter("textName");

            String user = "KARIMATA";
            String password = "KARI";
            String url = "jdbc:mysql://localhost:8889/geekjob_db";

            Connection db_con = null;//DB接続するためにConnectionが必要
            PreparedStatement db_st = null;//SQL文を表すためPreparedStatementが必要
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection(url, user, password);
                out.println("DB接続完了" + "<br>");

                db_st = db_con.prepareStatement("select * from tab where name like ?");
                db_st.setString(1, "%" + name + "%");
                db_data = db_st.executeQuery();

                while (db_data.next()) {
                    out.println("name:" + db_data.getString("name"));

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

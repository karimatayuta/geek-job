package DataOperation;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class d_b12 extends HttpServlet {
    
    

    public void printData(ResultSet db_data, PrintWriter out) {
        //1つのレコードを表示するメソッド
        try {
            int ID = db_data.getInt("profilesID");
            String name = db_data.getString("name");
            String tell = db_data.getString("tell");
            int age = db_data.getInt("age");
            String bdy = db_data.getString("birthday");

            out.print("ID：" + ID + "," + "名前：" + name + "," + "電話番号：" + tell + "," + "年齢：" + age + "," + "生年月日：" + bdy);
        } catch (SQLException e_sql) {
            System.out.println("接続時にエラーが発生しました。" + e_sql.getMessage());
        } catch (Exception e) {
            System.out.println("接続時にエラーが発生しました。" + e.getMessage());
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            request.setCharacterEncoding("UTF-8");

            //変数宣言
            Connection db_con = null;//DB接続するためにConnectionが必要
            PreparedStatement db_st = null;//SQL文を表すためPreparedStatementが必要
            ResultSet db_data = null;

            //データ格納
            String human = request.getParameter("name");
            int old = Integer.parseInt(request.getParameter("age"));
            String bd = request.getParameter("birthday");
            String and_or = request.getParameter("and_or");

            String user = "KARIMATA";
            String password = "KARI";
            String url = "jdbc:mysql://localhost:8889/geekjob_db";

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                db_con = DriverManager.getConnection(url, user, password);
                out.println("DB接続完了" + "<br>");

                if (and_or.equals("and")) {
                    db_st = db_con.prepareStatement("select * from profiles where name = ? AND age = ? AND birthday = ?");
                    db_st.setString(1, human);
                    db_st.setInt(2, old);
                    db_st.setString(3, bd);

                    db_data = db_st.executeQuery();

                    while (db_data.next()) {
                        out.println("id:" + db_data.getInt("profilesID"));
                        out.println("name:" + db_data.getString("name"));
                        out.println("tel:" + db_data.getString("tel"));
                        out.println("age:" + db_data.getInt("age"));
                        out.println("birthday:" + db_data.getString("birthday"));
                    }

                } else if (and_or.equals("or")) {
                    db_st = db_con.prepareStatement("select * from tab where name = ? OR age = ? OR birthday = ?");
                    db_st.setString(1, human);
                    db_st.setInt(2, old);
                    db_st.setString(3, bd);

                    db_data = db_st.executeQuery();
                    while (db_data.next()) {
                        out.println("id:" + db_data.getInt("profilesID"));
                        out.println("name:" + db_data.getString("name"));
                        out.println("tel:" + db_data.getString("tel"));
                        out.println("age:" + db_data.getInt("age"));
                        out.println("birthday:" + db_data.getString("birthday"));

                    }

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

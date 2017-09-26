package DataOperation;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class d_b09 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            request.setCharacterEncoding("UTF-8");
            
            
            Connection db_con = null;//DB接続するためにConnectionが必要
            PreparedStatement db_st = null;//SQL文を表すためPreparedStatementが必要
            ResultSet db_data = null;
            
            
            
            int id1 = Integer.parseInt(request.getParameter("id"));
            String human = request.getParameter("name");
            String telNo = request.getParameter("tel");
            int old = Integer.parseInt(request.getParameter("age"));
            String bd = request.getParameter("birthday");

            String user = "KARIMATA";
            String password = "KARI";
            String url = "jdbc:mysql://localhost:8889/geekjob_db";

            

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                
                db_con = DriverManager.getConnection(url, user, password);
                out.println("DB接続完了" + "<br>");

                db_st = db_con.prepareStatement("insert into tab values(?,?,?,?,?)");
                db_st.setInt(1, id1);
                db_st.setString(2, human);
                db_st.setString(3, telNo);
                db_st.setInt(4, old);
                db_st.setString(5, bd);
                db_st.executeUpdate();//executeUpdateはSQL文を実行し、作成された結果を返すために必要
                

                db_st = db_con.prepareStatement("select * from tab where profilesID = ?");
                db_st.setInt(1, id1);
                db_data = db_st.executeQuery();

                while (db_data.next()) {
                    out.println("id:" + db_data.getInt("profilesID"));
                    out.println("name:" + db_data.getString("name"));
                    out.println("tel:" + db_data.getString("tel"));
                    out.println("age:" + db_data.getInt("age"));
                    out.println("birthday:" + db_data.getString("birthday"));

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

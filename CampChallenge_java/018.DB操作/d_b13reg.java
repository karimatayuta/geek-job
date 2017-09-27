

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class d_b13reg extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           request.setCharacterEncoding("UTF-8");
           
           
           //データの変数を宣言する。
           Connection db_con=null;
           PreparedStatement db_st=null;
           ResultSet db_data=null;
           
           //入力に必要なデータを格納する。
           String reg0=request.getParameter("reg");
           int money = Integer.parseInt(request.getParameter("money"));
           int sum =Integer.parseInt(request.getParameter("sum"));
           
           
           try{
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               
               db_con=DriverManager.getConnection("jdbc:mysql://localhost:8889/geekjob_db","KARIMATA","KARI");
               out.print("DB接続完了" + "<br>");
               
               db_st=db_con.prepareStatement("insert into PRODATA values(?,?,?)");
               db_st.setString(1, reg0);
               db_st.setInt(2, money);
               db_st.setInt(3, sum);
               db_st.executeUpdate();
               
               db_st=db_con.prepareStatement("select * from PRODATA WHERE product=?");
               db_st.setString(1, reg0);
               
               db_data = db_st.executeQuery();
               
               while(db_data.next()){
                   out.print("商品名は" + db_data.getString("product"));
                   out.print("価格は" + db_data.getInt("price"));
                   out.print("個数は"+ db_data.getInt("num"));
               }
               db_data.close();
               db_st.close();
               db_con.close();
               
               
           }catch(SQLException e){
               out.print("SQLException:" + e.getMessage());
           }catch(ClassNotFoundException e){
               out.print("ClassNotFoundException:" + e.getMessage());
           }catch(InstantiationException e){
               out.print("InstantiationException:" + e.getMessage());
           }catch(IllegalAccessException e){
               out.print("IllegalAccessException:" + e.getMessage());
           }   
           
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet d_b13reg</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
            
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

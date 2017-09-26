/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperation;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author karimatayuuta2
 */
public class d_b extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //変数を宣言する。
            String user= "KARIMATA";
            String password = "KARI";
            String url = "jdbc:mysql://localhost:8889/geekjob_db";
            
            //コネクションの中身を空にする。
            Connection conn = null;
            
            try{
                //ドライバーを呼び出し、接続する。
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                out.println("ドライバーのロードに成功しました。" + "<br>");
                
                //DriverManagerにより必要な情報を抜き出す。
                conn = DriverManager.getConnection(url,user,password);
                out.println("データーベース接続に成功しました。" + "<br>");
            }catch(ClassNotFoundException e){
                out.println("ClassNotFoundException:" + e.getMessage() + "<br>");
            }catch(SQLException e){
                out.println("SQLException:" + e.getMessage() + "<br>");
            }catch(Exception e){
                out.println("Exception:" + e.getMessage() + "<br>");
            }finally{
                try{
                    if(conn !=null){
                        conn.close();
                        out.println("データベース切断に成功しました。" + "<br>");
                    }else{
                        out.println("コネクションがありません。"+ "<br>");
                    }
                }catch(SQLException e){
                            out.println("SQLException:" + e.getMessage()+ "<br>");
                            }
                }
            
            
            
            
            
            
            
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet d_b</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet d_b at " + request.getContextPath() + "</h1>");
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

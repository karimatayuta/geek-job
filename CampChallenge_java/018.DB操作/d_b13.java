
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class d_b13 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            

            Connection db_con = null;//DB接続のために必要
            PreparedStatement db_st = null;//SQL文を表すために必要
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/geekjob_db","KARIMATA" , "KARI");
                out.print("DB接続完了");
                
                
                request.setCharacterEncoding("UTF-8");
                String user = request.getParameter("name");
                String password = request.getParameter("password");

                db_st = db_con.prepareStatement("select * from ROGIN where USERNAME=? AND PASSWORD=?");
                db_st.setString(1, user);
                db_st.setString(2, password);
                
                db_data = db_st.executeQuery();
                
                if(db_data.next()){
                    response.sendRedirect("http://localhost:8080/challenge1/d_b13data.jsp");
                }
                
                if(!db_data.next()){
               
                    response.sendRedirect("http://localhost:8080/challenge1/d_b13html.jsp");
                }
                //response.sendRedirect?
                //db_data.next()?
                
                db_data.close();
                db_st.close();
                db_con.close();
                }catch(SQLException e){
                    out.println("SQLException:" + e.getMessage());
                    
                }catch(ClassNotFoundException e){
                    out.println("ClassNotFoundException:" + e.getMessage() + "<br>");
                
                }catch( Exception e){
                    out.println("Exception:" + e.getMessage() + "<br>");
                }finally{
                if(db_con != null){
                    try{
                        db_con.close();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
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

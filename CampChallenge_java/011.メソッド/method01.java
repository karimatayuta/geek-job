
package method;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class method01 extends HttpServlet {
     
    //3つのユーザー定義メソッドを作り、メソッドを10回呼び出してください。
    
    public void myprofile(PrintWriter pw){
            pw.println("karimata yuta");
            pw.println("1992.07.28");
            pw.println("I like Draemon"+"<br>");
        }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            for(int i=0;i<10;i++){
              myprofile(out);
            }
            
    
        
            
        }}
    
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
    }}




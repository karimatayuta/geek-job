package method;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class method06 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet method06</title>");
            out.println("</head>");
            out.println("<body>");
            
            
            out.print(reprof(1));//野原しんのすけを呼び出す。
            
            out.println("</body>");
            out.println("</html>");

            
        }
    }

    public HashMap<String, String> reprof(int i) {
        
        if(i==1){
        HashMap<String, String> prof1 = new HashMap<>();//右の＜＞は何も入らない。
        prof1.put("nameID", "野原しんのすけ");
        prof1.put("age", "5");
        prof1.put("stay", "東京");
        prof1.get("nameID");
        return prof1;
        }else if(i==2){
        HashMap<String, String> prof2 = new HashMap<>();
        prof2.put("nameID", "野原みさえ");
        prof2.put("age", "29");
        prof2.put("stay", "東京");
        prof2.get("nameID");
        return prof2;
        }else if(i==3){
        HashMap<String, String> prof3 = new HashMap<>();
        prof3.put("nameID", "野原ひろし");
        prof3.put("age", "35");
        prof3.get("nameID");
        prof3.put("stay", "東京");
        return prof3;
        }
        return null;
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

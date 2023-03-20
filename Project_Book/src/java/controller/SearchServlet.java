/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAOBook;
import dal.DAOCategory;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.Book;
import model.Category;

/**
 *
 * @author TrongHoa
 */
@WebServlet(name="SearchServlet", urlPatterns={"/search"})
public class SearchServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DAOCategory dCate = new DAOCategory();
        List<Category> listCate = dCate.getAllCate();
        request.setAttribute("listCate", listCate);
        String content = request.getParameter("content");
        int cateId = Integer.parseInt(request.getParameter("cate"));
        DAOBook dal = new DAOBook();
        String sort = request.getParameter("sort");
        String from_raw = request.getParameter("fromdate"); 
        String to_raw = request.getParameter("todate"); 
        String price1_raw = request.getParameter("fromprice"); 
        String price2_raw = request.getParameter("toprice"); 
        Double price1=null, price2=null;
        Date from=null, to=null;
        
        try {
            price1 = ((price1_raw == null) ||  (price1_raw.equals(""))?null:Double.parseDouble(price1_raw));
            price2 = ((price2_raw == null) ||  (price2_raw.equals(""))?null:Double.parseDouble(price2_raw));
            from = ((from_raw == null) || (from_raw.equals(""))?null:Date.valueOf(from_raw));
            to = ((to_raw == null) || (to_raw.equals(""))?null:Date.valueOf(to_raw));
        } catch (Exception e) {
        }
            request.setAttribute("from", from);
            request.setAttribute("to", to);
            request.setAttribute("price1", price1);
            request.setAttribute("price2", price2);
            request.setAttribute("sort", sort);
        
        
        List<Book> list = dal.searchByKey(content, from, to, price1, price2, cateId, sort);
        int page, numberpage = 10;
        int size=list.size();
        int num=(size%10==0?(size/10):((size/10)+1));
        String xpage=request.getParameter("page");
        if(xpage==null) {
            page = 1;
        }else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1)*numberpage;
        end = Math.min(page*numberpage, size);
        List<Book> listAll = dal.getListByPage(list, start, end);
        request.setAttribute("cateId", cateId);
        request.setAttribute("content", content);
        request.setAttribute("listAll", listAll);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        
        request.getRequestDispatcher("search.jsp").forward(request, response);
    } 
    

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

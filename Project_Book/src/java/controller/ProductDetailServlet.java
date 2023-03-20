/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAOBook;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Book;
import model.Cart;
import model.Item;
import model.Review;

/**
 *
 * @author TrongHoa
 */
@WebServlet(name="ProductDetailServlet", urlPatterns={"/product"})
public class ProductDetailServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ProductDetailServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDetailServlet at " + request.getContextPath () + "</h1>");
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
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        DAOBook dal = new DAOBook();
        Book b = dal.getBookById(bookId);
        request.setAttribute("book", b);
        List<Review> r = dal.getComment(bookId);
        request.setAttribute("listRv", r);
        List<Book> list = dal.getListBookSimilar(b.getBookID(), b.getTitle(), b.getAuthor(), b.getCategoryID());
        request.setAttribute("list", list);
        /*
            CHO NAY XU LI GIO HANG
        */
//        Cookie[] arr = request.getCookies();
//        String txt = "";
//        if(arr != null) {
//            for(Cookie o:arr){
//                if(o.getName().equals("cart")) {
//                    txt+=o.getValue();
//                }
//            }
//        }
//        Cart cart = new Cart(txt, b);
//        List<Item> listItem=cart.getItems();
//        int n;
//        if(listItem!=null) {
//            n = listItem.size();
//        }else
//            n = 0;
//        request.setAttribute("size", n);
        request.getRequestDispatcher("product.jsp").forward(request, response);
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
        Cookie[] arr = request.getCookies();
        String txt = "";
        if(arr != null) {
            for(Cookie o:arr){
                if(o.getName().equals("cart")) {
                    txt+=o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        String num = request.getParameter("num");
        String id = request.getParameter("bookId");
        if(txt.isEmpty()) {
            txt = id+":"+num;
        }else {
            txt=txt+"/"+id+":"+num;
        }
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(2*24*60*60);
        response.addCookie(c);
        int bookId = Integer.parseInt(id);
        DAOBook dal = new DAOBook();
        Book b = dal.getBookById(bookId);
        request.setAttribute("book", b);
        List<Review> r = dal.getComment(bookId);
        request.setAttribute("listRv", r);
        List<Book> list = dal.getListBookSimilar(b.getBookID(), b.getTitle(), b.getAuthor(), b.getCategoryID());
        request.setAttribute("list", list);
        request.getRequestDispatcher("product.jsp").forward(request, response);
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

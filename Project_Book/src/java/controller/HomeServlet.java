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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Book;
import model.Cart;
import model.Category;
import model.Item;

/**
 *
 * @author TrongHoa
 */
@WebServlet(name="HomeServlet", urlPatterns={"/home"})
public class HomeServlet extends HttpServlet {
   
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
            out.println("<title>Servlet HomeServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at " + request.getContextPath () + "</h1>");
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
        
        DAOBook dNew = new DAOBook();
        List<Book> listNew = dNew.getNewBook();
        List<Book> listSold = dNew.getSoldBook();
        request.setAttribute("listNew", listNew);
        request.setAttribute("listSold", listSold);
        List<Book> listLove = dNew.getLoveBook();
        request.setAttribute("listLove", listLove);
        String cateId_raw = request.getParameter("cate");
        int cateId;
        if(cateId_raw==null) 
            cateId =0;
        else
            cateId = Integer.parseInt(cateId_raw);
        List<Book> listByCate1 = dNew.getBookByCategory(cateId);
        int page, numberpage = 5;
        int size=listByCate1.size();
        int num=(size%10==0?(size/5):((size/5)+1));
        String xpage=request.getParameter("page");
        if(xpage==null) {
            page = 1;
        }else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1)*numberpage;
        end = Math.min(page*numberpage, size);
        List<Book> listAll = dNew.getListByPage(listByCate1, start, end);
        request.setAttribute("cateId", cateId);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("listAll", listAll);
        /*
            CHO NAY XU LI GIO HANG
        */
        Cookie[] arr = request.getCookies();
        String txt = "";
        if(arr != null) {
            for(Cookie o:arr){
                if(o.getName().equals("cart")) {
                    txt+=o.getValue();
                }
            }
        }
        List<Book> b = dNew.getAllBook();
        Cart cart = new Cart(txt, b);
        List<Item> listItem=cart.getItems();
        int n;
        if(listItem!=null) {
            n = listItem.size();
        }else
            n = 0;
        HttpSession session = request.getSession();
        session.setAttribute("size", n);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
        processRequest(request, response);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOAccount;
import dal.DAOBook;
import dal.DAOCategory;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import model.Account;
import model.Admin;
import model.Book;
import model.Category;
import model.NXB;

/**
 *
 * @author TrongHoa
 */
@WebServlet(name = "AddServlet", urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("crud", "crud");
        DAOCategory dCate = new DAOCategory();
        DAOBook dal = new DAOBook();
        List<NXB> listNXB = dal.getListNXB();
        List<Category> listCate = dCate.getAllCate();
        request.setAttribute("listCate", listCate);
        request.setAttribute("listNXB", listNXB);
        request.getRequestDispatcher("add.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        int cateId = Integer.parseInt(request.getParameter("cate"));
        String title = request.getParameter("title");
        Double price = Double.parseDouble(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discount"));
        Date releaseDate = Date.valueOf(request.getParameter("releaseDate"));
        String describe = request.getParameter("describe");
        String image = request.getParameter("image");
        DAOAccount dal = new DAOAccount();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
//        PrintWriter out = response.getWriter();
//        out.print(a.getUsername());
        Admin ad = dal.getAdmin(a.getUsername());

        dal.addBook(name, author, cateId, title, price, discount, releaseDate, describe,"images/"+image, ad.getAdminId());
        List<Book> list = dal.getBook(ad.getAdminId());
        request.setAttribute("listBook", list);
        request.setAttribute("crud", "crud");
        request.setAttribute("addSuccsess", "Sản phẩm đã được thêm thành công");
        request.getRequestDispatcher("admin.jsp").forward(request, response);
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

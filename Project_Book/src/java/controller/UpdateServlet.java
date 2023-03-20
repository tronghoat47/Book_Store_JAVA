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
import java.sql.Date;
import java.util.List;
import model.Book;
import model.Category;
import model.NXB;

/**
 *
 * @author TrongHoa
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
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
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        DAOAccount dal = new DAOAccount();
        Book b = dal.getBookByID(bookId);
        request.setAttribute("book", b);
        request.setAttribute("crud", "crud");
        DAOCategory dCate = new DAOCategory();
        List<Category> listCate = dCate.getAllCate();
        request.setAttribute("listCate", listCate);
        DAOBook dal1 = new DAOBook();
        List<NXB> listNXB = dal1.getListNXB();
        request.setAttribute("listNXB", listNXB);
        request.getRequestDispatcher("update.jsp").forward(request, response);
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
        int bookId = Integer.parseInt(request.getParameter("bookId"));
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
        Book b = dal.getBookByID(bookId);
        if (image == null || image == "") {
            image = b.getImage();
        } else {
            image = "images/" + image;
        }
        dal.updateBook(bookId, name, author, cateId, title, price, discount, releaseDate, describe, image, b.getAdminID());
        b = dal.getBookByID(bookId);
        request.setAttribute("book", b);
        request.setAttribute("crud", "crud");
        DAOCategory dCate = new DAOCategory();
        List<Category> listCate = dCate.getAllCate();
        request.setAttribute("listCate", listCate);
        request.setAttribute("updateSuccsess", "Cập nhật thành công");
        request.getRequestDispatcher("update.jsp").forward(request, response);
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

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
import model.Customer;
import model.NXB;

/**
 *
 * @author TrongHoa
 */
@WebServlet(name = "CrudServlet", urlPatterns = {"/crud"})
public class CrudServlet extends HttpServlet {

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
            out.println("<title>Servlet CrudServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrudServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        DAOAccount dal = new DAOAccount();
        if (a.getRole() == 1) {
            Admin ad = dal.getAdmin(a.getUsername());
            List<Book> list = dal.getBook(ad.getAdminId());
            request.setAttribute("listBook", list);
            request.setAttribute("deleteSuccess", request.getAttribute("deleteSuccess"));
            request.setAttribute("admin", ad);
            request.setAttribute("crud", "crud");
            DAOBook dal1 = new DAOBook();
            List<NXB> list1 = dal1.getListNXB();
            request.setAttribute("listNXB", list1);
            DAOCategory dCate = new DAOCategory();
            List<Category> listCate = dCate.getAllCate();
            request.setAttribute("listCate", listCate);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("profile_customer").forward(request, response);
        }
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
        int cateId = Integer.parseInt(request.getParameter("cate"));
        DAOBook dal = new DAOBook();
        String nxb = request.getParameter("nxb");
        String from_raw = request.getParameter("fromdate");
        String to_raw = request.getParameter("todate");
        Date from = null, to = null;
        String content = request.getParameter("content");
        try {
            from = ((from_raw == null) || (from_raw.equals("")) ? null : Date.valueOf(from_raw));
            to = ((to_raw == null) || (to_raw.equals("")) ? null : Date.valueOf(to_raw));
        } catch (Exception e) {
        }
        List<Book> list = dal.searchByKey(content, from, to, null, null, cateId, nxb);
        request.setAttribute("listBook", list);
        request.setAttribute("admin", "ad");
        request.setAttribute("crud", "crud");
        DAOBook dal1 = new DAOBook();
        List<NXB> list1 = dal1.getListNXB();
        request.setAttribute("listNXB", list1);
        DAOCategory dCate = new DAOCategory();
        List<Category> listCate = dCate.getAllCate();
        request.setAttribute("listCate", listCate);
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

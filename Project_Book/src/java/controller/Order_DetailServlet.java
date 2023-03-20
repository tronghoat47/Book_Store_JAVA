/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOAccount;
import dal.DAOCheckout;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Customer;
import model.Order_Detail;

/**
 *
 * @author TrongHoa
 */
@WebServlet(name = "Order_DetailServlet", urlPatterns = {"/order_detail"})
public class Order_DetailServlet extends HttpServlet {

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
            out.println("<title>Servlet Order_DetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Order_DetailServlet at " + request.getContextPath() + "</h1>");
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
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        DAOCheckout dal = new DAOCheckout();
        List<Order_Detail> list = new ArrayList<>();
        List<Order_Detail> list1 = dal.getOrderDetail(orderId);
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        if (a.getRole() == 1) {
            request.setAttribute("list", list1);
            request.setAttribute("manager", "manager");
            request.setAttribute("ad", "ad");
        } else {
            Customer cu = new DAOAccount().getCustomer(a.getUsername());
            for (Order_Detail o : list1) {
                if (dal.checkReview(o.getBook().getBookID(), cu.getCustomerId()) != null) {
                    o.setRe(true);
                }
                list.add(o);
            }
            request.setAttribute("list", list);
            request.setAttribute("history", "history");
            request.setAttribute("cus", "cus");
        }

        for (Order_Detail o : list) {
            System.out.println(o.getBook().getBookID() + " " + o.isRe());
        }
        request.getRequestDispatcher("order_detail.jsp").forward(request, response);
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

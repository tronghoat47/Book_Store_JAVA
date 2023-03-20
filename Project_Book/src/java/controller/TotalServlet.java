/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOAccount;
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
import model.Category;
import model.ListTotal;

/**
 *
 * @author TrongHoa
 */
@WebServlet(name = "TotalServlet", urlPatterns = {"/total"})
public class TotalServlet extends HttpServlet {

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
            out.println("<title>Servlet TotalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TotalServlet at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("total", "total");
        DAOAccount dal = new DAOAccount();
        List<ListTotal> list1 = dal.getotentialCustomer(a.getUsername(), null);
        request.setAttribute("listCus", list1);
        List<ListTotal> list2 = dal.getBookMostSaleOff(a.getUsername(), null);
        request.setAttribute("listBook", list2);
        List<ListTotal> list3 = dal.getListCustomerMostBuy(a.getUsername(), null);
        request.setAttribute("listCus2", list3);
        List<ListTotal> list4 = dal.getListCategory(a.getUsername(), null);
        request.setAttribute("listCate", list4);
        List<ListTotal> list = dal.getChart2(a.getUsername());
//        for (int i = 0; i < list.size(); i++) {
//            int j;
//            if (i == 0 && list.get(i).getMonth()==1) {
//                continue;
//            } else {
//                j = list.get(i - 1).getMonth();
//            }
//            for (; j <= list.get(i).getMonth(); j++) {
//                if(j != list.get(i).getMonth()) {
//                    list.add(j, new ListTotal(j+1, 0.0));
//                }
//            }
//        }
        for (ListTotal i : list) {
            System.out.println(i.getMonth() + " " + i.getTotalMoney());
        }
        request.setAttribute("listChart", list);

        request.getRequestDispatcher("total.jsp").forward(request, response);
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
        String date1_raw = request.getParameter("date1");
        String date2_raw = request.getParameter("date2");
        String date3_raw = request.getParameter("date3");
        String date4_raw = request.getParameter("date4");
        Date date1 = null, date2 = null, date3 = null, date4 = null;
        try {
            date1 = ((date1_raw == null) || (date1_raw.equals("")) ? null : Date.valueOf(date1_raw));
            date2 = ((date2_raw == null) || (date2_raw.equals("")) ? null : Date.valueOf(date2_raw));
            date3 = ((date3_raw == null) || (date3_raw.equals("")) ? null : Date.valueOf(date3_raw));
            date4 = ((date4_raw == null) || (date4_raw.equals("")) ? null : Date.valueOf(date4_raw));
        } catch (Exception e) {
        }
        System.out.println(date1 + " " + date2 + " " + date3 + " " + date4);
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        request.setAttribute("total", "total");
        DAOAccount dal = new DAOAccount();
        List<ListTotal> list = dal.getotentialCustomer(a.getUsername(), date1);
        request.setAttribute("listCus", list);
        List<ListTotal> list2 = dal.getBookMostSaleOff(a.getUsername(), date2);
        request.setAttribute("listBook", list2);
        List<ListTotal> list3 = dal.getListCustomerMostBuy(a.getUsername(), date3);
        request.setAttribute("listCus2", list3);
        List<ListTotal> list4 = dal.getListCategory(a.getUsername(), date4);
        request.setAttribute("listCate", list4);
        request.setAttribute("date1", date1);
        request.setAttribute("date2", date2);
        request.setAttribute("date3", date3);
        request.setAttribute("date4", date4);

        request.getRequestDispatcher("total.jsp").forward(request, response);
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

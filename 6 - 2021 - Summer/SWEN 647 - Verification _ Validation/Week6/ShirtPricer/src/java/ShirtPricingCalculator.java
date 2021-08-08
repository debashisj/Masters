/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael Brown
 */
@WebServlet(urlPatterns = {"/ShirtPricingCalculator"})
public class ShirtPricingCalculator extends HttpServlet {

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
        
        // get value of http parameter waist and put it in variable waist
        int waist = Integer.parseInt(request.getParameter("waist"));
        
        // get value of http parameter neck size and put it in variable neck
        int neck = Integer.parseInt(request.getParameter("neck"));
        
        // create variable sqinches (square inches), set it to waist * neck
        float sqinches = waist * neck;
        
        // muliply sqinches by .0 to get the cost
        double cost = sqinches * 0.09;
        
        // if user checked collar add 2
        if (request.getParameter("collar") != null)
            cost = cost + 2.0;
        
        // if user sleeves collar add 5
        if (request.getParameter("sleeve") != null)
           cost = cost + 5.0;
        
        // assume currency is US.  If you selected EURO, convert to euro
        if (request.getParameter("currency").equals("EURO"))
            cost = cost * 0.88;
        
        // put the variables values for cost and currency into the http request
        //   so the jsp can access them.
        request.setAttribute("cost", cost);
        request.setAttribute("currency", request.getParameter("currency"));
        
        // call the ShirtPricingScreen.jsp
        request.getRequestDispatcher("ShirtPricingScreen.jsp").forward(request, response); 
        
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

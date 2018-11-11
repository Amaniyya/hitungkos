/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.session.hitungkos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class kosServlet extends HttpServlet {

    @EJB
    private hitungkos hitungkos;

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
        PrintWriter out = response.getWriter();
        
        try {            
            out.println("<html>");
            out.println("<body");
            out.println("<h3><center>Tugas RSBK Perhitungan Biaya Kos</center></h3>");
            String harga = request.getParameter("harga");
            String nama = request.getParameter("nama");
            
            if ((harga != null) && (harga.length() > 0)) {
                double d = Double.parseDouble(harga);
                if (request.getParameter("Satu") != null){
                    out.println("<center>");
                    out.println("<p> Halo : "+nama+"</p>");
                    String satu = hitungkos.hitungkos_satu(d);
                    out.println("<p> Biaya yang harus kamu bayar: Rp. "+satu+"</p>");
                    out.println("</center>");
                }  
                if (request.getParameter("Dua") != null) {
                    out.println("<center>");
                    out.println("<p> Halo : "+nama+"</p>");
                    String dua = hitungkos.hitungkos_dua(d);
                    out.println("<p> Biaya yang harus kamu bayar: Rp. "+dua+ " .</p>");
                    out.println("</center>");
                }
               
                
            } else {
                out.println("<center>");
                out.println("<p>Siapa Kamu:</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" name=\"nama\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<p>Berapa Bulan Kamu BELUM BAYAR kos?:</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" name=\"harga\" size=\"20\"></p>");
                out.println("<p>Kluster</p>");
                out.println("<input type=\"submit\" name=\"Satu\" value=\"Cewe\">"+ "  "+ "<input type=\"submit\" name=\"Dua\" value=\"Cowo\">");
                out.println("<br/>");
                out.println("<br/>");             
                out.println("</center>");
                out.println("</form>");
            }
        
        } finally {
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            out.close();
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

package com.abhi.servlets;

import com.abhi.entities.Users;
import com.abhi.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "RegisterServlet",urlPatterns = {"/RegisterServlet"})
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
    {
        try{

            String userName= req.getParameter("user_name");
            String userEmail= req.getParameter("user_email");
            String userPassword= req.getParameter("user_password");
            String userPhone= req.getParameter("user_phone");
            String userAddress= req.getParameter("user_address");

            PrintWriter out= res.getWriter();
//            if(userName.isEmpty())
//            {
//                out.println("enter the user name");
//                return;
//            }

            Users user= new Users(userName,userEmail,userPassword,userPhone,"default.jpg",userAddress,"normal");
            Session hibernateSession= HibernateUtils.getFactory().openSession();
            HttpSession httpSession = req.getSession();
            Transaction tx = hibernateSession.beginTransaction();

            int uid= (int)hibernateSession.save(user);
            tx.commit();
            hibernateSession.close();
            if(uid==0) {
                httpSession.setAttribute("message", "Invalid details");
                res.sendRedirect("register.jsp");
                return;
            }else{
                out.println("<h1> User Registered :</h1>");

                out.println("<a href='login.jsp' class='text-center d-block mb-3'>Click here to login </a>");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

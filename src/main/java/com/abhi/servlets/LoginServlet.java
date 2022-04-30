package com.abhi.servlets;

import com.abhi.dao.UserDao;
import com.abhi.entities.Users;
import com.abhi.utils.HibernateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="loginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out= res.getWriter();
        try {
            String userEmail = req.getParameter("email_user");
            String userPassword = req.getParameter("password_user");

            UserDao ud= new UserDao(HibernateUtils.getFactory());
            Users user= ud.getUserByMailAndPass(userEmail,userPassword);
            System.out.println(user);
            HttpSession httpSession= req.getSession();

            if(userEmail==null || !userPassword.equals(user.getuPassword()))
            {

                out.println("<h1> Invalid user details </h1>");
                httpSession.setAttribute("message", "Invalid user Details");
                res.sendRedirect("login.jsp");
                return;
            }else{
                httpSession.setAttribute("curr_user",user);
                if(user.getUserType().equals("normal"))
                {
                    res.sendRedirect("index.jsp");
                }else if(user.getUserType().equals("admin")){
                    res.sendRedirect("admin.jsp");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

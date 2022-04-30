package com.abhi.servlets;

import com.abhi.dao.CategoryDao;
import com.abhi.dao.ProductDao;
import com.abhi.entities.Category;
import com.abhi.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@MultipartConfig
@WebServlet(name = "ProductOperationServlet", urlPatterns = {"/ProductOperationServlet"})
public class ProductOperationServlet extends HttpServlet {
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
        HttpSession httpSession= req.getSession();
        String op=req.getParameter("operation");
        if(op.trim().equals("add_category")){
            String name= req.getParameter("catTitle");
            String desc= req.getParameter("catDescription");

            Category category= new Category(name,desc);
            CategoryDao cd= new CategoryDao();
            int cid=cd.addCategory(category);

            if(cid==0)
            {
                httpSession.setAttribute("message", "Invalid details");
                res.sendRedirect("admin.jsp");
                return;
            }else{
                httpSession.setAttribute("message", "Category Added");
                res.sendRedirect("admin.jsp");
                return;
            }

        }else if(op.trim().equals("add_product"))
        {
            String name= req.getParameter("proTitle");
            String desc= req.getParameter("proDescription");
            int price=Integer.parseInt(req.getParameter("proPrice"));
            int dis=Integer.parseInt(req.getParameter("proDis"));
            int quantity=Integer.parseInt(req.getParameter("proQuantity"));
            int catid=Integer.parseInt(req.getParameter("catid"));
            Part part= req.getPart("pPic");

            CategoryDao cd= new CategoryDao();
            Category category= cd.getCategoryByid(catid);

            Product p= new Product();
            p.setPname(name);
            p.setpDesc(desc);
            p.setpPrice(price);
            p.setpDiscount(dis);

            p.setpQuantity(quantity);
            p.setpPhoto(part.getSubmittedFileName());
            p.setCategory(category);

            int pid= new ProductDao().addProduct(p);

            try{
                String path = req.getRealPath("img") + File.separator + "products" + File.separator + part.getSubmittedFileName();
                System.out.println(path);

                FileOutputStream fos = new FileOutputStream(path);

                InputStream is = part.getInputStream();
                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
                fos.close();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            if(pid==0)
            {
                httpSession.setAttribute("message", "Invalid details");
                res.sendRedirect("admin.jsp");
                return;
            }else{
                httpSession.setAttribute("message", "Product Added");
                res.sendRedirect("admin.jsp");
                return;
            }
        }
    }
}

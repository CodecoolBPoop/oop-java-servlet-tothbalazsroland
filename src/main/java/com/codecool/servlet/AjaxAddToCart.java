package com.codecool.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ajaxServlet", urlPatterns = {"/ajax/addtocart"})
public class AjaxAddToCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ShoppingCart.add(new Item(OrderableItItems.getItems().get(id)));
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Item successfully added!");
    }
}

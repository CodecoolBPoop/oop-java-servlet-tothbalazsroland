package com.codecool.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "shoppingCartServlet", urlPatterns = {"/shoppingcart"})
public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        List<Item> items = ShoppingCart.getStore();
        StringBuffer tableBuffer = new StringBuffer();
        tableBuffer.append("<table>");
        for (Item item:items){
            tableBuffer.append("<tr id=\""+item.getId()+"\">");
            tableBuffer.append("<td>"+item.getName()+"</td>");
            tableBuffer.append("<td>"+item.getPrice()+"</td>");
            tableBuffer.append("<td><button class=\"removeButton\" id=\""+item.getId()+"\"> Remove </button>");
            tableBuffer.append("</tr>");
        }
        tableBuffer.append("<table>");
        out.println(
                "<html>\n" +
                        "<head><title>WebShop - Cart</title>" +
                        "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\" defer></script>"+
                        "<script type=\"text/javascript\" src=\"javascript/buttonHandler.js\"defer>" +
                        "</script>" +
                        "<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/style.css\">"+
                        "</head>\n" +
                        "<body background=\"/design/pirate.jpg\">\n" +
                        "<div class=\"height40\"><a href=\"/webshop\"><button>Webshop</button></a></div>"+
                        tableBuffer.toString()+
                        "</body></html>"
        );
    }
}

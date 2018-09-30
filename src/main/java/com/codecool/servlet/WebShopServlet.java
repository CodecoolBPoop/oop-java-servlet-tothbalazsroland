package com.codecool.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="webShopServlet", urlPatterns = {"/webshop"})
public class WebShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderableItItems.clearItems();
        OrderableItItems.initializeOrderableItems();
        PrintWriter out = response.getWriter();

        StringBuffer tableBuffer = new StringBuffer();
        tableBuffer.append("<table>");
        List<Item> items = OrderableItItems.getItems();
        for (Item item:items) {
            tableBuffer.append("<tr>");
            tableBuffer.append("<td>"+item.getName()+"</td>");
            tableBuffer.append("<td>"+item.getPrice()+"</td>");
            tableBuffer.append("<td><button class=\"addButton\" id=\""+item.getId()+"\"> Add</button>");
            tableBuffer.append("</tr>");
        }
        tableBuffer.append("</table>");
        out.println(
                "<html>\n" +
                        "<head><title>WebShop - Main</title>" +
                        "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\" defer></script>"+
                        "<script type=\"text/javascript\" src=\"javascript/buttonHandler.js\"defer>" +
                        "</script>" +
                        "<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/style.css\">"+
                        "</head>\n" +
                        "<body>\n" +
                        tableBuffer.toString()+
                        "<a href=\"/shoppingcart\"><button>Shopping Cart</button></a>"+
                        "</body></html>"
        );
    }
}

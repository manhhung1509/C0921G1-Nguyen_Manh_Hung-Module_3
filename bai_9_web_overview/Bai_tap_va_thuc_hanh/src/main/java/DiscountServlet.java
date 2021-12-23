import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet",urlPatterns = "/DiscountServlet")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");

        int cost = Integer.parseInt(price);
        int discountPercent = Integer.parseInt(discount);

        double discountAmount = cost * discountPercent * 0.01;
        double discountPrice = cost - discountAmount;

        request.setAttribute("description",description);
        request.setAttribute("Discount Amount",discountAmount);
        request.setAttribute("Discount Price",discountPrice);
        request.getRequestDispatcher("bai_tap/bai_1_get_result.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("bai_tap/bai_1_get_info.jsp").forward(request,response);
    }
}

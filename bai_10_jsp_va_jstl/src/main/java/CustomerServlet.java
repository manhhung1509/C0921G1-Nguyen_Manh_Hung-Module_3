import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-02","Hà Nội","bai_tap/anh-avt-anime-chat-nhat.jpg"));
        customerList.add(new Customer("Nguyễn Nam Khoa", "1984-02-24","Đà Nẵng","bai_tap/avt-chibi-doc_115941237.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1986-01-12","Quảng Nam","bai_tap/large_1588936738888.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1990-10-10","Hải phòng","bai_tap/large_1615476147747.jpg"));

        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("bai_tap/bai_1_display_customer.jsp").forward(request,response);
    }
}

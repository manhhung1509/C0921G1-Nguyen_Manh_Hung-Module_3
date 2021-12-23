import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password)) {
            request.setAttribute("result","Welcome " + username + " to website");
            request.getRequestDispatcher("thuc_hanh/bai_2_get_sesult_from_form.jsp").forward(request,response);
        } else {
            request.setAttribute("result","Login Error");
            request.getRequestDispatcher("thuc_hanh/bai_2_get_sesult_from_form.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("thuc_hanh/bai_2_form_get_infor.jsp").forward(request,response);

    }
}

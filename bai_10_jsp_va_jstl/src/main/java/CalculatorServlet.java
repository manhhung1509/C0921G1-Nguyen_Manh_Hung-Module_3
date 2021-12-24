import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("first-operand"));
        float secondOperand = Integer.parseInt(request.getParameter("second-operand"));
        char operator = request.getParameter("operator").charAt(0);

        try{
            float result = Calculator.calculate(firstOperand, secondOperand, operator);
            request.setAttribute("firstOperand",firstOperand);
            request.setAttribute("operator",operator);
            request.setAttribute("secondOperand",secondOperand);
            request.setAttribute("result",result);
            request.getRequestDispatcher("bai_tap/display_result_caculate.jsp").forward(request,response);
        }catch (Exception ex){
            request.setAttribute("Error",ex.getMessage());
            request.getRequestDispatcher("bai_tap/display_result_caculate.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("bai_tap/display_caculate.jsp").forward(request,response);

    }
}

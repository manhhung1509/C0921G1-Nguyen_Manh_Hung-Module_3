import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "DictionaryServlet",urlPatterns = "/DictionaryServlet")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        String search = request.getParameter("txtSearch");
        Set<String> set = dictionary.keySet();

        if(search != null){
            for (String key: set) {
                if(search.equals(key)){
                    request.setAttribute("word",search);
                    request.setAttribute("Result",dictionary.get(key));
                    request.getRequestDispatcher("thuc_hanh/translate.jsp").forward(request,response);
                }
            }
        } else {
            request.setAttribute("Result","Not found");
            request.getRequestDispatcher("thuc_hanh/translate.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("thuc_hanh/bai_4_form_dictionary.jsp").forward(request,response);

    }
}

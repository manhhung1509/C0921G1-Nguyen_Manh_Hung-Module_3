package controller;

import bean.User;
import service.UserService;
import service.impl.UserServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindByCountryServlet", urlPatterns = "/FindByCountryServlet")
public class FindByCountryServlet extends HttpServlet {
    private UserService userService = new UserServiceIMPL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        List<User> userList = userService.finByCountry(country);
        if (userList !=null){
            request.setAttribute("userList", userList);
        }else{
            request.setAttribute("message", "Không tìm thấy user");
        }
        request.getRequestDispatcher("find_by_country.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

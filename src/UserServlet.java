import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserServlet extends HttpServlet {
    private DBHandler dbHandler = new DBHandler();
    ArrayList<ArrayList<String>> data = new ArrayList<>();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies) {
            if (cookie.getName().equals("JX_UserStuff")) {
                response.getWriter().write(cookie.getValue());
            }

        }
    }
}
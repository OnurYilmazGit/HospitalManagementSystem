import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class reg_patServlet extends HttpServlet {
    private DBHandler dbHandler = new DBHandler();
    private salter salter=new salter();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fname =    request.getParameter("fname");
        String lname =    request.getParameter("lname");

        password=salter.salt(password,username);
        try {
            dbHandler.create(username,password,fname,lname);
        } catch (Exception e) {
            e.printStackTrace();
        }



        /*if (email.equals("ihh")) {

            response.addCookie(new Cookie("JX_UserStuff", email));
            response.sendRedirect("/User");
        } else {
            request.setAttribute("status", "fail");
            request.getRequestDispatcher("reg_pat.jsp").forward(request, response);
        }*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("reg_pat.jsp")
                .forward(request, response);


    }
}
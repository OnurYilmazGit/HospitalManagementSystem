import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class login_nurseServlet extends HttpServlet {
    private DBHandler dbHandler = new DBHandler();

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            dbHandler.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //response.getWriter().write(username);

        if(dbHandler.checknurse(username,password)){
            response.addCookie(new Cookie("JX_UserStuff",username));
            response.sendRedirect("/usernurse.jsp");
        }
        else{
            request.setAttribute("status","fail");
            request.getRequestDispatcher("login_nurse.jsp").forward(request,response);
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login_nurse.jsp")
                .forward(request,response);

    }
}

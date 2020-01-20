import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    private DBHandler dbHandler = new DBHandler();
    private salter salter=new salter();

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
        password=salter.salt(password,username);
        HttpSession psession = request.getSession();
        psession.setAttribute("username", username);

        if(dbHandler.check(username,password)){
            response.addCookie(new Cookie("JX_UserStuff",username));
            response.sendRedirect("/User.jsp");
        }
        else{
            request.setAttribute("status","fail");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp")
                .forward(request,response);

    }
}



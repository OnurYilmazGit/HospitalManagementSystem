import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class manager_login extends HttpServlet {
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

        if(dbHandler.checkManager(username,password)){
            response.addCookie(new Cookie("JX_UserStuff",username));
            response.sendRedirect("/statistic.jsp");
        }
        else{
            request.setAttribute("status","fail");
            request.getRequestDispatcher("manager_login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("manager_login.jsp")
                .forward(request,response);
    }
}

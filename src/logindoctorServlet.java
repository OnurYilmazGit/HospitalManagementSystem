import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class logindoctorServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        if(dbHandler.checkdoctor(username,password)){
            //response.addCookie(new Cookie("User",username));
            response.sendRedirect("/userdoc.jsp");
        }
        else{
            request.setAttribute("status","fail");
            request.getRequestDispatcher("logindoctor.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("logindoctor.jsp")
                .forward(request,response);


    }
}

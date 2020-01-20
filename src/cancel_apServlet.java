import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class cancel_apServlet extends HttpServlet {
    private DBHandler dbHandler = new DBHandler();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession psession = request.getSession();
        String p_username = (String) psession.getAttribute("username");
        String d_username = request.getParameter("d_username");
        String date = request.getParameter("date");
        String time= request.getParameter("time");

        date=date+" "+time;


        try {
            dbHandler.del_ap(p_username,d_username,date);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

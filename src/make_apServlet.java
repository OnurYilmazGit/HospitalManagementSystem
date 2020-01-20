import javax.print.attribute.DateTimeSyntax;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class make_apServlet extends HttpServlet {
    private DBHandler dbHandler = new DBHandler();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession psession = request.getSession();
        String p_username = (String) psession.getAttribute("username");
        String d_username = request.getParameter("d_username");

        String time = request.getParameter("time");
        String DOBYear = request.getParameter("DOBYear");
        String DOBMonth = request.getParameter("DOBMonth");
        String DOBDay = request.getParameter( "DOBDay");
        String date = (DOBYear + "-" + DOBMonth + "-" + DOBDay);

         date=date+" "+time;


        try {
            dbHandler.makeap(p_username,d_username,date);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}

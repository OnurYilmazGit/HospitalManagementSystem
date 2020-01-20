import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class facilities_utilization extends HttpServlet {

    private DBHandler dbHandler = new DBHandler();
    ArrayList<ArrayList<String>> data = new ArrayList<>();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            data = dbHandler.statistic_of_aeo();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("dataout",data);
        request.getRequestDispatcher("facilities_utilization.jsp").forward(request,response);

    }

}

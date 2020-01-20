import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class searchdoctimeServlet extends HttpServlet {
    private DBHandler dbHandler = new DBHandler();
    ArrayList<ArrayList<String>> data = new ArrayList<>();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String date = request.getParameter("DATE WITH TIME");
        try {
            data = dbHandler.searchdoctime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //response.getWriter().write(String.valueOf(data));
        request.setAttribute("doctor",data);
        request.getRequestDispatcher("searchdoctime.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("doc",data);
        request.getRequestDispatcher("searchdoctime.jsp").forward(request,response);

    }
}

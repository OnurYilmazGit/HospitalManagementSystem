import javax.management.modelmbean.RequiredModelMBean;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class list_docapServlet extends HttpServlet {
    private DBHandler dbHandler = new DBHandler();
    ArrayList<ArrayList<String>> data = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        try {
            data = dbHandler.list_docap(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("dataout",data);
        request.getRequestDispatcher("list_docap.jsp").forward(request,response);
    }

}



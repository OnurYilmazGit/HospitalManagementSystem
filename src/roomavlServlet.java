import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class roomavlServlet extends HttpServlet {
    private DBHandler dbHandler = new DBHandler();
    ArrayList<ArrayList<String>> data = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            data = dbHandler.roomavl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //response.getWriter().write("[ROOM NO, DATE, START TIME, END TIME]" );
        //response.getWriter().write(String.valueOf(data));


        request.setAttribute("dataout",data);
        request.getRequestDispatcher("roomavl.jsp").forward(request,response);


    }

}
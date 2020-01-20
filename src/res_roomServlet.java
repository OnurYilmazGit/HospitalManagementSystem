import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class res_roomServlet extends HttpServlet {
    private DBHandler dbHandler = new DBHandler();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String no  = request.getParameter("no");
        String date = request.getParameter("date");
        String stime = request.getParameter("stime");
        String etime= request.getParameter("etime");

        try {
            dbHandler.reserve(Integer.parseInt(no),date,Double.parseDouble(stime),Double.parseDouble(etime));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        request.getRequestDispatcher("res_room.jsp")
                .forward(request, response);


    }
}

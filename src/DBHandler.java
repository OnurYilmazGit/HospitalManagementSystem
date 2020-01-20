import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class DBHandler {
    private static Statement stmt = null;
    public static PreparedStatement pstmt = null;
    public static Connection con;

    public void init() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        con = getConnection();
    }

    public static boolean checkdoctor (String y,String password) {
        boolean x = false;
        try {
            ArrayList<String> dataToReturn = new ArrayList<>();
            ResultSet rs = stmt.executeQuery("SELECT username FROM doctor ");
            while (rs.next()) {
                String username = rs.getString("username");
                dataToReturn.add(username);
            }
            if(dataToReturn.contains(y)) {


                ResultSet z = stmt.executeQuery("SELECT password FROM doctor where username='" + y + "'");
                while(z.next()) {
                    String pass = z.getString("password");

                    if(pass.equals(password)) {
                        x = true;
                    }
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }


    public static boolean checkManager (String y,String password) {
        boolean x = false;
        try {
            ArrayList<String> dataToReturn = new ArrayList<>();
            ResultSet rs = stmt.executeQuery("SELECT username FROM manager ");
            while (rs.next()) {
                String username = rs.getString("username");
                dataToReturn.add(username);
            }
            if(dataToReturn.contains(y)) {
                ResultSet z = stmt.executeQuery("SELECT password FROM manager where username='" + y + "'");
                while(z.next()) {
                    String pass = z.getString("password");
                    if(pass.equals(password)) {
                        x = true;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public static boolean checknurse (String y,String password) {
        boolean x = false;
        try {
            ArrayList<String> dataToReturn = new ArrayList<>();
            ResultSet rs = stmt.executeQuery("SELECT username FROM nurses ");
            while (rs.next()) {
                String username = rs.getString("username");
                dataToReturn.add(username);
            }
            if(dataToReturn.contains(y)) {


                ResultSet z = stmt.executeQuery("SELECT password FROM nurses where username='" + y + "'");
                while(z.next()) {
                    String pass = z.getString("password");

                    if(pass.equals(password)) {
                        x = true;
                    }
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public void manager_login(String username, String password,String fname, String lname) throws Exception {
        PreparedStatement create = con.prepareStatement("INSERT INTO manager (username,password,fname,lname) VALUES ('" + username + "','" + password + "','" + fname + "','" + lname + "')");
        create.execute();
        System.out.println("done");
    }

    public void create(String username, String password,String fname, String lname) throws Exception {
        PreparedStatement create = con.prepareStatement("INSERT INTO patients (username,password,fname,lname) VALUES ('" + username + "','" + password + "','" + fname + "','" + lname + "')");
        create.execute();
        System.out.println("done");
    }

    public void del_ap(String p_username, String d_username, String date) throws SQLException {
        System.out.println("done");
        PreparedStatement create = con.prepareStatement("delete from appointment where p_username = '"+p_username+"' and d_username='"+d_username +"' and date ='"+date+"'");
        create.execute();
        System.out.println("done");

    }

    public void makeap (String p_user, String d_user, String date ) throws SQLException {
        System.out.println(date);
        PreparedStatement create = con.prepareStatement("INSERT INTO appointment (p_username,d_username,date) VALUES ('" + p_user + "','" + d_user + "','" + date + "')");
        create.execute();
        System.out.println("done");
    }


    public static boolean check (String y,String password) {
        boolean x = false;
        try {
            ArrayList<String> dataToReturn = new ArrayList<>();
            ResultSet rs = stmt.executeQuery("SELECT username FROM patients ");
            while (rs.next()) {
                String username = rs.getString("username");
                dataToReturn.add(username);
            }
            if(dataToReturn.contains(y)) {


                ResultSet z = stmt.executeQuery("SELECT password FROM patients where username='" + y + "'");
                while(z.next()) {
                    String pass = z.getString("password");

                   if(pass.equals(password)) {
                       x = true;
                   }
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }


    public void reserve(int no, String date, Double stime, Double etime) throws SQLException {
        System.out.println("done");
        PreparedStatement create = con.prepareStatement("INSERT INTO rooms (room_no,date,room_stime,room_etime) VALUES ('" + no + "','" + date + "','" + stime + "','" + etime + "')");
        create.execute();
        System.out.println("done");
    }

    public ArrayList<ArrayList<String>> list_docap(String username) throws SQLException {
        ArrayList<ArrayList<String>> dataToReturn= new ArrayList<>();
        System.out.println("done");
        ResultSet rs = stmt.executeQuery("SELECT date FROM appointment where d_username = '"+username+"'");
        System.out.println("done");
        try {
            while (rs.next()) {
                String date = rs.getString("date");
                ArrayList<String> tempData = new ArrayList<>();
                tempData.add(date);
                dataToReturn.add(tempData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");
        System.out.println(dataToReturn);
        return dataToReturn;

    }
    public ArrayList<ArrayList<String>> aoe(String field) throws SQLException {

            ArrayList<ArrayList<String>> dataToReturn = new ArrayList<>();
            ResultSet rs = stmt.executeQuery("SELECT distinct (username),fname,lname FROM doctor where aoe = '"+field+"'");

            try {
                while (rs.next()) {
                    String username = rs.getString("username");
                    String fname = rs.getString("fname");
                    String lname = rs.getString("lname");
                    ArrayList<String> tempData = new ArrayList<>();
                    tempData.add(username);
                    tempData.add(fname);
                    tempData.add(lname);
                    dataToReturn.add(tempData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(dataToReturn);

            return dataToReturn;
        }

    public static ArrayList<ArrayList<String>>roomavl() throws SQLException {
        ArrayList<ArrayList<String>> dataToReturn = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("SELECT room_no,date,room_stime,room_etime FROM rooms");
        processUserResultSet(dataToReturn, rs);
        System.out.println(dataToReturn);

        return dataToReturn;
    }
    private static void processUserResultSet (ArrayList < ArrayList < String >> dataToReturn, ResultSet rs){
        try {
            while (rs.next()) {
                int room_no = rs.getInt("room_no");
                String date= rs.getString("date");
                Double room_stime = rs.getDouble("room_stime");
                Double room_etime = rs.getDouble("room_etime");
                ArrayList<String> tempData = new ArrayList<>();
                    tempData.add(Integer.toString(room_no));
                    tempData.add(date);
                    tempData.add(Double.toString(room_stime));
                    tempData.add(Double.toString(room_etime));
                dataToReturn.add(tempData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<String>> searchdoctime(String date) throws SQLException {
        ArrayList<ArrayList<String>> dataToReturn = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("SELECT d_username\n" +
                "from appointment\n" +
                "where d_username not in (SELECT d_username\n" +
                "from appointment natural join doctor\n" +
                "where date='"+date+"' and doctor.username=appointment.d_username\n" +
                ")");

        try {
            while (rs.next()) {
                String username = rs.getString("d_username");
                ArrayList<String> tempData = new ArrayList<>();
                tempData.add(username);
                dataToReturn.add(tempData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dataToReturn);

        return dataToReturn;
    }


    public ArrayList<ArrayList<String>> statistic_of_aeo() throws SQLException {

        ArrayList<ArrayList<String>> dataToReturn = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("SELECT doctor.aoe, COUNT(doctor.aoe) FROM appointment\n" +
                "INNER JOIN doctor \n" +
                "ON appointment.d_username = doctor.username\n" +
                "Group by(doctor.aoe);");

        try {
            while (rs.next()) {
                String aeo = rs.getString("aoe");
                String count = rs.getString("COUNT(doctor.aoe)");
                ArrayList<String> tempData = new ArrayList<>();
                tempData.add(aeo);
                tempData.add(count);
                dataToReturn.add(tempData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dataToReturn);
        return dataToReturn;
    }

    public ArrayList<ArrayList<String>> patientnumber() throws SQLException{

        ArrayList<ArrayList<String>> dataToReturn = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("Select date, count(date) from appointment group by(date);");

        try {
            while (rs.next()) {
                String date = rs.getString("date");
                String count = rs.getString("count(date)");
                ArrayList<String> tempData = new ArrayList<>();
                tempData.add(date);
                tempData.add(count);
                dataToReturn.add(tempData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataToReturn;

    }

    public static Connection getConnection() throws Exception {

        try {
            String url = "jdbc:mysql://localhost:3306/hospital2";
            String user = "root";
            String password = "bnm678hjk.";
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
            stmt= con.createStatement();
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
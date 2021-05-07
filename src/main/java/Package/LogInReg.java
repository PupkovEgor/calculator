package Package;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name="Log", urlPatterns="/LogCalc")

public class LogInReg extends HttpServlet {

    static byte go = 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        RequestCalc Calc = RequestCalc.fromRequestParameters(request);
        Calc.setAsRequestAttributesAndCalculate(request);

        switch (go){ //На какую страницу будет переход при нажатии на кнопку типа submit
            case 0: request.getRequestDispatcher("/LogIn.jsp").forward(request, response); break;
            case 1: request.getRequestDispatcher("/Form.jsp").forward(request, response); break;
            case 2: request.getRequestDispatcher("/Reg.jsp").forward(request, response); break;
            case 3: request.getRequestDispatcher("/FormAdm.jsp").forward(request, response); break;
        }
    }

    private static class RequestCalc {
        private final String log;
        private final String pas;
        private final String page;
        private final String fio;

        private RequestCalc (String first, String second,String page,String fio) {
            this.log = first;
            this.pas = second;
            this.page = page;
            this.fio = fio;
        }

        public static RequestCalc fromRequestParameters(HttpServletRequest request) {
            return new RequestCalc(
                    request.getParameter("login"),
                    request.getParameter("pass"),
                    request.getParameter("page"),
                    request.getParameter("fio")
                    );
        }

        public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
            Connection con =null;
            Statement stmt=null;
            ResultSet rs=null;
            ResultSet rs1=null;
            String arr[] ={"length","width","height","floor","otdelka"};
            if (page.equals("LogIn")) {
                try {
                    // opening database connection to MySQL server
                    con = getConnection();
                    // getting Statement object to execute query
                    stmt = con.createStatement();
                    //Проверка соответствия логина и пароля
                    String query = "SELECT id from accounts where login like '"+log+"' and pass like '"+pas+"'";

                    rs = stmt.executeQuery(query);

                    if (rs.next()){ //Если такой элемент существует
                        go=1;
                        String query1;

                        if (log.equals("admin")) {
                            go = 3;
                        }

                        for(int i =0;i<5;i++){
                            query1 = "SELECT "+arr[i]+" FROM settings WHERE type='uptWinter';";
                            rs1 = stmt.executeQuery(query1);
                            if (rs1.next()){
                            request.setAttribute("winter"+i,rs1.getString(arr[i]));
                            }
                            query1 = "SELECT "+arr[i]+" FROM settings WHERE type='uptSummer';";
                            rs1 = stmt.executeQuery(query1);
                            if (rs1.next()){
                                request.setAttribute("summer"+i,rs1.getString(arr[i]));
                            }
                        }
                        query1 = "SELECT fio FROM accounts WHERE login='"+log+"';";
                        rs1 = stmt.executeQuery(query1);
                        if (rs1.next()){
                            request.setAttribute("fio",rs1.getString("fio"));
                        }
                    }
                    else{
                        request.setAttribute("result", "Логин/Пароль не верен");
                        go = 0;
                    }

                }catch (NullPointerException sqlNPE){
                    request.setAttribute("result","Error1: "+sqlNPE.getLocalizedMessage());
                    go = 0;
                }
                catch (SQLException sqlEx) {
                    request.setAttribute("result","Error2: "+sqlEx.getSQLState());
                    go = 0;
                }
                finally {
                    //close connection ,stmt and resultset
                    try {con.close(); } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                    try {stmt.close(); } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                    try {rs.close();  } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                    try {rs1.close();  } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                }

            }

            else{
                go = 0;
                try {
                    // opening database connection to MySQL server
                     con = getConnection();
                    // getting Statement object to execute query
                    stmt = con.createStatement();
                    //Проверка на существование логина
                    String query = "SELECT id from accounts where login like '"+log+"'";
                    rs = stmt.executeQuery(query);
                    if (!rs.next()){
                        //Создание нового пользователя
                        query = "INSERT INTO accounts (login, pass, fio) VALUES ('"+log+"', '"+pas+"', '"+fio+"');";
                        stmt = con.createStatement();
                        stmt.executeUpdate(query);
                    }
                    else{
                        request.setAttribute("result", "Такой логин уже существует");
                        go = 2;
                    }

                }catch (NullPointerException sqlNPE){
                    request.setAttribute("result","1Error: "+sqlNPE.getMessage());
                    go = 2;
                }
                catch (SQLException sqlEx) {
                    request.setAttribute("result","2Error: "+sqlEx.getSQLState());
                    go = 2;
                } finally {
                    //close connection ,stmt and resultset
                    try {con.close(); } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                    try {stmt.close(); } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                    try {rs.close();  } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                }

            }
        }
    }

    public static Connection getConnection() { //Connection to DataBase
        String driver = "com.mysql.jdbc.Driver";
        final String url = "jdbc:mysql://remotemysql.com:3306/smszCuaCce";
        final String user = "smszCuaCce";
        final String password = "fjrxusR9mP";
        try {
            Class.forName(driver);
            java.sql.Connection con = DriverManager.getConnection(url,user,password);
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception " + e);
            return null;
        }
    }

}

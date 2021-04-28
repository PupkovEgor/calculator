package Package;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.Arrays;
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

        switch (go){
            case 0: request.getRequestDispatcher("/LogIn.jsp").forward(request, response); break;
            case 1: request.getRequestDispatcher("/Form.jsp").forward(request, response); break;
            case 2: request.getRequestDispatcher("/Reg.jsp").forward(request, response); break;
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
            //boolean lo = false;
            //boolean swi = true;
            //boolean ch = false;
            Connection con =null;
            Statement stmt=null;
            ResultSet rs=null;
            if (page.equals("LogIn")) {
                try {
                    con = getConnection();
                    // opening database connection to MySQL server

                    //con = DriverManager.getConnection(url, user, password);

                    // getting Statement object to execute query
                    stmt = con.createStatement();

                    String query = "SELECT id from accounts where login like '"+log+"' and pass like '"+pas+"'";
                    rs = stmt.executeQuery(query);

                    if (rs.next()){
                        go=1;
                    }
                    else{
                        request.setAttribute("result", "Логин/Пароль не верен");
                        go = 0;
                    }

                }catch (NullPointerException sqlNPE){
                    request.setAttribute("result","Error: "+sqlNPE.getMessage());
                    go = 0;
                }
                catch (SQLException sqlEx) {
                    request.setAttribute("result","Error: "+sqlEx.getSQLState());
                    go = 0;
                }
                finally {
                    //close connection ,stmt and resultset here
                    try {con.close(); } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                    try {stmt.close(); } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                    try {rs.close();  } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                }

            }

            else{
                go = 0;
                try {
                    // JDBC variables for opening and managing connection

                     con = getConnection();
                    // opening database connection to MySQL server

                    //con = DriverManager.getConnection(url, user, password);

                    // getting Statement object to execute query
                    stmt = con.createStatement();

                    String query = "SELECT id from accounts where login like '"+log+"'";
                    rs = stmt.executeQuery(query);
                    if (!rs.next()){
                        query = "INSERT INTO accounts (login, pass, fio) VALUES ('"+log+"', '"+pas+"', '"+fio+"');";
                        stmt = con.createStatement();
                        stmt.executeUpdate(query);
                    }
                    else{
                        request.setAttribute("result", "Такой логин уже существует");
                        go = 2;
                    }
                    //con.close();
                    //stmt.close();
                    //rs.close();
                }catch (NullPointerException sqlNPE){
                    request.setAttribute("result","1Error: "+sqlNPE.getMessage());
                    go = 2;
                }
                catch (SQLException sqlEx) {
                    request.setAttribute("result","2Error: "+sqlEx.getSQLState());
                    go = 2;
                } finally {
                    //close connection ,stmt and resultset here
                    try {con.close(); } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                    try {stmt.close(); } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                    try {rs.close();  } catch (NullPointerException sqn){ /**/} catch(SQLException se) { /* .*/ }
                }

            }
        }
    }
    public static Connection getConnection() {
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



/*public class LogInReg {

    void logWin() {
        JFrame LogInWindow = new JFrame("Вход");
        LogInWindow.setTitle("Вход");
        LogInWindow.setBounds(100, 100, 266, 290);
        LogInWindow.setResizable(false);

        JPanel panel = new JPanel();

        JLabel logl = new JLabel("Логин:");
        logl.setBounds(40,10,140,30);
        JLabel pasl = new JLabel("Пароль:");
        pasl.setBounds(40,70,140,30);
        JLabel info = new JLabel();
        info.setBounds(10, 217,250,30);

        JButton enter = new JButton("Войти");
        JButton reg = new JButton("Регистрация");
        JButton unhide = new JButton();

        JTextField log = new JTextField();
        log.setBounds(40,40,140,30);
        JPasswordField pas = new JPasswordField();
        pas.setBounds(40,100,140,30);

        enter.setBounds(50,135,120,40);
        reg.setBounds(50,176,120,40);
        unhide.setBounds(181,102,25,25);

        reg.addActionListener(e -> {
            info.setText("");
            if (reg.getText().equals("Регистрация")){
                reg.setText("Назад");
                LogInWindow.setTitle("Регистрация");
                enter.setText("Регистрация");
            }
            else{
                reg.setText("Регистрация");
                LogInWindow.setTitle("Вход");
                enter.setText("Войти");
            }
        });

        enter.addActionListener(e -> {
            info.setText("");
            if (enter.getText().equals("Войти")){
                if (log.getText().equals("admin")&&(Arrays.equals(pas.getPassword(),new char[]{'a','d','m','i','n'}))){ //аккаунт администратора
                    Admin adm = new Admin();
                    adm.logWin();
                    Calculator calc = new Calculator();
                    calc.calculate();
                    LogInWindow.dispose();
                }
                else{
                    //Проверка логина-пароля
                    try{
                        File file = new File("./src/main/resources","File.txt");
                        File fjar = new File("..","File.txt");
                        if (file.exists()||fjar.exists()){
                        FileInputStream input = new FileInputStream(file);

                        Calculator calc = new Calculator();
                        calc.calculate();
                        LogInWindow.dispose();
                    }
                    else{
                        file.createNewFile();
                        info.setText("Данного пользователя не существует");
                    }
                    }
                    catch (IOException a){System.out.print(a);}

                }
            }
            else{
                //Регистрация нового пользователя
           }
        });

        unhide.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                pas.setEchoChar((char)0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pas.setEchoChar('•');
            }

            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        panel.add(logl);
        panel.add(pasl);
        panel.add(log);
        panel.add(pas);
        panel.add(unhide);
        panel.add(enter);
        panel.add(reg);
        panel.add(info);
        panel.setLayout(null);
        LogInWindow.add(panel);

        LogInWindow.setVisible(true);
        LogInWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}*/

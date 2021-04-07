package Package;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class LogInReg {

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
}

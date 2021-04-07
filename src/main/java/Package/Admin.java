package Package;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Admin {

    void logWin() {
        JFrame AdmWindow = new JFrame("---");
        AdmWindow.setTitle("---");
        AdmWindow.setBounds(100, 100, 300, 300);
        AdmWindow.setResizable(false);

        AdmWindow.setVisible(true);
    }

    void defaultSet(){
        String data = "$sum = 3 3 1 2.5\n$win = 6 7 2 4";
        try{
            File file = new File("./src/main/resources","Settings.txt");
            if (file.exists()){
                FileWriter def = new FileWriter("./src/main/resources/Settings.txt", false);
                def.write(data);
                def.close();
            }
        }
        catch (IOException e){System.out.print(e);}
    }


}

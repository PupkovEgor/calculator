package Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinInfo implements ActionListener {
	
	
	public void actionPerformed(ActionEvent arg0) {
			JFrame info = new JFrame();
			JPanel panel = new JPanel();
			panel.setLayout (new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			info.setTitle ("Информация");
			info.setBounds(481,288,250,130);
			JLabel laba_info[] = new JLabel[4];
			laba_info = infoIn(laba_info);
			
			for (int i=0 ; i<4 ;i++) {
				laba_info[i].setBounds(10,10+30*i,130,30);
				panel.add(laba_info[i]);
			}

			JButton button_back = new JButton("Назад");
			button_back.setBounds(10, 165, 130, 30);
			panel.add(button_back);
			
			info.add(panel);
			info.setVisible(true);
			
			button_back.addActionListener(actionEvent ->  {
			    	info.setVisible(false); 
			    });
			
			

}
	public static JLabel[] infoIn(JLabel l[]) {
		l[0] = new JLabel("Салихов Р.Н - Модератор");
		l[1] = new JLabel("Камолкин В.С - Разработчик 1");
		l[2] = new JLabel("Иутин А.С - Разработчик 2");
		l[3] = new JLabel("Бесполитов Д.А - Разработчик 3");
		return l;
	}
}

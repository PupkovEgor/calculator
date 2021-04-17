package Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Package.House.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@WebServlet(name="Calc", urlPatterns="/Calculator")
public class Calculator extends  HttpServlet   {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		 
		request.getRequestDispatcher("/Result.jsp").forward(request, response);
		
	}
	private static class RequestCalc {
		private final String dl;
		private final String sh;
		private final String vis;
		private final String fl_count;
		private final String rab_count;
		private final String otd;
		private final String ord;
		private final String clear;
		private final String pr;
		private final String pres;
		//private final String shirina;
		
		private double result;
						
		private RequestCalc (String dlina, String shirina, String visota, String floor_count, String worker_count, String otdelka, String clearing, String order, String promo, String preset) {
			this.dl = dlina;
			this.sh = shirina;
			this.vis = visota;
			this.fl_count = floor_count;
			this.rab_count = worker_count;
			this.otd = otdelka;
			this.clear = clearing;
			this.ord = order;
			this.pr = promo;
			this.pres = preset;
			
			
			}
		
		public static RequestCalc fromRequestParameters (HttpServletRequest request) {
			return new RequestCalc(
				request.getParameter("length"),
				request.getParameter("width"),
				request.getParameter("height"),
				request.getParameter("floor"),
				request.getParameter("worker"),
				request.getParameter("otdelka"),
				request.getParameter("order"),
				request.getParameter("clearing"),
				request.getParameter("promo"),
				request.getParameter("preset")
				);
			}
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("result_length", dl);
			request.setAttribute("result_width", sh);
			request.setAttribute("result_height", vis);
			request.setAttribute("result_floor", fl_count);
			request.setAttribute("result_worker", rab_count);
			request.setAttribute("result_otdelka", otd);
			request.setAttribute("result_order", ord);
			request.setAttribute("result_clearing", clear);
			request.setAttribute("result_promo", pr);
			request.setAttribute("result_preset", pres);
			
			
			
			double length_try;
			double width_try;
			double height_try;
			double floor_try;
			double worker_try;
			
			
			
			try { 
			length_try=Double.parseDouble(dl);
			width_try=Double.parseDouble(sh);
			height_try=Double.parseDouble(vis);
			floor_try=Double.parseDouble(fl_count);
			worker_try=Double.parseDouble(rab_count);
			
			
			
			}
			catch (NumberFormatException e) {
				 length_try = 0;
				 width_try = 0;
				 height_try = 0;
				 floor_try = 0;
				 worker_try = 0;	
			}
			
			result=length_try + width_try + height_try + floor_try + worker_try;
			request.setAttribute("result", result);
		}
		
	}
	

/*static JLabel[] labels;
static JTextField[] fields;
static	JComboBox jcomboBox;
static double[] sum;
static double[] win;


public static void Window() {
	
	JFrame  MainWindow = new JFrame("Калькулятор стоимости строительства частного дома");	
	MainWindow.setTitle ("Калькулятор стоимости строительства частного дома");
	MainWindow.setBounds(100,100,520,410);
	MainWindow.setResizable(false); 
	
	labels = new JLabel[13];
	for(int i = 0; i < 11; i++) {
		labels[i] = new JLabel();

	}
	labels[0].setText("Габариты: ");
	labels[1].setText("Длина: ");
	labels[2].setText("Ширина: ");
	labels[3].setText("Высота: ");
	labels[4].setText("Кол. этажей: ");
	labels[5].setText("Доп. работники: ");
	labels[6].setText("Внутренняя отделка: ");
	labels[7].setText("Срочный заказ: ");
	labels[8].setText("Расчистка участ	ка: ");
	labels[9].setText("Промокод: ");
	labels[10].setText("Итого: ");
	
	fields = new JTextField[6];
	
	
	
		
	
	for(int i = 0; i < 6; i++) {
		fields[i] = new JTextField();
		
	}
	
	for(int i = 0; i < 5; i++) {
		fields[i].setBounds(135, (30 * i) + 40, 150, 30);
		

	}
	fields[4].setText("0");
	
	fields[5].setBounds(135, 280, 150, 30);
	
	JPanel main_panel = new JPanel();
	
	for(int i = 0 ; i < 11; i++) {
		labels[i].setBounds(5, (30 * i) + 10 , 130, 30);
	}
	
	String[] arrayBox  = { // создание элементов для jcombobox
            "Нет",
            "Черновая отделка",
            "Под ключ"
    };
	
	String[] arrayBox1  = { // создание элементов для jcombobox
			"Персональный",
			"Летний дом",
			"Зимний дом"
	};
	
	
	
    jcomboBox = new JComboBox(arrayBox);//создание jcombobox
    jcomboBox.setBounds(135, 190, 150, 30);
    JComboBox jcomboBox1 = new JComboBox(arrayBox1);//создание jcombobox
	jcomboBox1.setBounds(290, 40, 150, 30);
	
    
    JCheckBox jcheckBox = new JCheckBox();
    JCheckBox jcheckBox2 = new JCheckBox();

    jcheckBox.setBounds(135, 220, 30, 30);
    jcheckBox2.setBounds(135, 250, 30, 30);

    
    
	main_panel.add(jcheckBox);
	main_panel.add(jcheckBox2);
	main_panel.add(jcomboBox1);
	main_panel.add(jcomboBox);



	for(int i = 0; i < 6; i++) {
		main_panel.add(fields[i]);
	}

	
	
	for(int i = 0; i < 11; i++) {
		main_panel.add(labels[i]);
	}
	
	JButton infoB = new JButton("Информация");
	ActionListener actionListener = new WinInfo(); //создаем слушатель
	infoB.addActionListener(actionListener);
	
	infoB.setBounds(380,280, 110, 30);
	
	main_panel.add(infoB);
	
	
    JButton button_calc = new JButton("Расчет"); // Добавление кнопки расчета
    button_calc.setBounds(360,230,140,30); // задаём ей координаты
    
    main_panel.add(button_calc); //добавление кнопки расчета на главную панель
    
     
    
   
    JButton buttonLeave = buttonCreate(); // создание кнопки "Выход"
    buttonLeave.setBounds(360,325,140,30);
    buttonLeave.addActionListener(actionEvent ->  {
       	System.exit(1);
    	
    	 });
   
    main_panel.add(buttonLeave);
   
    labels[10].setBounds(5, 310 , 280, 30);
    
    jcomboBox1.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e) {
			preset((String)jcomboBox1.getSelectedItem());
		}
	});


    ActionListener actionListenerCalc = new ActionListener() { //слушатель расчета
    	
        public void actionPerformed(ActionEvent e) {
        	String f[] = new String[6];
        	for(int i = 0 ; i < 6; i++) {
        		f[i]= fields[i].getText(); // Приравние массива field c получением текста к массиву f
        	}
        	labels[10].setText(sobitie(f,jcheckBox.isSelected(),jcheckBox2.isSelected(),(String)jcomboBox.getSelectedItem(),(String)jcomboBox1.getSelectedItem()));
        	// добавление данных в метод sobitie
        }
    };


    button_calc.addActionListener(actionListenerCalc); //добавляем слушатель к кнопке
	main_panel.setLayout(null);
	MainWindow.add(main_panel);
	MainWindow.setVisible(true);
	MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

static Dom dom;
public static JButton buttonCreate() { //метод создания кнопки "Выход"
	JButton buttonLeave = new JButton();
	buttonLeave.setText("Выход");
	
	return buttonLeave;
}

public static void preset(String jcomboBox1){
	setUp();
	switch (jcomboBox1){
		case "Персональный":{
			dom = new PersonalHouse();
			open();
			break;
			
		}
		case "Летний дом":{
			dom = new SummerHouse();
			dom.setLenght(sum[0]);
			dom.setWeight(sum[1]);
			dom.setKolE((int)sum[2]);
			dom.setVisota(sum[3]);
			dom.setVnOt();
			close();
			break;
		}
		case "Зимний дом":{
			dom = new WinterHouse();
			dom.setLenght(win[0]);
			dom.setWeight(win[1]);
			dom.setKolE((int)win[2]);
			dom.setVisota(win[3]);
			dom.setVnOt();
			close();
			break;
		}
	}
}

public static void close(){
	int a=0;
	
	switch(dom.getVnOt()){
		case "Нет": {a=0;break;}
		case "Под ключ": {a=2;break;}
	}
	fields[0].setEditable(false);
	fields[1].setEditable(false);
	fields[2].setEditable(false);
	fields[3].setEditable(false);
	jcomboBox.setSelectedIndex(a);
	jcomboBox.setEnabled(false);
	fields[0].setText(Double.toString(dom.getLenght()));
	fields[1].setText(Double.toString(dom.getWeight()));
	fields[2].setText(Double.toString(dom.getVisota()));
	fields[3].setText(Integer.toString(dom.getKolE()));

}
public static void open(){
	fields[0].setEditable(true);
	fields[1].setEditable(true);
	fields[2].setEditable(true);
	fields[3].setEditable(true);
	jcomboBox.setEnabled(true);
}


	static String item;

public static String sobitie (String fields[], boolean jcheckBox, boolean jcheckBox2, String jcomboBox,String jcomboBox1 ){//получение данных
	int summa = 5000;
	double srochno = 0.0;
	double chistka = 0.0;
	double promo = 1.0;
	
	switch (fields[5]) {
	case "PROMO5": 
		promo = 0.95;
		break;
	case "PROMO10": 
		promo = 0.90;
		break;
	case "PROMO15": 
		promo = 0.85;
		break;
	}
	
	if (jcheckBox ) {
		srochno = 10000.0;
	}
	if (jcheckBox2 ) {
		chistka = 5000.0;
	}

    try{ // отлавливание ошибки при переводе строки в число 
        double a = Double.parseDouble(fields[0]); // преобразование строк в тип double
        double b = Double.parseDouble(fields[1]);
        double c = Double.parseDouble(fields[2]);
        int f = Integer.parseInt(fields[3]); // преобразование строк в тип int
        int rabotnik = Integer.parseInt(fields[4]);
        if (rabotnik < 0 || rabotnik > 5) {
        	
        	return "ERROR: неверное кол-во работников"; //Возвращение значения
        }else {
        	
       
        if (a < 1 || b < 1  ) { //проверка правильности ввода чисел
        	
        	return "ERROR: неверны размеры длины или ширины";
        }
        else {
         if (c < 2) {
        	 
        	 return "ERROR: неверная высота дома";
         }else {
        	 if(f < 1 || f > 3) {
        		 
                 return "ERROR: недопустимое количество этажей";
        	 }else {
        		 if (jcomboBox1.equals("Персональный")){
					 dom = new PersonalHouse();
					 dom.setLenght(a);
					 dom.setWeight(b);
					 dom.setKolE(f);
					 dom.setVisota(c);
				 }

        		 rabotnik = rabotnik * summa;
        		 Home home = new House();
        		 Otdelka otdelka = new House();
        		 String item = (String)jcomboBox;
        		 String result =String.format("%.2f",(home.GetPrice(dom.getLenght(),dom.getWeight(),dom.getVisota(),dom.getKolE())+
				 otdelka.OtdelkaPrice(item,dom.getLenght()*dom.getWeight(),dom.getKolE())+ srochno + chistka + rabotnik)*promo);// Расчет итоговой стоимости
				 return "Итого: " + result + " руб.";
        	 }
         }
       
        }
    }
    }
    catch (NumberFormatException nfe) { 
       // labels[10].setText("ERROR: Введите число"); //вывод сообщения в случае ошибки
    	return "ERROR: Введите число";
    }
    
}

static void setUp(){
	sum = new double[4];
	win = new double[4];
	int last;
	String s;
	String subs;
	try{
		File file = new File("./src/main/resources","Settings.txt");
		if (file.exists()){
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				s = scanner.nextLine();
				if (s.startsWith("$sum")) {
					for (int i =3;i>=0; i--){
						last = s.lastIndexOf(" ");
						subs = s.substring(last,s.length());
						sum[i] = Double.parseDouble(subs);
						s = s.substring(0,last);
					}
				}
				if (s.startsWith("$win")){
					for (int i =3;i>=0; i--){
						last = s.lastIndexOf(" ");
						subs = s.substring(last,s.length());
						win[i] = Double.parseDouble(subs);
						s = s.substring(0,last);
					}
				}
			}
			scanner.close();
		}
		else{
			file.createNewFile();
			Admin adm = new Admin();
			adm.defaultSet();
			setUp();
		}
	}
	catch (IOException e){System.out.print(e);}
}
*/
}

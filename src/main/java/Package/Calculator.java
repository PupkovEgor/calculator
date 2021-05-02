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
	public static String dlina;
	public static String shirina;
	public static String visota;
	public static String floor_count;
	public static String worker_count;
	public static String otdelka;
	public static boolean express_order;
	public static boolean clearing;
	public static String promo;
	public static String preset;
	static String[] fields;
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
		private  String rab_count;
		private  String otd;
		private final String ord;
		private final String clear;
		private final String pr;
		private  String pres;
		private  String shirina;
		
		private String result;
						
		private RequestCalc (String dlina, String shirina, String visota, String floor_count, String worker_count, String otdelka, String order, String clearing, String promo, String preset) {
			this.dl = dlina;
			this.sh = shirina;
			this.vis = visota;
			this.fl_count = floor_count;
			this.rab_count = worker_count;
			this.otd = otdelka;
			this.ord = order;
			this.clear = clearing;			
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
			switch (otd){
            case "1": otd = "Heт"; break;
            case "2": otd = "Чepнoвaя"; break;
            case "3": otd = "Под ключ"; break;
		}
			
			switch (pres){
            case "1": pres = "Персональный"; break;
            case "2": pres = "Летний дом"; break;
            case "3": pres = "Зимний дом"; break;
		}
			if (rab_count.equals("")) {
				rab_count = "0";
			}
			request.setAttribute("result_length", dl);
			request.setAttribute("result_width", sh);
			request.setAttribute("result_height", vis);
			request.setAttribute("result_floor", fl_count);
			request.setAttribute("result_worker", rab_count);
			request.setAttribute("result_otdelka", otd);
			if (ord != null){
                request.setAttribute("result_order", "Да");
                express_order = true;
			}
            else{
                request.setAttribute("result_order", "Нет");
                express_order = false;
            }
            if (clear != null){
                request.setAttribute("result_clearing", "Да");
                clearing = true;
            }
            else{
                request.setAttribute("result_clearing", "Нет");
                clearing = false;
            }
			request.setAttribute("result_promo", pr);
			request.setAttribute("result_preset", pres);
			
			dlina = dl;
			shirina = sh;
			visota = vis;
			floor_count = fl_count;
			worker_count = rab_count;
			otdelka = otd;
			promo = pr;
			preset = pres;
			
			/*double length_try;
			double width_try;
			double height_try;
			double floor_try;
			double worker_try;*/
			
			fields = new String[6];
			fields[0]=dlina;
			fields[1]=shirina;
			fields[2]=visota;
			fields[3]=floor_count;
			fields[4]=worker_count;
			fields[5]=promo;
			
			result = sobitie(fields,express_order,clearing,otdelka,preset);
			request.setAttribute("result", result);
			/*try { 
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
			}*/
			
		}
		
	}
	


static double[] sum;
static double[] win;


//public static void Window() {
	
	

static Dom dom;


public static void preset(String jcomboBox1){
	//setUp();
	switch (preset){
		/*case "Персональный":{
			dom = new PersonalHouse();
			break;
			
		}*/
		case "Летний дом":{
			dom = new SummerHouse();
			dom.setLenght(Double.parseDouble(fields[0]));
			dom.setWeight(Double.parseDouble(fields[1]));
			dom.setKolE(Integer.parseInt(fields[3]));
			dom.setVisota(Double.parseDouble(fields[2]));
			dom.setVnOt();
			//close();
			break;
		}
		case "Зимний дом":{
			dom = new WinterHouse();
			dom.setLenght(Double.parseDouble(fields[0]));
			dom.setWeight(Double.parseDouble(fields[1]));
			dom.setKolE(Integer.parseInt(fields[3]));
			dom.setVisota(Double.parseDouble(fields[2]));
			//close();
			break;
		}
	}
}

/*public static void close(){
	int a=0;
	
	switch(dom.getVnOt()){
		case "Нет": {a=0;break;}
		case "Под ключ": {a=2;break;}
	}
	
	fields[0] = Double.toString(dom.getLenght());
	fields[1] = Double.toString(dom.getWeight());
	fields[2] = Double.toString(dom.getVisota());
	fields[3] = Integer.toString(dom.getKolE());
	
}*/



	static String item;

public static String sobitie (String fields[], boolean express_order, boolean clearing, String otdelka,String jcomboBox1 ){//получение данных
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
	
	if (express_order ) {
		srochno = 10000.0;
	}
	if (clearing ) {
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
        		 Otdelka otdelka_type = new House();
        		 String item = (String)otdelka;
        		 //System.out.print(dom.getWeight());
        		 
        		 preset(jcomboBox1);
        		 
        		 
        		 String result =String.format("%.2f",(home.GetPrice(dom.getLenght(),dom.getWeight(),dom.getVisota(),dom.getKolE())+
				 otdelka_type.OtdelkaPrice(otdelka,dom.getLenght()*dom.getWeight(),dom.getKolE())+ srochno + chistka + rabotnik)*promo);// Расчет итоговой стоимости
				 return result + " руб.";
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

/*static void setUp(){
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
				if (s.s.dl = dlina;
			this.sh = shirina;
			this.vis = visota;
			this.fl_count = floor_count;
			this.rab_count = worker_count;
			this.otd = otdelka;
			this.ord = order;
			this.clear = clearing;			
			this.pr = promo;
			this.pres = preset;startsWith("$sum")) {
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
}*/

}

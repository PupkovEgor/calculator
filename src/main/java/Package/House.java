package Package;

public class House implements Home, Otdelka {

	@Override
	public Double GetPrice(double Dlina, double Shirina, double Visota, int CountOfFloor) {
		
		Double Price, Square, PriceOfOneMeter = 50000.0;
		Square = Dlina*Shirina;
		Price = Square * PriceOfOneMeter * CountOfFloor;
		return Price;
	}
	@Override
	public Double OtdelkaPrice(String OtdelkaValue, double square, int CountOfFloor) {
		double price=0;
		switch (OtdelkaValue) {
		case  ("Нет"):
			price=0;
			break;
		case  ("Черновая отделка"):
			price = square * 5000 * CountOfFloor;	
			break;
		case  ("Под ключ"):
			price = square * 10000 * CountOfFloor;
			break;
		}
		return price;
	}
}

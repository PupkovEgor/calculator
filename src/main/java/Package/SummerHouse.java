package Package;

public class SummerHouse extends Dom {
    String otd;
    @Override
    public void setVnOt(){//double a,int f
        otd = "Нет";
        //Otdelka otdelka = new House();
        //otdelka.OtdelkaPrice("Нет",a,f);
    }
    @Override
    public String getVnOt(){
        return otd;
    }
}

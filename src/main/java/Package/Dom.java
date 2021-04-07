package Package;

public abstract class Dom {
    double lenght;
    double weight;
    int KolE;
    double visota;
    String otd;

    public void setLenght(double lenght){
        this.lenght = lenght;
    }
    public double getLenght(){
        return lenght;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }

    public void setKolE(int KolE){
        this.KolE = KolE;
    }
    public int getKolE(){
        return KolE;
    }

    public void setVnOt(){

    }
    public String getVnOt(){
        return otd;
    }
    public void setVisota(double visota){
        this.visota = visota;
    }
    public double getVisota(){
        return visota;
    }

}

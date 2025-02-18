package Modell;

public class Produkte {
    int id;
    String Name;
    double Preis;
    String Universum;

    @Override
    public String toString() {
        return "Produkten{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Preis=" + Preis +
                ", Universum='" + Universum + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPreis() {
        return Preis;
    }

    public void setPreis(double preis) {
        Preis = preis;
    }
    public String getUniversum() {
        return Universum;
    }

    public void setUniversum(String universum) {
        Universum = universum;
    }

    public Produkte(int id, String name, double preis, String universum) {
        this.id = id;
        Name = name;
        Preis = preis;
        Universum = universum;
    }
}

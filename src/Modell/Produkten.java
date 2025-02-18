package Modell;

public class Produkten {
    int id;
    String Name;
    int Preis;
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

    public int getPreis() {
        return Preis;
    }

    public void setPreis(int preis) {
        Preis = preis;
    }

    public String getUniversum() {
        return Universum;
    }

    public void setUniversum(String universum) {
        Universum = universum;
    }

    public Produkten(int id, String name, int preis, String universum) {
        this.id = id;
        Name = name;
        Preis = preis;
        Universum = universum;
    }
}

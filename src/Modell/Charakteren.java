package Modell;

import java.util.List;

public class Charakteren {
    int id;
    String Name;
    String Region;
    List<Produkten> produktens;

    @Override
    public String toString() {
        return "Charakteren{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Region='" + Region + '\'' +
                ", produktens=" + produktens +
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

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public List<Produkten> getProduktens() {
        return produktens;
    }

    public void setProduktens(List<Produkten> produktens) {
        this.produktens = produktens;
    }

    public Charakteren(int id, String name, String region, List<Produkten> produktens) {
        this.id = id;
        Name = name;
        Region = region;
        this.produktens = produktens;
    }
}

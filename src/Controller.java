import Modell.Charakteren;
import Modell.Produkten;

public class Controller {
    Repo<Produkten> produktenRepo = new Repo<>();
    Repo<Charakteren> charakterenRepo = new Repo<>();

    public Controller(Repo<Produkten> produktenRepo, Repo<Charakteren> charakterenRepo) {
        this.produktenRepo = produktenRepo;
        this.charakterenRepo = charakterenRepo;
    }

//    Filtern nach Ursprungsuniversum (0.5 Punkte)
//Der Benutzer kann sich nur die Charaktere aus einem bestimmten Region anzeigen lassen.
    public void filterByUniversum(String universum) {
        charakterenRepo.getAll().stream()
                .filter(charakteren -> charakteren.getRegion().equalsIgnoreCase(universum))
                .forEach(System.out::println);
    }


}


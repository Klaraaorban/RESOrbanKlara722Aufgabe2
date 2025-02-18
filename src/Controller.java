import Modell.Charaktere;
import Modell.Produkte;

public class Controller {
    Repo<Produkte> produktenRepo = new Repo<>();
    Repo<Charaktere> charakterenRepo = new Repo<>();

    public Controller(Repo<Produkte> produktenRepo, Repo<Charaktere> charakterenRepo) {
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

    //Anzeige von Charakteren, die Produkte aus einem bestimmten Universum gekauft haben (0.5 Punkte)
//Der Benutzer gibt ein Universum ein.
//Die Anwendung zeigt alle Charaktere an, die Produkte aus diesem Universum gekauft haben.
//Sortierung: Alphabetisch nach Namen (aufsteigend).
    public void filterByProductUniversum(String universum) {
        charakterenRepo.getAll().stream()
                .filter(charakteren -> charakteren.getProduktens().stream()
                        .anyMatch(produkten -> produkten.getUniversum().equals(universum)))
                .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
                .forEach(System.out::println);
    }


    //    Sortieren der Produkte eines Charakters nach Preis (1 Punkt)
//Der Benutzer wählt einen Charakter und gibt die Sortierart ein:
//- Aufsteigend (günstigster zuerst)
//- Absteigend (teuerster zuerst)

    public void sortProductsByPrice(String charakterName, String order) {
        charakterenRepo.getAll().stream()
                .filter(charakteren -> charakteren.getName().equals(charakterName))
                .findFirst()
                .ifPresent(charakteren -> {
                    charakteren.getProduktens().stream()
                            .sorted((p1, p2) -> order.equals("asc") ? Double.compare(p1.getPreis(), p2.getPreis()) : Double.compare(p2.getPreis(), p1.getPreis()))
                            .forEach(System.out::println);
                });


    }
}

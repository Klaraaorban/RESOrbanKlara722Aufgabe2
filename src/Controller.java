import Modell.Charakteren;
import Modell.Produkten;

public class Controller {
    Repo<Produkten> produktenRepo = new Repo<>();
    Repo<Charakteren> charakterenRepo = new Repo<>();

    public Controller(Repo<Produkten> produktenRepo, Repo<Charakteren> charakterenRepo) {
        this.produktenRepo = produktenRepo;
        this.charakterenRepo = charakterenRepo;
    }
}


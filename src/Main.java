import Modell.Charakteren;
import Modell.Produkten;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repo<Produkten> produktenRepo = new Repo<>();
        Repo<Charakteren> charakterenRepo = new Repo<>();
        Controller controller = new Controller(produktenRepo, charakterenRepo);
        Console consoleView = new Console(controller);
        Scanner scanner = new Scanner(System.in);

        List<Produkten> produkte = new ArrayList<>();
        produkte.add(new Produkten(1,"Mjolnir", 500, "Asgard"));
        produkte.add(new Produkten(2,"Vibranium-Schild", 700, "Wakanda"));
        produkte.add(new Produkten(3,"Infinity Gauntlet", 10000, "Titan"));
        produkte.add(new Produkten(4,"Web-Shooter", 250, "Terra"));
        produkte.add(new Produkten(5,"Arc-Reaktor", 1500, "Terra"));
        produkte.add(new Produkten(6,"Norn Stones", 1200, "Asgard"));
        produkte.add(new Produkten(7,"Quantum Suit", 3000, "Terra"));
        produkte.add(new Produkten(8,"X-Gene Serum", 850, "X-Mansion"));
        produkte.add(new Produkten(9,"Cosmic Cube", 9000, "Multiverse"));
        produkte.add(new Produkten(10,"Darkhold", 2000, "Multiverse"));

        Produkten produkten1 = new Produkten(1,"Mjolnir", 500, "Asgard");
        Produkten produkten2 = new Produkten(2,"Vibranium-Schild", 700, "Wakanda");
        Produkten produkten3 = new Produkten(3,"Infinity Gauntlet", 10000, "Titan");
        Produkten produkten4 = new Produkten(4,"Web-Shooter", 250, "Terra");
        Produkten produkten5 = new Produkten(5,"Arc-Reaktor", 1500, "Terra");
        Produkten produkten6 = new Produkten(6,"Norn Stones", 1200, "Asgard");
        Produkten produkten7 = new Produkten(7,"Quantum Suit", 3000, "Terra");
        Produkten produkten8 = new Produkten(8,"X-Gene Serum", 850, "X-Mansion");
        Produkten produkten9 = new Produkten(9,"Cosmic Cube", 9000, "Multiverse");
        Produkten produkten10 = new Produkten(10,"Darkhold", 2000, "Multiverse");
produktenRepo.create(produkten1);
        produktenRepo.create(produkten2);
        produktenRepo.create(produkten3);
        produktenRepo.create(produkten4);
        produktenRepo.create(produkten5);
        produktenRepo.create(produkten6);
        produktenRepo.create(produkten7);
        produktenRepo.create(produkten8);
        produktenRepo.create(produkten9);
        produktenRepo.create(produkten10);

        List<Charakteren> charaktere = new ArrayList<>();
        Charakteren c1 = new Charakteren(1, "Thor", "Asgard", List.of(produkten1, produkten5, produkten9));

        Charakteren c2 = new Charakteren(2, "Black Panther", "Wakanda", List.of(produkten2, produkten8));
        Charakteren c3 = new Charakteren(3, "Iron Man", "Terra", List.of(produkten5, produkten7, produkten4));
        Charakteren c4 = new Charakteren(4, "Spider-Man", "Terra", List.of(produkten4, produkten9));

        Charakteren c5 = new Charakteren(5, "Doctor Strange", "Multiverse", List.of(produkten10, produkten9, produkten3));

        charakterenRepo.create(c1);
        charakterenRepo.create(c2);
        charakterenRepo.create(c3);
        charakterenRepo.create(c4);
        charakterenRepo.create(c5);

        consoleView.start();
        scanner.close();
    }

}
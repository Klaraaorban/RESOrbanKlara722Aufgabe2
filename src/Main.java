import Modell.Charaktere;
import Modell.Produkte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //finish
        Repo<Produkte> produktenRepo = new Repo<>();
        Repo<Charaktere> charakterenRepo = new Repo<>();
        Controller controller = new Controller(produktenRepo, charakterenRepo);
        Console consoleView = new Console(controller);
        Scanner scanner = new Scanner(System.in);

        List<Produkte> produkte = new ArrayList<>();
        produkte.add(new Produkte(1,"Mjolnir", 500, "Asgard"));
        produkte.add(new Produkte(2,"Vibranium-Schild", 700, "Wakanda"));
        produkte.add(new Produkte(3,"Infinity Gauntlet", 10000, "Titan"));
        produkte.add(new Produkte(4,"Web-Shooter", 250, "Terra"));
        produkte.add(new Produkte(5,"Arc-Reaktor", 1500, "Terra"));
        produkte.add(new Produkte(6,"Norn Stones", 1200, "Asgard"));
        produkte.add(new Produkte(7,"Quantum Suit", 3000, "Terra"));
        produkte.add(new Produkte(8,"X-Gene Serum", 850, "X-Mansion"));
        produkte.add(new Produkte(9,"Cosmic Cube", 9000, "Multiverse"));
        produkte.add(new Produkte(10,"Darkhold", 2000, "Multiverse"));

        Produkte produkten1 = new Produkte(1,"Mjolnir", 500.0, "Asgard");
        Produkte produkten2 = new Produkte(2,"Vibranium-Schild", 700.6, "Wakanda");
        Produkte produkten3 = new Produkte(3,"Infinity Gauntlet", 10000.0, "Titan");
        Produkte produkten4 = new Produkte(4,"Web-Shooter", 250.9, "Terra");
        Produkte produkten5 = new Produkte(5,"Arc-Reaktor", 1500.8, "Terra");
        Produkte produkten6 = new Produkte(6,"Norn Stones", 1200.1, "Asgard");
        Produkte produkten7 = new Produkte(7,"Quantum Suit", 3000, "Terra");
        Produkte produkten8 = new Produkte(8,"X-Gene Serum", 850, "X-Mansion");
        Produkte produkten9 = new Produkte(9,"Cosmic Cube", 9000.12, "Multiverse");
        Produkte produkten10 = new Produkte(10,"Darkhold", 2000, "Multiverse");
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

        List<Charaktere> charaktere = new ArrayList<>();
        Charaktere c1 = new Charaktere(1, "Thor", "Asgard", List.of(produkten1, produkten5, produkten9));

        Charaktere c2 = new Charaktere(2, "Black Panther", "Wakanda", List.of(produkten2, produkten8));
        Charaktere c3 = new Charaktere(3, "Iron Man", "Terra", List.of(produkten5, produkten7, produkten4));
        Charaktere c4 = new Charaktere(4, "Spider-Man", "Terra", List.of(produkten4, produkten9));

        Charaktere c5 = new Charaktere(5, "Doctor Strange", "Multiverse", List.of(produkten10, produkten9, produkten3));

        charakterenRepo.create(c1);
        charakterenRepo.create(c2);
        charakterenRepo.create(c3);
        charakterenRepo.create(c4);
        charakterenRepo.create(c5);

        consoleView.start();
        scanner.close();
    }

}
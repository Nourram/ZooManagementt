package tn.esprit.gestionzoo.entities;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        System.out.println("Welcome to the Zoo management system");

        Scanner input = new Scanner(System.in);
        System.out.print("Insert zoo name: ");
        String zooName = input.nextLine();

        System.out.print("Insert city: ");
        String city = input.nextLine();

        Zoo myZoo = new Zoo(zooName, city);
        myZoo.displayZoo();

        Animal lyon  = new Animal("lyon", "Simba", 14, true);
        Animal tiger = new Animal("tiger", "Bagira", 10, true);
        Animal zebra = new Animal("zebra", "Marty", 6, true);
        Animal simba2 = new Animal("lyon", "Simba", 5, true); // même nom (test unicité)

        System.out.println("\n--- Ajouts ---");
        System.out.println("Ajout Simba: "   + myZoo.addAnimal(lyon));
        System.out.println("Ajout Bagira: "  + myZoo.addAnimal(tiger));
        System.out.println("Ajout Marty: "   + myZoo.addAnimal(zebra));
        System.out.println("Ajout Simba (doublon nom): " + myZoo.addAnimal(simba2));
        myZoo.displayAnimals();
        System.out.println("Zoo plein ? " + myZoo.isZooFull());

        System.out.println("\n--- Suppression de 'Marty' ---");
        System.out.println("remove(Marty) = " + myZoo.removeAnimal(zebra));
        myZoo.displayAnimals();

        System.out.println("\n--- Remplissage jusqu'à capacité ---");
        while (!myZoo.isZooFull()) {
            int idx = myZoo.getAnimalCount();
            myZoo.addAnimal(new Animal("dummy", "A" + idx, 1, true));
        }
        System.out.println("Zoo plein ? " + myZoo.isZooFull());
        System.out.println("Tentative d'ajouter un 26e animal : "
                + myZoo.addAnimal(new Animal("dummy", "Overflow", 1, true)));

        myZoo.displayAnimals();

        Zoo other = new Zoo("Belvédère 2", city);
        other.addAnimal(new Animal("elephant", "Dumbo", 5, true));
        Zoo winner = Zoo.comparerZoo(myZoo, other);
        System.out.println("\nZoo avec le plus d'animaux : " + winner.getName()
                + " (" + winner.getAnimalCount() + "/" + Zoo.MAX_CAGES + ")");
    }
}

package tn.esprit.gestionzoo.entities;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        System.out.println("===== Bienvenue dans le système de gestion du Zoo =====");

        Scanner input = new Scanner(System.in);
        System.out.print("Insérer le nom du zoo : ");
        String zooName = input.nextLine();

        System.out.print("Insérer la ville : ");
        String city = input.nextLine();

        Zoo myZoo = new Zoo(zooName, city);
        myZoo.displayZoo();

        // ======================
        // Tests avec Animal & Zoo
        // ======================
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

        // ==========================
        // Prosit 5 – Instructions 20 à 24
        // ==========================
        System.out.println("\n===== Prosit 5 : Animaux spécialisés =====");

        // Création d’objets spécifiques
        Aquatic aq = new Aquatic("Sea Turtle", 40, false, "océan");
        Terrestrial te = new Terrestrial("Lion", 8, true, 4);
        Dolphin d1 = new Dolphin("Flipper", 12, 9.5f, "mer");
        Penguin p1 = new Penguin("Skipper", 5, 120.0f, "antarctique");

        // Affichage (toString redéfinis)
        System.out.println("\n=== Affichage des animaux ===");
        System.out.println(aq);
        System.out.println(te);
        System.out.println(d1);
        System.out.println(p1);

        // Test de la méthode swim()
        System.out.println("\n=== Test de swim() ===");
        aq.swim();   // générique (Aquatic)
        d1.swim();   // redéfini (Dolphin)
        p1.swim();   // hérité (Penguin)

        // Ajout au zoo
        System.out.println("\n=== Ajout des nouveaux animaux dans le zoo ===");
        myZoo.addAnimal(aq);
        myZoo.addAnimal(te);
        myZoo.addAnimal(d1);
        myZoo.addAnimal(p1);

        myZoo.displayAnimals();

        // Comparaison entre deux zoos
        Zoo otherZoo = new Zoo("Belvédère", "Tunis");
        otherZoo.addAnimal(new Animal("elephant", "Dumbo", 5, true));

        Zoo biggestZoo = Zoo.comparerZoo(myZoo, otherZoo);
        System.out.println("\nLe zoo avec le plus d'animaux est : " + biggestZoo.getName());

        input.close();
        System.out.println("\n===== Fin du programme ✅ =====");
    }
}

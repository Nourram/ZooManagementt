package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Employe;
import tn.esprit.gestionzoo.entities.SocieteArrayList;

public class Main {
    public static void main(String[] args) {
        SocieteArrayList societe = new SocieteArrayList();

        Employe e1 = new Employe(1, "Guesmi", "Sarah", "RH", 3);
        Employe e2 = new Employe(2, "Zarrouk", "Aziz", "Finance", 2);
        Employe e3 = new Employe(3, "Menzli", "Omar", "Production", 1);
        Employe e4 = new Employe(4, "Ben Abdallah", "Malek", "IT", 4);

        // Ajout
        societe.ajouterEmploye(e1);
        societe.ajouterEmploye(e2);
        societe.ajouterEmploye(e3);
        societe.ajouterEmploye(e4);

        System.out.println("=== Liste initiale ===");
        societe.afficherEmploye();

        //  Recherche
        System.out.println("\nRecherche par nom 'Ayari' : " + societe.rechercherEmploye("Ayari"));
        System.out.println("Recherche par objet e3 : " + societe.rechercherEmploye(e3));

        //  Tri par ID
        System.out.println("\n=== Tri par ID ===");
        societe.trierEmployeParId();
        societe.afficherEmploye();

        //  Tri par Département + Grade
        System.out.println("\n=== Tri par Département et Grade ===");
        societe.trierEmployeParNomDepartementEtGrade();
        societe.afficherEmploye();

        // Suppression
        System.out.println("\nSuppression de e2...");
        societe.supprimerEmploye(e2);
        societe.afficherEmploye();
    }
}
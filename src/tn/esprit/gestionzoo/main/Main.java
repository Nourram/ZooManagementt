package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Employe;
import tn.esprit.gestionzoo.entities.SocieteArrayList;
import tn.esprit.gestionzoo.entities.Departement;
import tn.esprit.gestionzoo.entities.DepartementHashSet;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // === PARTIE EMPLOYÉS (ton code existant) ===
        SocieteArrayList societe = new SocieteArrayList();

        Employe e1 = new Employe(1, "Ammar", "Nour", "RH", 3);
        Employe e2 = new Employe(2, "Ben saad", "Zied", "Finance", 2);
        Employe e3 = new Employe(3, "Ammar", "Olfa", "Production", 1);
        Employe e4 = new Employe(4, "Ben Abdallah", "Malek", "IT", 4);

        // Ajout
        societe.ajouterEmploye(e1);
        societe.ajouterEmploye(e2);
        societe.ajouterEmploye(e3);
        societe.ajouterEmploye(e4);

        System.out.println("=== Liste initiale des employés ===");
        societe.afficherEmploye();

        // Recherche
        System.out.println("\nRecherche par nom 'Ayari' : " + societe.rechercherEmploye("Ayari"));
        System.out.println("Recherche par objet e3 : " + societe.rechercherEmploye(e3));

        // Tri par ID
        System.out.println("\n=== Tri par ID ===");
        societe.trierEmployeParId();
        societe.afficherEmploye();

        // Tri par Département + Grade
        System.out.println("\n=== Tri par Département et Grade ===");
        societe.trierEmployeParNomDepartementEtGrade();
        societe.afficherEmploye();

        // Suppression
        System.out.println("\nSuppression de e2...");
        societe.supprimerEmploye(e2);
        societe.afficherEmploye();

        // === PARTIE DÉPARTEMENTS (Prosit 10) ===
        System.out.println("\n\n=== Gestion des départements (DepartementHashSet) ===");
        DepartementHashSet departementManager = new DepartementHashSet();

        Departement d1 = new Departement(1, "Informatique", 12);
        Departement d2 = new Departement(2, "Ressources Humaines", 5);
        Departement d3 = new Departement(3, "Comptabilité", 7);
        Departement d4 = new Departement(1, "Informatique", 20); // duplicate selon id+nom

        // Ajouter départements
        departementManager.ajouterDepartement(d1);
        departementManager.ajouterDepartement(d2);
        departementManager.ajouterDepartement(d3);
        departementManager.ajouterDepartement(d4); // ne doit pas être ajouté si equals() utilise id+nom

        // Afficher tous
        System.out.println("\nListe actuelle des départements :");
        departementManager.displayDepartement();

        // Recherche par nom
        String rechercheNom = "informatique";
        System.out.println("\nRecherche par nom '" + rechercheNom + "' : " +
                departementManager.rechercherDepartement(rechercheNom));

        // Recherche par objet (même id+nom)
        Departement testDept = new Departement(2, "Ressources Humaines", 0);
        System.out.println("Recherche par objet (id=2, nom=Ressources Humaines) : " +
                departementManager.rechercherDepartement(testDept));

        // Tri par id et affichage
        System.out.println("\nDépartements triés par id :");
        TreeSet<Departement> triParId = departementManager.trierDepartementById();
        for (Departement d : triParId) {
            System.out.println(d);
        }

        // Suppression d'un département
        System.out.println("\nSuppression du département 'Ressources Humaines'...");
        departementManager.supprimerDepartement(d2);
        System.out.println("Après suppression :");
        departementManager.displayDepartement();
    }
}

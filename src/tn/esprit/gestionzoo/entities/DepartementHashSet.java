package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.entities.Departement;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Comparator;

public class DepartementHashSet implements IDepartement<Departement> {
    private final HashSet<Departement> departements;

    public DepartementHashSet() {
        this.departements = new HashSet<>();
    }

    @Override
    public void ajouterDepartement(Departement d) {
        if (d == null) {
            System.out.println("Impossible d'ajouter un département null.");
            return;
        }
        boolean added = departements.add(d);
        if (added) {
            System.out.println("Département ajouté : " + d);
        } else {
            System.out.println("Le département existe déjà (même id et nom) : " + d);
        }
    }

    @Override
    public boolean rechercherDepartement(String nom) {
        if (nom == null) return false;
        for (Departement d : departements) {
            // comparaison insensible à la casse pour être plus tolérant
            if (d.getNom() != null && d.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(Departement t) {
        if (t == null) return false;
        // utilise contains() qui s'appuie sur equals() et hashCode()
        return departements.contains(t);
    }

    @Override
    public void supprimerDepartement(Departement t) {
        if (t == null) {
            System.out.println("Impossible de supprimer un département null.");
            return;
        }
        boolean removed = departements.remove(t);
        if (removed) {
            System.out.println("Département supprimé : " + t);
        } else {
            System.out.println("Département introuvable : " + t);
        }
    }

    @Override
    public void displayDepartement() {
        if (departements.isEmpty()) {
            System.out.println("Aucun département disponible.");
            return;
        }
        System.out.println("Liste des départements :");
        for (Departement d : departements) {
            System.out.println(d);
        }
    }

    @Override
    public TreeSet<Departement> trierDepartementById() {
        // TreeSet avec Comparator par id
        TreeSet<Departement> sorted = new TreeSet<>(Comparator.comparingInt(Departement::getId));
        sorted.addAll(departements);
        return sorted;
    }

    // méthode utilitaire : obtenir le HashSet (si besoin)
    public HashSet<Departement> getDepartements() {
        return new HashSet<>(departements); // renvoyer une copie pour sécurité
    }
}

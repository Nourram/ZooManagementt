package tn.esprit.gestionzoo.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * Représente un employé.
 */
public class Employe implements Comparable<Employe>, Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nom;
    private String prenom;
    private String nomDepartement;
    private int grade;

    // Constructeur sans paramètre
    public Employe() {}

    // Constructeur principal
    public Employe(int id, String nom, String prenom, String nomDepartement, int grade) {
        this.id = id;
        this.setNom(nom);
        this.prenom = prenom;
        this.nomDepartement = nomDepartement;
        this.grade = grade;
    }

    // Constructeur pratique minimal
    public Employe(int id, String nom, String prenom) {
        this(id, nom, prenom, null, 0);
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) {
        // validation minimale : nom ne doit pas être null ou vide
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être null ou vide.");
        }
        this.nom = nom.trim();
    }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNomDepartement() { return nomDepartement; }
    public void setNomDepartement(String nomDepartement) { this.nomDepartement = nomDepartement; }

    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }

    /**
     * Retourne le nom complet (prénom + nom) si disponibles.
     */
    public String getFullName() {
        if (prenom == null || prenom.isBlank()) return nom;
        return prenom + " " + nom;
    }

    // equals : on considère deux employés égaux si leur id et leur nom sont identiques
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;
        Employe employe = (Employe) o;
        return id == employe.id && Objects.equals(nom, employe.nom);
    }

    // hashCode cohérent avec equals
    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nomDepartement='" + nomDepartement + '\'' +
                ", grade=" + grade +
                '}';
    }

    /**
     * Tri naturel par id (utile pour TreeMap, tri, etc.).
     */
    @Override
    public int compareTo(Employe other) {
        return Integer.compare(this.id, other == null ? Integer.MIN_VALUE : other.id);
    }
}

package tn.esprit.gestionzoo.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * Représente un département.
 */
public class Departement implements Comparable<Departement>, Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nom;
    private int nombreEmployes;

    // Constructeur sans paramètre
    public Departement() {}

    // Constructeur principal
    public Departement(int id, String nom, int nombreEmployes) {
        this.id = id;
        this.setNom(nom);
        this.nombreEmployes = nombreEmployes;
    }

    // Constructeur pratique minimal
    public Departement(int id, String nom) {
        this(id, nom, 0);
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du département ne peut pas être null ou vide.");
        }
        this.nom = nom.trim();
    }

    public int getNombreEmployes() { return nombreEmployes; }
    public void setNombreEmployes(int nombreEmployes) { this.nombreEmployes = nombreEmployes; }

    // equals : comparation par id et nom
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departement)) return false;
        Departement that = (Departement) o;
        return id == that.id &&
                Objects.equals(nom, that.nom);
    }

    // hashCode cohérent avec equals
    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    // toString
    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nombreEmployes=" + nombreEmployes +
                '}';
    }

    // Tri naturel : par id croissant
    @Override
    public int compareTo(Departement other) {
        if (other == null) return 1;
        return Integer.compare(this.id, other.id);
    }
}

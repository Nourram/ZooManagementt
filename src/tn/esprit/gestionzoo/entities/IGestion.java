package tn.esprit.gestionzoo.entities;


public interface IGestion<T> {
    void ajouterEmploye(T t);
    boolean rechercherEmploye(String nom);
    boolean rechercherEmploye(T t);
    void supprimerEmploye(T t);
    void afficherEmploye();

    void trierEmployeParId(); // Comparable
    void trierEmployeParNomDepartementEtGrade(); // Comparator
}
package tn.esprit.gestionzoo.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AffectationHashMap {
    private HashMap<Employe, Departement> map;

    public AffectationHashMap() {
        map = new HashMap<>();
    }

    // Instruction 2
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        map.put(e, d);
    }

    // Instruction 3
    public void afficherEmployesEtDepartements() {
        System.out.println("Liste des Employés et leurs Départements :");
        for(Map.Entry<Employe, Departement> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Instruction 4
    public void supprimerEmploye(Employe e) {
        map.remove(e);
    }

    // Instruction 5
    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        map.remove(e, d); // suppression si la pair correspond vraiment
    }

    // Instruction 6
    public void afficherEmployes() {
        System.out.println("Employés : " + map.keySet());
    }

    // Instruction 7
    public void afficherDepartements() {
        System.out.println("Départements : " + map.values());
    }

    // Instruction 8
    public boolean rechercherEmploye(Employe e) {
        return map.containsKey(e);
    }

    // Instruction 9
    public boolean rechercherDepartement(Departement d) {
        return map.containsValue(d);
    }

    // Instruction 10
    public TreeMap<Employe, Departement> trierMap() {
        return new TreeMap<>(map); // tri selon compareTo() de Employe
    }
}

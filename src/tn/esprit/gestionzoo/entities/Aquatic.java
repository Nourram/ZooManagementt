package tn.esprit.gestionzoo.entities;

/**
 * Famille aquatique : caractérisée par 'habitat'
 * (ex. "mer", "océan", "lac", "aquarium", etc.).
 */
public class Aquatic extends Animal {

    private String habitat; // lieu de vie

    public Aquatic() {
        // Constructeur par défaut pour Instruction 21
        // Valeurs par défaut raisonnables
        setFamily("Aquatic");
        setName("Unknown Aquatic");
        setAge(0);
        setMammal(false);
        setHabitat("unknown");
    }

    public Aquatic(String name, int age, boolean mammal, String habitat) {
        super("Aquatic", name, age, mammal);
        setHabitat(habitat);
    }

    public String getHabitat() { return habitat; }

    public void setHabitat(String habitat) {
        if (habitat == null || habitat.trim().isEmpty()) {
            throw new IllegalArgumentException("L'habitat ne peut pas être vide.");
        }
        this.habitat = habitat.trim();
    }

    /** Instruction 24 */
    public void swim() {
        System.out.println("This aquatic animal is swimming.");
    }

    @Override
    public String toString() {
        return "Aquatic{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", isMammal=" + isMammal() +
                ", habitat='" + habitat + '\'' +
                '}';
    }
}

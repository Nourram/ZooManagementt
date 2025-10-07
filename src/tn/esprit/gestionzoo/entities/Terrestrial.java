package tn.esprit.gestionzoo.entities;

/**
 * Famille terrestre : caractérisée par 'nbrLegs'.
 */
public class Terrestrial extends Animal {

    private int nbrLegs; // nombre de pattes

    public Terrestrial() {
        // Constructeur par défaut
        setFamily("Terrestrial");
        setName("Unknown Terrestrial");
        setAge(0);
        setMammal(true);
        setNbrLegs(4);
    }

    public Terrestrial(String name, int age, boolean mammal, int nbrLegs) {
        super("Terrestrial", name, age, mammal);
        setNbrLegs(nbrLegs);
    }

    public int getNbrLegs() { return nbrLegs; }

    public void setNbrLegs(int nbrLegs) {
        if (nbrLegs < 0) {
            throw new IllegalArgumentException("Le nombre de pattes ne peut pas être négatif.");
        }
        this.nbrLegs = nbrLegs;
    }

    @Override
    public String toString() {
        return "Terrestrial{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", isMammal=" + isMammal() +
                ", nbrLegs=" + nbrLegs +
                '}';
    }
}


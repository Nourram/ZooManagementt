package tn.esprit.gestionzoo.entities;

/**
 * Pingouin : un animal aquatique caractérisé par 'swimmingDepth' (profondeur max de nage).
 */
public class Penguin extends Aquatic {

    private float swimmingDepth; // mètres

    public Penguin() {
        // Constructeur par défaut
        super(); // initialise Aquatic par défaut
        setName("Penguin");
        // Un pingouin n'est pas un mammifère
        setMammal(false);
        setSwimmingDepth(0.0f);
    }

    public Penguin(String name, int age, float swimmingDepth, String habitat) {
        super(name, age, false, habitat); // mammifère = false
        setSwimmingDepth(swimmingDepth);
    }

    public float getSwimmingDepth() { return swimmingDepth; }

    public void setSwimmingDepth(float swimmingDepth) {
        if (swimmingDepth < 0f) {
            throw new IllegalArgumentException("La profondeur de nage ne peut pas être négative.");
        }
        this.swimmingDepth = swimmingDepth;
    }

    // NOTE: on n'écrase pas swim() ici -> hérite du comportement générique d'Aquatic.

    @Override
    public String toString() {
        return "Penguin{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", isMammal=" + isMammal() +
                ", habitat='" + getHabitat() + '\'' +
                ", swimmingDepth=" + swimmingDepth +
                '}';
    }
}

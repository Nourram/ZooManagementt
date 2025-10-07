package tn.esprit.gestionzoo.entities;

/**
 * Dauphin : un animal aquatique caractérisé par 'swimmingSpeed' (vitesse de nage).
 */
public class Dolphin extends Aquatic {

    private float swimmingSpeed; // m/s par ex.

    public Dolphin() {
        // Constructeur par défaut
        super(); // initialise Aquatic par défaut
        setName("Dolphin");
        // Un dauphin est un mammifère
        setMammal(true);
        setSwimmingSpeed(0.0f);
    }

    public Dolphin(String name, int age, float swimmingSpeed, String habitat) {
        super(name, age, true, habitat); // mammifère = true
        setSwimmingSpeed(swimmingSpeed);
    }

    public float getSwimmingSpeed() { return swimmingSpeed; }

    public void setSwimmingSpeed(float swimmingSpeed) {
        if (swimmingSpeed < 0f) {
            throw new IllegalArgumentException("La vitesse de nage ne peut pas être négative.");
        }
        this.swimmingSpeed = swimmingSpeed;
    }

    /** Instruction 24 : redéfinition */
    @Override
    public void swim() {
        System.out.println("This dolphin is swimming.");
    }

    @Override
    public String toString() {
        return "Dolphin{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", isMammal=" + isMammal() +
                ", habitat='" + getHabitat() + '\'' +
                ", swimmingSpeed=" + swimmingSpeed +
                '}';
    }
}

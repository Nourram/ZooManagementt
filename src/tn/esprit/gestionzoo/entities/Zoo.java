package tn.esprit.gestionzoo.entities;

public class Zoo {

    public static final int MAX_CAGES = 25;

    private final Animal[] animals = new Animal[MAX_CAGES];
    private int animalCount = 0;

    private String name;
    private String city;

    public Zoo() {
        this("Mon Zoo", "Tunis");
    }

    public Zoo(String name, String city) {
        setName(name);
        setCity(city);
    }

    // --- Encapsulation: accès via getters/setters ---
    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom d'un Zoo ne doit pas être vide.");
        }
        this.name = name.trim();
    }

    public String getCity() { return city; }

    public void setCity(String city) {
        this.city = (city == null) ? "" : city.trim();
    }

    public int getAnimalCount() { return animalCount; }

    public void displayZoo() {
        System.out.println("Zoo name: " + name + ", City: " + city + ", Cages: " + MAX_CAGES);
    }

    public void displayAnimals() {
        System.out.println("----- Animals in " + name + " -----");
        if (animalCount == 0) {
            System.out.println("(aucun animal)");
            return;
        }
        for (int i = 0; i < animalCount; i++) {
            System.out.println("[" + i + "] " + animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        if (animal == null || animal.getName() == null) return -1;
        String target = animal.getName().trim();
        for (int i = 0; i < animalCount; i++) {
            Animal cur = animals[i];
            if (cur != null && cur.getName() != null
                    && cur.getName().equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    public int searchAnimalByName(String name) {
        if (name == null) return -1;
        for (int i = 0; i < animalCount; i++) {
            Animal cur = animals[i];
            if (cur != null && name.equalsIgnoreCase(cur.getName())) return i;
        }
        return -1;
    }


    public boolean isZooFull() {
        return animalCount >= MAX_CAGES;
    }


    public boolean addAnimal(Animal animal) {
        if (animal == null) return false;
        if (isZooFull()) return false;
        if (searchAnimal(animal) != -1) return false;
        animals[animalCount++] = animal;
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        int idx = searchAnimal(animal);
        if (idx == -1) return false;
        for (int i = idx; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1 == null) return z2;
        if (z2 == null) return z1;
        if (z1.animalCount > z2.animalCount) return z1;
        if (z2.animalCount > z1.animalCount) return z2;
        return z1;
    }
}

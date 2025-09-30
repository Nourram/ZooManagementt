package tn.esprit.gestionzoo.entities;

import java.util.Objects;

public class Animal {
    private int age;
    private String name;
    private String family;
    private boolean mammal;

    public Animal() {
        // defaults
    }

    public Animal(String family, String name, int age, boolean mammal) {
        setFamily(family);
        setName(name);
        setAge(age);
        setMammal(mammal);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("L'âge d'un animal ne peut pas être négatif.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'animal ne peut pas être vide.");
        }
        this.name = name.trim();
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        if (family == null || family.trim().isEmpty()) {
            throw new IllegalArgumentException("La famille de l'animal ne peut pas être vide.");
        }
        this.family = family.trim();
    }

    public boolean isMammal() {
        return mammal;
    }

    public void setMammal(boolean mammal) {
        this.mammal = mammal;
    }

    public void displayAnimal() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Animal{name='" + name + "', family='" + family + "', age=" + age + ", isMammal=" + mammal + "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal other = (Animal) o;
        return name != null && other.name != null
                && name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name == null ? null : name.toLowerCase());
    }
}

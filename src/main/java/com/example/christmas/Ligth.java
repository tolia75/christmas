package com.example.christmas;

import java.util.Objects;

public class Ligth {

    private Coordonnees coordonnees;
    private boolean isOn;

    public Ligth(int hauteur, int largeur) {
        this.coordonnees = new Coordonnees(hauteur, largeur);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ligth ligth = (Ligth) o;
        return isOn == ligth.isOn &&
                Objects.equals(coordonnees, ligth.coordonnees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordonnees, isOn);
    }

    public int getHauteur() {
        return coordonnees.getHauteur();
    }

    public int getLargeur() {
        return coordonnees.getLargeur();
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }
    public boolean isInRange(Coordonnees coordonnees1, Coordonnees coordonnees2) {
        return coordonnees.getHauteur() >= coordonnees1.getHauteur() &&
        coordonnees.getHauteur() <= coordonnees2.getHauteur() &&
                coordonnees.getLargeur() >= coordonnees1.getLargeur() &&
                coordonnees.getLargeur() <= coordonnees2.getLargeur();
    }

    public boolean isNotInRange(Coordonnees coordonnees1, Coordonnees coordonnees2) {
        return !isInRange(coordonnees1, coordonnees2);
    }
}
